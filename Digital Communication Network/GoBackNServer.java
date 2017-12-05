import java.io.*;
import java.util.*;
import java.net.*;

class GoBackNServer 
{
	public static void main(String[] args)
	{
		try
		{
			ServerSocket ss=new ServerSocket(6665);
			ss.setSoTimeout(10000);
			String	str;
			String[] input = {"1","2","3","4", "5", "6","7"}; 
			Thread t=new Thread();
			System.out.println("The server is now ready.");
			Socket s =ss.accept();//establishes connection 
			DataInputStream dis=new DataInputStream(s.getInputStream());
			DataOutputStream dout=new DataOutputStream(s.getOutputStream());
			int j=input.length;
			int i=0;
			int window=4;
			for (int k = 0; k < window; k++)
			{
				  str=(String)dis.readUTF();
				  t.sleep(3000);
				  if(k!=0)
				  {
					  
				  }
			      else if(k==0)
			      {
			       System.out.println("Frame received= "+str);
			       System.out.println("ACK 2 sent.");
			       System.out.println("");
			       dout.writeUTF(input[k+1]);
			       dout.flush();
			     }     
			}
			System.out.println("");
			System.out.println("");
			System.out.println("");
			int c=2;
			for (int k = 1; k < window; k++)
			{
			       str=(String)dis.readUTF();
			       System.out.println("Frame received= "+str);       
			       t.sleep(3000);
			       System.out.println("ACK "+(c+1)+" sent\n");
			       System.out.println("");
			       c++;
			       dout.writeUTF(input[k+1]);
			       dout.flush();
			}
			dout.close();
			ss.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}


/* OUTPUT

The server is now ready.
Frame received= 1
ACK 2 sent.




Frame received= 2
ACK 3 sent


Frame received= 3
ACK 4 sent


Frame received= 4
ACK 5 sent



*/
