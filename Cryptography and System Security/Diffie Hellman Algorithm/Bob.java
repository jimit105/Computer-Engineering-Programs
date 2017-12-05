import java.net.Socket;
import java.io.*;
import java.util.*;

public class Bob{
	public static void main (String[] args) throws Exception {
		Socket bob_eve = new Socket("localhost", 6565);
		
				
		System.out.println("----BOB----");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("\nEnter y: ");
		int y = sc.nextInt();
                System.out.println();
		
		//Receive the values of p and g from Eve (Server)
		DataInputStream din = new DataInputStream(bob_eve.getInputStream());
		String P = (String)din.readUTF();
                String G = (String)din.readUTF();
                
                System.out.println("Received P and G from Alice");
                
                int p = Integer.parseInt(P);
		int g = Integer.parseInt(G);
		
                System.out.println();
		
		//Calculate R2
		int r2 = (int)(Math.pow(g, y) % p);
		
		
		//Receive R3 from Alice, but actually from Eve
		String r3 = (String)din.readUTF();
		System.out.println("Received R1: " + r3 + " from Alice"); //Actually receiving R3 from Eve
                
                System.out.println();
                
		DataOutputStream dout = new DataOutputStream(bob_eve.getOutputStream());
		dout.writeUTF(Integer.toString(r2));
		System.out.println("Sending R2: " + r2 + " to Alice");  //Actually sending to Eve
		
	}
}