package ipspoofing;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import jpcap.JpcapCaptor;
import jpcap.NetworkInterface;
import jpcap.NetworkInterfaceAddress;
import jpcap.PacketReceiver;
import jpcap.packet.IPPacket;
import jpcap.packet.Packet;

/**
 *
 * @author Jimit Dholakia
 */

/* Useful Links:

http://www.sipinspector.com/download/jpcap/JPcap_tutorial
 */
public class IPSpoofing implements PacketReceiver {

    static int i = 0;

    //DO NOT modify the sequence of protocols
    String protocol[] = {"HOPOPT", "ICMP", "IGMP", "GGP", "IPV4", "ST", "TCP", "CBT", "EGP", "IGP", "BBN", "NV2", "PUP", "ARGUS", "EMCON", "XNET", "CHAOS", "UDP", "mux"};

    public static void main(String[] args) throws Exception {

        //    System.out.println(System.getProperty("java.library.path"));
        // TODO code application logic here
        //Obtain the list of network interfaces
        NetworkInterface[] devices = JpcapCaptor.getDeviceList();

        for (@SuppressWarnings("LocalVariableHidesMemberVariable")
int i = 0; i < devices.length; i++) {
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
        jpcap.loopPacket(num_pkt, new IPSpoofing());

    }

    @Override
    public void receivePacket(Packet packet) {
        System.out.println("\n---------------------------------------------------------");
        System.out.println("PACKET " + i + ": ");
        //     System.out.print("Packet: " + packet + "\n");
        i++;

        String[] blacklist = new String[]{"/192.168.0.100"};
        String[] whitelist = new String[]{"/fe80:0:0:0:6524:92db:b5ed:1254"};

        IPPacket ip_pkt = (IPPacket) packet;

        if (packet != null) {
            int protocol_number = ip_pkt.protocol;
            String protocol_name = protocol[protocol_number];

            System.out.println("Source IP: " + ip_pkt.src_ip);
            //          System.out.println("Destination IP: " + ip_pkt.dst_ip);

            if (Arrays.asList(blacklist).contains(ip_pkt.src_ip.toString())) {
                System.out.println("Source IP in Blacklist");
                System.out.println("PACKET REJECTED!");
                
                try {
                    ip_pkt.setIPv4Parameter(0, true, true, true, i, true, true, true, 10, 10, 10, 4, InetAddress.getByName("192.168.0.105"), InetAddress.getByName("192.168.0.110"));
                    
                    if(ip_pkt.src_ip.toString().equals("/192.168.0.105")){
                        System.out.println("Source IP: " + ip_pkt.src_ip);
                        System.out.println("IP SPOOFED!");
                        
                    }
                        
                    
                } catch (UnknownHostException ex) {
                    Logger.getLogger(IPSpoofing.class.getName()).log(Level.SEVERE, null, ex);
                }
                

            } else if (Arrays.asList(whitelist).contains(ip_pkt.src_ip.toString())) {
                System.out.println("Source IP is in Whitelist");
                System.out.println("PACKET ACCEPTED!");

            } else {
                System.out.println("UNKNOWN PACKET DETECTED!");
            }

        }

    }

}
