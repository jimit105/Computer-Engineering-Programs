import java.util.*;
import java.io.*;
import java.net.*;

class GoBackNClient 
{
	public static void main(String[] args) 
	{
		try
		{	
			Socket s=new Socket("localhost",6665);
			String[] input = {"1","2","3","4", "5", "6","7"}; 
			Thread t=new Thread();
			String	str;		
			DataOutputStream dout=new DataOutputStream(s.getOutputStream());
			DataInputStream dis=new DataInputStream(s.getInputStream());
			int j=input.length;
			int i=0;
			Calendar c3 = Calendar.getInstance();
			int window=4;
			Calendar c1= Calendar.getInstance();
			System.out.println("");
			long c2 = c1.getTimeInMillis();
			System.out.println("");
			long c4 = c3.getTimeInMillis();
			System.out.println("");
			long c6 = c1.getTimeInMillis();
			System.out.println("Timer started. ");
			for (int k = 0; k < window; k++)
			{
			 	if(k==1)
			 	System.out.println("");
			 	System.out.println("Frame "+(k+1)+" sent");
			 	dout.writeUTF(input[k]);
			 	System.out.println("");
			 	dout.flush();
			 	t.sleep(3000);
			 	if (k==0)
			 	{
			 		str=(String)dis.readUTF();
			 		System.out.println("ÄCK received is = "+str);
			 	}
			 } 
			System.out.println("");
			System.out.println("Time has run out.Frame 2 was not received");
			System.out.println("Resending frames"); 
			
			for (int k = 1; k < window; k++)
			{
				System.out.println("Frame  "+(k+1)+" sent\n");
				dout.writeUTF(input[k]);
				dout.flush();
				t.sleep(3000);
				str=(String)dis.readUTF();
				System.out.println("ACK received = "+str);
			}
			dout.close();
			s.close();
		}
		catch(Exception e){System.out.println(e);}
	}
}


/*

OUTPUT:



Timer started.
Frame 1 sent

ÄCK received is = 2

Frame 2 sent

Frame 3 sent

Frame 4 sent


Time has run out.Frame 2 was not received
Resending frames
Frame  2 sent

ACK received = 3
Frame  3 sent

ACK received = 4
Frame  4 sent

ACK received = 5
*/


