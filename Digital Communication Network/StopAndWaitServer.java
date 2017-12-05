import java.io.*;
import java.util.*;
import java.net.*;

public class StopAndWaitServer 
{
	public static void main(String[] args)
	{
		try
		{
			ServerSocket ss=new ServerSocket(6666);
			Socket s=ss.accept();
			System.out.println("The server is now ready:");
			DataInputStream dis=new DataInputStream(s.getInputStream());
			String	str=(String)dis.readUTF();
			System.out.println(str);
			Thread t=new Thread();
			t.sleep(400);  
			DataOutputStream dout=new DataOutputStream(s.getOutputStream());
			dout.writeUTF("FRAME 0 RECEIVED");
			dout.flush();
			dout.writeUTF("ACK 1 SENT");
			dout.flush();
			t.sleep(200);
			str=(String)dis.readUTF();
			System.out.println(str);
			str=(String)dis.readUTF();
			System.out.println(str);
			t.sleep(400); 
			dout.writeUTF("FRAME 1 RECEIVED");
			dout.flush();
			dout.writeUTF("ACK 0 SENT");
			dout.flush();
			t.sleep(400); 
			str=(String)dis.readUTF();
			System.out.println(str);
			t.sleep(400); 
			str=(String)dis.readUTF();
			System.out.println(str);
			dout.writeUTF("FRAME 0 RECEIVED");
			dout.flush();
			dout.writeUTF("ACK 1 SENT");
			dout.flush();
			t.sleep(400); 
			str=(String)dis.readUTF();
			System.out.println(str);
			t.sleep(400); 
			str=(String)dis.readUTF();
			System.out.println(str);
			dout.writeUTF("FRAME 0 RECEIVED");
			dout.flush();
			dout.writeUTF("ACK 1 SENT");
			dout.flush();
			t.sleep(400); 
			str=(String)dis.readUTF();
			System.out.println(str);
			t.sleep(400); 
			str=(String)dis.readUTF();
			System.out.println(str);
			dout.flush();
			dout.close();
			ss.close();
		}
		catch(Exception e){System.out.println(e);}
		}
}


/* OUTPUT

The server is now ready:
FRAME 0 SENT
ACK 1 RECEIVED
FRAME 1 SENT
TIMER EXPIRED. FRAME 1 RESENT
ACK 0 RECEIVED
FRAME 0 SENT
Timer Expired
FRAME 0 RESENT
ACK 1 RECEIVED

*/

