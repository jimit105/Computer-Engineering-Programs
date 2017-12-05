package packetanalyzer;

import java.io.IOException;
import java.util.Scanner;
import jpcap.JpcapCaptor;
import jpcap.NetworkInterface;
import jpcap.NetworkInterfaceAddress;
import jpcap.PacketReceiver;
import jpcap.packet.DatalinkPacket;
import jpcap.packet.EthernetPacket;
import jpcap.packet.ICMPPacket;
import jpcap.packet.IPPacket;
import jpcap.packet.Packet;
import jpcap.packet.TCPPacket;
import jpcap.packet.UDPPacket;

/**
 *
 * @author Jimit Dholakia
 */

/* Useful Links:

http://www.sipinspector.com/download/jpcap/JPcap_tutorial
 */

public class PacketAnalyzer implements PacketReceiver {

    static int i = 0;

    //DO NOT modify the sequence of protocols
    String protocol[] = {"HOPOPT", "ICMP", "IGMP", "GGP", "IPV4", "ST", "TCP", "CBT", "EGP", "IGP", "BBN", "NV2", "PUP", "ARGUS", "EMCON", "XNET", "CHAOS", "UDP", "mux"};

    public static void main(String[] args) throws IOException {

        //    System.out.println(System.getProperty("java.library.path"));
        // TODO code application logic here
        //Obtain the list of network interfaces
        NetworkInterface[] devices = JpcapCaptor.getDeviceList();

        for (int i = 0; i < devices.length; i++) {
            //Print its name and description
            System.out.println(i + ": " + devices[i].name + "(" + devices[i].description + ")");

            //Print its datalink name and description
            System.out.println("Datalink: " + devices[i].datalink_name + "(" + devices[i].datalink_description + ")");

            //Print MAC Address
            System.out.print("MAC Address: ");
            for (byte b : devices[i].mac_address) {
                System.out.print(Integer.toHexString(b & 0xff) + ((i < devices[i].mac_address.length - 1) ? ":" : " "));
            }
            System.out.println();

            //Print its IP Address, Subnet Mask and Broadcast Address
            for (NetworkInterfaceAddress addr : devices[i].addresses) {
                System.out.println("Address: " + addr.address + "\t" + addr.subnet + "\t" + addr.broadcast);
            }

            System.out.println();

        }

        int netw_inter;
        int num_pkt;
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("\nSelect Network Interface: ");
            netw_inter = sc.nextInt();
            System.out.print("\nEnter number of packets to be captured (-1 for infinite): ");
            num_pkt = sc.nextInt();
        }

        //Open an interface with openDevice(NetworkInterface intrface, int snaplen, boolean promics, int to_ms)
        //intrface - Network interface that you want to open.
        //snaplen - Max number of bytes to capture at once.
        //tp_ms - Set a capture timeout value in milliseconds.
        JpcapCaptor jpcap = JpcapCaptor.openDevice(devices[netw_inter], 65535, true, 20);
        jpcap.loopPacket(num_pkt, new PacketAnalyzer());

    }

    @Override
    public void receivePacket(Packet packet) {
        System.out.println("\n---------------------------------------------------------");
        System.out.println("PACKET " + i + ": ");
        System.out.print("Packet: " + packet + "\n");
        i++;

        IPPacket ip_pkt = (IPPacket) packet;

        if (packet != null) {
            int protocol_number = ip_pkt.protocol;
            String protocol_name = protocol[protocol_number];

            System.out.println("\n---NETWORK LAYER ANALYSIS---\n");

            if (ip_pkt.dont_frag) {
                System.out.println("Do Not Fragment: " + 1);
            } else {
                System.out.println("Do Not Fragment: " + 0);
            }

            System.out.println("Source IP: " + ip_pkt.src_ip);
            System.out.println("Destination IP: " + ip_pkt.dst_ip);
            System.out.println("Hop Limit: " + ip_pkt.hop_limit);
            System.out.println("Identification Field: " + ip_pkt.ident);
            System.out.println("Packet Length: " + ip_pkt.length);
            System.out.println("Packet Priority: " + ip_pkt.priority);
            System.out.println("Type of Service: " + ip_pkt.rsv_tos);
            if (ip_pkt.r_flag) {
                System.out.println("Reliable Transmission: " + 1);
            } else {
                System.out.println("Reliable Transmission: " + 0);
            }
            System.out.println("Protocol Version: " + ip_pkt.version);
            System.out.println("Flow Label: " + ip_pkt.flow_label);

            System.out.println("\n---DATALINK LAYER ANALYSIS---\n");
            DatalinkPacket dl_pkt = packet.datalink;
            EthernetPacket e_pkt = (EthernetPacket) dl_pkt;

            System.out.println("Source MAC Address: " + e_pkt.getSourceAddress());
            System.out.println("Destination MAC Address: " + e_pkt.getDestinationAddress());

            System.out.println("\n---PROTOCOL ANALYSIS---\n");

            //For TCP Packet
            if (protocol_name.equals("TCP")) {
                System.out.println("TCP PACKET");

                TCPPacket tcp_pkt = (TCPPacket) packet;
                System.out.println("Destionation Port of TCP: " + tcp_pkt.dst_port);

                if (tcp_pkt.ack) {
                    System.out.println("Acknowledgement: " + 1);
                } else {
                    System.out.println("Acknowledgment: " + 0);
                }

                if (tcp_pkt.rst) {
                    System.out.println("Reset Connection: " + 1);
                } else {
                    System.out.println("Reset Connection: " + 0);
                }

                System.out.println("Protocol Version: " + tcp_pkt.version);
                System.out.println("Source IP: " + tcp_pkt.src_ip);
                System.out.println("Destination IP: " + tcp_pkt.dst_ip);

                if (tcp_pkt.fin) {
                    System.out.println("More Data: " + 0);
                } else {
                    System.out.println("More Data: " + 1);
                }

                if (tcp_pkt.syn) {
                    System.out.println("Request for Connection: " + 1);
                }

                //For ICMP Packet
            } else if (protocol_name.equals("ICMP")) {
                System.out.println("ICMP PACKET");

                ICMPPacket icmp_pkt = (ICMPPacket) packet;

                System.out.println("Alive Time: " + icmp_pkt.alive_time);
                System.out.println("Number of adverstised addresses: " + icmp_pkt.addr_num);
                System.out.println("MTU of the Packet: " + icmp_pkt.mtu);
                System.out.println("Subnet Mask: " + icmp_pkt.subnetmask);
                System.out.println("Source IP: " + icmp_pkt.src_ip);
                System.out.println("Destionation IP: " + icmp_pkt.dst_ip);
                System.out.println("Checksum: " + icmp_pkt.checksum);
                System.out.println("ICMP Type: " + icmp_pkt.type);

                //For UDP Packet
            } else if (protocol_name.equals("UDP")) {
                System.out.println("UDP PACKET");

                UDPPacket udp_pkt = (UDPPacket) packet;
                System.out.println("Source Port: " + udp_pkt.src_port);
                System.out.println("Destionation Port: " + udp_pkt.dst_port);

            }

        }

    }

}
