		/* Removing Left Recursion */

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.util.StringTokenizer;

class LeftRecursion{
	
	static String INPUT_FILE = "input.txt";
	
	public static void main (String[] args) throws Exception{
		
		String s;
		String s1;
		String left, right;
		String left1, right1;
		
		BufferedReader br0 = new BufferedReader(new InputStreamReader(new FileInputStream(INPUT_FILE)));	//to display input file
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(INPUT_FILE)));		//for first loop
		BufferedReader br1 = new BufferedReader(new InputStreamReader(new FileInputStream(INPUT_FILE)));	//for second loop
				
				
		//---DISPLAY INPUT FILE (Starts)---				
		String s0;
		System.out.println("The input is: ");
		while((s0 = br0.readLine()) != null){
			System.out.println(s0);
		}
		//---DISPLAY INPUT FILE (Ends)---
		
		
		//---START TIMER---
		long start_time = System.currentTimeMillis();
		
		while((s = br.readLine()) != null){
			System.out.println("\n" + s);
			StringTokenizer st = new StringTokenizer(s, " ->", false);
			left=st.nextToken();
			right=st.nextToken();	
			
						
			while((s1 = br1.readLine()) != null){
				StringTokenizer st1 = new StringTokenizer(s1, " ->", false);
				left1 = st1.nextToken();
				right1 = st1.nextToken();
//				System.out.println(right1);
				
				if(right.charAt(0) == left1.charAt(0)){
					right = right1 + right.substring(1);
					
					System.out.println(left + "->" + right);
					
				}
				
//				removeDirectRecursion(left, right);
			}
									
			removeDirectRecursion(left, right);	
					
		}
		
		
		//---END TIMER---
		long end_time = System.currentTimeMillis();
		
		System.out.println("\nTime Taken: " + (end_time - start_time) + " milli seconds");
	}
		
	
	//---REMOVE DIRECT LEFT RECURSION---	
	static void removeDirectRecursion(String left, String right){
		StringTokenizer st = new StringTokenizer(right, " |", false);
		int no_prod = st.countTokens();			//no_prod - number of productions
		String prod[] = new String[no_prod];	//prod- productions
		
//		System.out.println(no_prod);
		
		for(int i=0; i<no_prod; i++){
			prod[i] = st.nextToken();
//			System.out.println(prod[i]);
		}
		
		for(int i=0;i<no_prod;i++){
			
			if(left.charAt(0) == prod[i].charAt(0)){
				System.out.println("\nGrammar is left recursive");								//A->A*alpha | beta	<-- Given Grammar
				System.out.println(left + "\'" + "->" + prod[i].substring(1) + left + "\'");	//A'->alpha*A'
				System.out.println(left + "\'" + "->" + null);									//A'->null
				System.out.println(left + "->" + prod[++i] + left + "\'");						//A->beta*A'
				
			}
		}	
	}
		
}

/* OUTPUT
 *
 *The input is: 
A->Bxy|x
B->CD
C->A
D->d

A->Bxy|x
A->CDxy|x
A->ADxy|x

Grammar is left recursive
A'->DxyA'
A'->null
A->xA'

B->CD

C->A

D->d

Time Taken: 0 milli seconds
*/