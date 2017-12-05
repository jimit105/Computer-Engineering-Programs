/* Transposition Cipher */

import java.io.BufferedReader;
import java.util.Scanner;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TransCipher{
  public static void main(String[] args) throws IOException{
  	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Scanner sc = new Scanner(System.in);
    
    System.out.print("Enter number of columns: ");
    int n = sc.nextInt();
    
    //Order of matrix in which the cipher key is to be displayed
    int[] order = new int[n];
    
    System.out.print("Enter Plain Text: ");
    String ptext = br.readLine();
    ptext = ptext.replaceAll("\\s+","");
    
    System.out.print("Enter order: ");
    for(int i=0; i<n; i++){
    	order[i] = sc.nextInt();
    }
    
    System.out.println("\nPlain Text: " + ptext);
    
    
    char[] ptext_arr = ptext.toCharArray();
    
    
    //Matrix in which the key is stored
    char[][] temp = new char[n][n];
    
    
    //Assigning Default Values for characters after the string
    for(int i=0; i<n;i++)
    	for(int j=0; j<n;j++)
    		temp[i][j]='Z';
    
    
    //Encryption
    for(int i=0, j=0, k=0; k<ptext_arr.length; k++){
      temp[i][j] = ptext_arr[k];
      i++;
      
      if(i>n-1){
        i=0;
        j++;
      }
      
    }
    
    System.out.println("\nIn Matrix Form: ");
    System.out.println(Arrays.deepToString(temp));
   
   /* for (char[] row : temp){
    System.out.println(Arrays.toString(row));
   }
   */    
   	

   	//Shuffling the order of the matrix
   	char[][] orderedMatrix = new char[temp.length][];
   	
   	for(int i=0; i<temp.length; i++){   			
   		orderedMatrix[order[i]] = temp[i].clone();
   		
   	}
   	
   	System.out.println("\nOrdered Matrix: ");
   	System.out.println(Arrays.deepToString(orderedMatrix));
   	
   	   	          
    System.out.print("\nCipher Text: ");    
    
    for(int i=0;i<orderedMatrix.length;i++){
    	for(int j=0; j<orderedMatrix[i].length; j++){
    		System.out.print(orderedMatrix[i][j]);
    	}
    }
    
    
    System.out.print("\n\nDecrypted Text: ");
    
    //Decryption
    char[] decryp_text = new char[n*n];
    int k=0;    
    
    for(int i=0; i<temp.length; i++){
    	for(int j=0; j<temp[i].length; j++){    		
    		decryp_text[k++] = temp[j][i]; 		    		    	
    		
    		
    	}
    }      
    
    //Printing decrypted text
    for(int i=0; i<k; i++){
    	if(decryp_text[i]=='Z')
    		break;
    	System.out.print(decryp_text[i]);
    }      
    
  }
  
}

/* OUTPUT
 *
 *Enter number of columns: 5
Enter Plain Text: jimit dholakia
Enter order: 1 2 4 3 0

Plain Text: jimitdholakia

In Matrix Form: 
[[j, d, k, Z, Z], [i, h, i, Z, Z], [m, o, a, Z, Z], [i, l, Z, Z, Z], [t, a, Z, Z, Z]]

Ordered Matrix: 
[[t, a, Z, Z, Z], [j, d, k, Z, Z], [i, h, i, Z, Z], [i, l, Z, Z, Z], [m, o, a, Z, Z]]

Cipher Text: taZZZjdkZZihiZZilZZZmoaZZ

Decrypted Text: jimitdholakia
*/