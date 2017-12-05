import java.util.*;
import java.io.*;
import java.net.*;

public class StopAndWaitClient 
{
	public static void main(String[] args) 
	{
		try
		{	
			Socket s=new Socket("localhost",6666);
			DataOutputStream dout=new DataOutputStream(s.getOutputStream());
			dout.writeUTF("FRAME 0 SENT");
			Thread t=new Thread();
			t.sleep(1000);
			dout.flush();
			DataInputStream dis=new DataInputStream(s.getInputStream());
			String	str=(String)dis.readUTF();
			System.out.println(str);
			str=(String)dis.readUTF();
			System.out.println(str);
			t.sleep(500);
			dout.writeUTF("ACK 1 RECEIVED");
			dout.flush();
			dout.writeUTF("FRAME 1 SENT");
			t.sleep(700);
			dout.flush();
			dout.writeUTF("TIMER EXPIRED. FRAME 1 RESENT");
			dout.flush();
			t.sleep(700);
			t.sleep(700);
			str=(String)dis.readUTF();
			System.out.println(str);
			str=(String)dis.readUTF();
			System.out.println(str);
			t.sleep(500);
			dout.writeUTF("ACK 0 RECEIVED");
			dout.writeUTF("FRAME 0 SENT");
			t.sleep(700);
			dout.flush();
			str=(String)dis.readUTF();
			System.out.println(str);
			str=(String)dis.readUTF();
			System.out.println(str);
			t.sleep(200);
			dout.writeUTF("Timer Expired");
			dout.writeUTF("FRAME 0 RESENT");
			dout.flush();
			t.sleep(700);
			t.sleep(700);
			str=(String)dis.readUTF();
			System.out.println(str);
			str=(String)dis.readUTF();
			System.out.println(str);
			t.sleep(500);
			dout.writeUTF("ACK 1 RECEIVED");
			dout.close();
			s.close();
		}
		catch(Exception e){System.out.println(e);}
	}
}


/* OUTPUT

FRAME 0 RECEIVED
ACK 1 SENT
FRAME 1 RECEIVED
ACK 0 SENT
FRAME 0 RECEIVED
ACK 1 SENT
FRAME 0 RECEIVED
ACK 1 SENT

*/
