import java.net.Socket;
import java.util.*;
import java.io.*;

public class Alice{
	public static void main (String[] args) throws Exception {
		Socket alice_eve = new Socket("localhost", 6666);
		
		System.out.println("----ALICE----");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("\nEnter x: ");
		int x = sc.nextInt();
		
		//Input the values of p and g		
		System.out.print("\nEnter p: ");
		int p = sc.nextInt();		
		System.out.print("Enter g: ");
		int g = sc.nextInt();
		
                System.out.println();;
		System.out.println("Sending values of P: " + p + " and G: " + g + " to Bob");   //Actually sending to Eve
                System.out.println();
		
		DataOutputStream dout = new DataOutputStream(alice_eve.getOutputStream());
		dout.writeUTF(Integer.toString(p));
                dout.flush();
                dout.writeUTF(Integer.toString(g));
                dout.flush();
                
		
		
		//Calculate R1
		int r1 = (int)(Math.pow(g, x) % p);
		
		
		//Send R1 to Bob, but Eve receives it... So send to Eve
		System.out.println("Sending R1: " + r1 + " to Bob");    //Actually sending to Eve
                dout.writeUTF(Integer.toString(r1));
		
                System.out.println();
                
		DataInputStream din = new DataInputStream(alice_eve.getInputStream());
		//Receive R3 from Eve
                String R3 = (String)din.readUTF();
		int r3 = Integer.parseInt(R3);
		System.out.println("Received R2: " + r3 + " from Bob"); //Actually received R3 from Eve
		
	}
}