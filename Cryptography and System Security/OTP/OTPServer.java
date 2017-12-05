
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Jimit
 */
public class OTPServer {
    public static void main(String[] args) {
        try{
            ServerSocket ss = new ServerSocket(6666);
            Socket s = ss.accept();
            
            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            
            System.out.println("---OTP Server---");
            
            int clientID = -1;
            String loginRequest = (String)dis.readUTF();
            System.out.println("Login Request Received");
            System.out.println("Client: " + loginRequest);
            
            if(loginRequest.substring(0, 1).compareToIgnoreCase("A") == 0)
                clientID = 1;
            else if(loginRequest.substring(0, 1).compareToIgnoreCase("B") == 0)
                clientID = 2;
            
            int randomNum = ThreadLocalRandom.current().nextInt(10000, 99999);
            System.out.println("Challenge Sent: " + randomNum);
            String challenge = Integer.toString(randomNum);
            
            dout.writeUTF("Challenge: " + challenge);   //send challenge to client
            dout.flush();
            
            
            String loginReply = (String)dis.readUTF();
            System.out.println("Response Received");
            System.out.println("Client's Reply: " + loginReply);
            
            boolean correctResponse = false;
            
            if(clientID == 1){
                int challengeReply = Integer.parseInt(loginReply);
                if(challengeReply == findSumOfDigits(randomNum))
                    correctResponse = true;
                else
                    System.out.println("Expected Response: " + findSumOfDigits(randomNum));
                
            } else if(clientID == 2){
                if(loginReply.compareToIgnoreCase(findReverse(Integer.toString(randomNum))) == 0)
                    correctResponse = true;
                else
                    System.out.println("Expected Response: " + findReverse(Integer.toString(randomNum)));
                
            }
            
            if(correctResponse){
                System.out.println("OTP Verfied. Access Granted to " + loginRequest +".");
                dout.writeUTF("OTP Verified. Access Granted!");
                dout.flush();
                
            } else{
                System.out.println("Incorrect OTP entered by " + loginRequest + ".");
                dout.writeUTF("Incorrect OTP. Access Denied!");
                dout.flush();
                
            }
            
            dout.close();
            ss.close();
            
            
        } catch(IOException | NumberFormatException e){
            System.out.println(e);
            
        }
    }
    
    public static int findSumOfDigits(int num){
        int sum = 0;
        while(num > 0){
            sum += num % 10;
            num = num / 10;
        }
        return sum;
    }
    
    public static String findReverse(String num){
        char temp = ' ';
        String reverse = "";
        for(int i = 0 ; i < num.length() ; i++){
            temp = num.charAt(i);
            reverse = temp + reverse;
        }
        return reverse;
    }
}
