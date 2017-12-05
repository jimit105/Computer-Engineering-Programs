import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.MessageDigest;

public class Server {
    public static void main(String[] args) throws Exception{        
        
        System.out.println("----SERVER----");
        
        ServerSocket ssA = new ServerSocket(6666);
        ServerSocket ssB = new ServerSocket(6667);
        ServerSocket ssC = new ServerSocket(6668);
        
        Socket sA = ssA.accept();
        Socket sB = ssB.accept();
        Socket sC = ssC.accept();
                
        
        DataInputStream disA = new DataInputStream(sA.getInputStream());
        DataInputStream disB = new DataInputStream(sB.getInputStream());
        DataInputStream disC = new DataInputStream(sC.getInputStream());
        
        String bidA = (String)disA.readUTF();
        System.out.println("Bid by Client A is Rs. " + bidA);
        String hashA = (String)disA.readUTF();
        String hashedBidA = calculateHash(bidA);
        if(hashA.equals(hashedBidA))
            System.out.println("Hash Value of Client A Matches");
        else
            System.out.println("Hash Value of Client A Does Not Match");
        
        System.out.println();
        
        String bidB = (String)disB.readUTF();
        System.out.println("Bid by Client B is Rs. " + bidB);
        String hashB = (String)disB.readUTF();
        String hashedBidB = calculateHash(bidB);
        if(hashB.equals(hashedBidB))
            System.out.println("Hash Value of Client B Matches");
        else
            System.out.println("Hash Value of Client B Does Not Match");
        
        System.out.println();
        
        String bidC = (String)disC.readUTF();
        System.out.println("Bid by Client C is Rs. " + bidC);
        String hashC = (String)disC.readUTF();
        String hashedBidC = calculateHash(bidC);
        if(hashC.equals(hashedBidC))
            System.out.println("Hash Value of Client C Matches");
        else
            System.out.println("Hash Value of Client C Does Not Match");
        
        System.out.println();
        
        System.out.println("----VERDICT----");
        if(Integer.parseInt(bidA) >= Integer.parseInt(bidB) && Integer.parseInt(bidA) >= Integer.parseInt(bidC))
            System.out.println("Client A Wins The Bid");
        else if(Integer.parseInt(bidB) >= Integer.parseInt(bidA) && Integer.parseInt(bidB) >= Integer.parseInt(bidC))
            System.out.println("Client B Wins The Bid");
        else if(Integer.parseInt(bidC) >= Integer.parseInt(bidA) && Integer.parseInt(bidC) >= Integer.parseInt(bidB))
            System.out.println("Client C Wins The Bid");
        
        
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
