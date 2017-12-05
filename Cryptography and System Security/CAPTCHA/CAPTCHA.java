import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CAPTCHA{
  public static void main(String[] args) throws IOException{
    
    int r1 = 1 + (int)(Math.random() * 10);
    
    String captcha = "";
    
    while(r1-- > 0){
      int r2 = 1 + (int)(Math.random() * 10);
      
      if(r2 < 6){
        int r3 = 1 + (int)(Math.random() * 10);
        captcha += Integer.toString(r3);
        
      } else{
        int r3 = 1 + (int)(Math.random() * 26) + 65;
        captcha += (char)r3;
        
      }
      
    }
    
    System.out.println("CAPTCHA Generated: " + captcha);
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    System.out.print("Enter CAPTCHA: ");
    String input = br.readLine();
    
    System.out.println( (input.equals(captcha) ? "CAPTCHA Matched!" : "WRONG CAPTCHA" ));
   
    
  }
}

/* OUTPUT-1:

CAPTCHA Generated: 1Q1IUB
Enter CAPTCHA:  1Q1TUB
WRONG CAPTCHA

OUTPUT-2

CAPTCHA Generated: FRS6T10B86
Enter CAPTCHA:  FRS6T10B86
CAPTCHA Matched!

*/
