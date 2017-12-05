//Eve is acting as the server
//Alice and Bob are acting as Clients

//Port between Eve and Alice: 6666
//Port between Eve and Bob: 6565

import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;
import java.util.*;

public class Eve{
	public static void main (String[] args) throws Exception {
		ServerSocket eve_alice = new ServerSocket(6666);
		ServerSocket eve_bob = new ServerSocket(6565);
						
		System.out.println("----EVE----");
		
		Socket socket_alice = eve_alice.accept();
		Socket socket_bob = eve_bob.accept();
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("\nEnter z: ");
		int z = sc.nextInt();
		
		//Receive values of p and g from Alice			
                DataInputStream br_alice = new DataInputStream(socket_alice.getInputStream());
	
		
		String P = (String)br_alice.readUTF();
		String G = (String)br_alice.readUTF();
		
                int p = Integer.parseInt(P);
                int g = Integer.parseInt(G);
                
                System.out.println();
                System.out.println("Received P and G from Alice");
                System.out.println("Sending P and G to Bob");
                System.out.println();
		
		//Send the values of p and g to Bob				
                DataOutputStream bw_bob = new DataOutputStream(socket_bob.getOutputStream());
		bw_bob.writeUTF(P);
                bw_bob.flush();
		bw_bob.writeUTF(G);
                bw_bob.flush();
		
		
		//Calculate R3
		int r3 = (int)(Math.pow(g, z) % p);
                System.out.println("Value of R3: " + r3);
                System.out.println();
		
		//Received R1 from Alice
		String r1 = (String)br_alice.readUTF();
		System.out.println("Received R1: " + r1 + " from Alice");
		
		//Send R3 to Bob
		System.out.println("Sending R3: " + r3 + " to Bob");
		bw_bob.writeUTF(Integer.toString(r3));
		
                System.out.println();
		
		DataInputStream br_bob = new DataInputStream(socket_bob.getInputStream());
		
		//Receive R2 from Bob
		String r2  = (String)br_bob.readUTF();
		System.out.println("Received R2: " + r2 + " from Bob");
		
		
		//Send R3 to Alice
		DataOutputStream bw_alice = new DataOutputStream(socket_alice.getOutputStream());	
		System.out.println("Sending R3: " + r3 + " to Alice");
		bw_alice.writeUTF(Integer.toString(r3));	
	
	
		
	}
}