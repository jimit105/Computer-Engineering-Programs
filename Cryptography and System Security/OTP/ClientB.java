
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Jimit
 */
public class ClientB {
    public static void main(String[] args) {
        try{
            Socket s = new Socket("localhost", 6666);
            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            
            System.out.println("---Bob---");
            
            dout.writeUTF("Bob");
            dout.flush();
            System.out.println("Login Request Sent");
            
            String challengeReceived = (String)dis.readUTF();
            System.out.println("Challenge Received");
            System.out.println(challengeReceived);  //challenge sent by server
            
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter Response: ");
            int challengeResponse = sc.nextInt();
            dout.writeUTF(Integer.toString(challengeResponse));
            dout.flush();
            
            String replyFromServer = (String)dis.readUTF();
            System.out.println(replyFromServer);
            
            dout.close();
            s.close();            
            
        } catch(IOException e){
            System.out.println(e);
            
        }
    }
    
}
