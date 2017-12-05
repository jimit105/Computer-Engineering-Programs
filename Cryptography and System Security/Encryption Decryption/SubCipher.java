/*Substitution Cipher */

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

class SubCipher
{
	public static void main (String[] args) throws java.lang.Exception
	{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter Key (K): ");
		int k = sc.nextInt();
		//k=3
		
		System.out.print("\nEnter Plain Text: ");
		String ptext = br.readLine();
		ptext = ptext.replaceAll("\\s+","");
		ptext = ptext.toLowerCase();
		
		System.out.println("\nPlain Text: " + ptext);
		
	 	StringBuffer msg = new StringBuffer(ptext);
	  
	  		
		//Encryption
		for(int i=0; i<msg.length(); i++){
			char temp = msg.charAt(i);
			int t = (int)temp;
			
			int r = t-97;
			
			char c = (char)((r+k)%26 + 97);
			
			msg.setCharAt(i,c);
			
		}
		
		System.out.println("\nCipher key: " + msg);
		
		
		//Decryption
		for(int i=0; i<msg.length(); i++){
			char temp = msg.charAt(i);
			int t = (int)temp;
			
			int r = t-97;
			
			char c = (char)((r-k)%26 + 97);
			
			msg.setCharAt(i,c);
			
		}
		
		System.out.println("\nPlain Text: " + msg);
	
	}
}

/* OUTPUT
 *
 *Enter Key (K): 3

Enter Plain Text: que sera sera

Plain Text: queserasera

Cipher key: txhvhudvhud

Plain Text: queserasera
*/
