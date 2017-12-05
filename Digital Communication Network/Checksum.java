import java.util.*;
 
public class Checksum
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("(Sender)Enter data:");
        String input = sc.next();
        int checksum = generate(input);
        
        System.out.println("Checksum generated = " + Integer.toHexString(checksum));
                
        System.out.println("\n(Receiver)Enter data:");
        input = sc.next();
        
        System.out.println("\nEnter the checksum generated in the sender's side:");
        checksum = Integer.parseInt((sc.next()), 16);
  
        receive(input, checksum);
    }
 
    private static int generate(String s)
    {
        String hex_value = new String();
      
        int x, i, checksum = 0;
   
        for (i = 0; i < s.length() - 2; i = i + 2)
        {
            x = (int) (s.charAt(i));
            hex_value = Integer.toHexString(x);
            x = (int) (s.charAt(i + 1));
            hex_value = hex_value + Integer.toHexString(x);
           
            System.out.println(s.charAt(i) + "" + s.charAt(i + 1) + " : "
                    + hex_value);
            x = Integer.parseInt(hex_value, 16);
            
            checksum += x;
           
        }
        if (s.length() % 2 == 0)
        {
            
            x = (int) (s.charAt(i));
            hex_value = Integer.toHexString(x);
            x = (int) (s.charAt(i + 1));
            hex_value = hex_value + Integer.toHexString(x);
            System.out.println(s.charAt(i) + "" + s.charAt(i + 1) + " : "
                    + hex_value);
            x = Integer.parseInt(hex_value, 16);
        }
        else
        {
            
            x = (int) (s.charAt(i));
            hex_value = "00" + Integer.toHexString(x);
            x = Integer.parseInt(hex_value, 16);
            System.out.println(s.charAt(i) + " : " + hex_value);
        }
        checksum += x;
        
        hex_value = Integer.toHexString(checksum);
        
        if (hex_value.length() > 4)
        {
           
            int carry = Integer.parseInt(("" + hex_value.charAt(0)), 16);
        
            hex_value = hex_value.substring(1, 5);
            
            checksum = Integer.parseInt(hex_value, 16);
            
            checksum += carry;
            
        }
        checksum = generateComplement(checksum);
        
        return checksum;
    }
 
    static void receive(String s, int checksum)
    {
        int generated_checksum = generate(s);
        
        generated_checksum = generateComplement(generated_checksum);
        
        int syndrome = generated_checksum + checksum;
      
        syndrome = generateComplement(syndrome);
       
        System.out.println("Output= " + Integer.toHexString(syndrome));
        if (syndrome == 0)
        {
            System.out.println("\nNo error");
        }
        else
        {
            System.out.println("\nError");
        }
    }
 
    static int generateComplement(int checksum)
    {
        
        checksum = Integer.parseInt("FFFF", 16) - checksum;
        return checksum;
    }
}

/* OUTPUT-1
 *
 *(Sender)Enter data:
forouzan
fo : 666f
ro : 726f
uz : 757a
an : 616e
Checksum generated = 5038

(Receiver)Enter data:
forouzan

Enter the checksum generated in the sender's side:
5038
fo : 666f
ro : 726f
uz : 757a
an : 616e
Output= 0

No error
*/

/* OUTPUT-2
 *
 *(Sender)Enter data:
forouzan
fo : 666f
ro : 726f
uz : 757a
an : 616e
Checksum generated = 5038

(Receiver)Enter data:
kennedy

Enter the checksum generated in the sender's side:
5038
ke : 6b65
nn : 6e6e
ed : 6564
y : 0079
Output= 7016

Error
*/