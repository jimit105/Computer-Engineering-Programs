import java.io.DataOutputStream;
import java.net.Socket;
import java.security.MessageDigest;
import java.util.Scanner;

public class ClientB {
    public static void main(String[] args) throws Exception{
        
        System.out.println("---- CLIENT B----");
        
        Socket s = new Socket("localhost", 6667);        
        
        
        //Input Bid
        Scanner sc = new Scanner(System.in); 
        System.out.print("\nEnter your Bid: ");
        int bid = sc.nextInt();
        System.out.println("\nYour Bid is Rs. " + bid);        
        sc.close();
        
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());
        
        dout.writeUTF(Integer.toString(bid));
        dout.flush();
        
        String hashedBid = calculateHash(Integer.toString(bid));
        System.out.println("\nHash value for Bid is " + hashedBid);
        dout.writeUTF(hashedBid);
        dout.flush();
        System.out.println("\nHash Value sent to Server");
        
        
    }
    
    static String calculateHash(String textToHash) throws Exception{
        final MessageDigest sha512 = MessageDigest.getInstance("SHA-512");
        sha512.update(textToHash.getBytes());        
        byte[] byteData = sha512.digest();
        
        StringBuilder hexData = new StringBuilder();
        for(int byteIndex = 0; byteIndex < byteData.length; byteIndex++){
            hexData.append(String.format("%02X", byteData[byteIndex]));
            
        }
        
        return hexData.toString();                  
        
    }
}
