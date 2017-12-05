		/* Recursive Descent Parser */

/* Problem Definition:
 *
 *Write a program to implement Recursive Descent Parser
 */
	
/*Grammar:

S->aX
X->XY | cd | c
Y->dS

Sample Valid Strings:
acd, acdd, acddac

*/

import java.util.*;
import java.io.*;

class RDP{
	static char[] sampleChar;
	static int ptr = 0;
	
	public static void main (String[] args) {
		System.out.println("The Grammar is: ");
		System.out.println("S->aX");
		System.out.println("X->XY | cd | c");
		System.out.println("Y->dS");
		
		Scanner sc = new Scanner(System.in);
		System.out.print("\nEnter a string: ");
		String sample = sc.nextLine();
		
		long startTime = System.currentTimeMillis();	//Start time
		
		sampleChar = sample.toCharArray();
		
		if(S()){
			System.out.println("Valid String!");			
		} else{
			System.out.println("Invalid String!");
		}
		
		long endTime = System.currentTimeMillis();		//End time
		
		long diffTime = endTime - startTime;
		
		System.out.println("\nExecution time is " + diffTime + " milli second(s)");
			
			
	}
	
	//---For S (Starts)---
	static boolean S(){
		int iptr = ptr;
				
		if(sampleChar[ptr++] != 'a'){
			ptr = iptr;
			return  false;
		}
		if(X() == false){
			ptr = iptr;
			return false;
		}
		return true;			
	}
	//---For S (Ends)---
	
	//---For X (Starts)---
	static boolean X(){
		int iptr = ptr;
	
		if(sampleChar[ptr++] == 'c'){
			if(sampleChar[ptr++] == 'd'){
				ptr = iptr;
				return true;
			}
			ptr = iptr;
			return false;
		}			
		
		else if(sampleChar[ptr++] == 'c'){
			ptr = iptr;
			return true;
		}else{			
			if(X() == false){
				ptr = iptr;
				return false;
			}
			if(Y() == false){
				ptr = iptr;
				return false;
			}			
		}
		return true;		
	}
	//---For X (Ends)---
	
	//---For Y (Starts)---
	static boolean Y(){
		int iptr = ptr;
		
		
		if(sampleChar[ptr++] != 'd'){
			ptr = iptr;
			return false;
		}
		if(S() == false){
			ptr = iptr;
			return false;
		}
		return true;
	}
	//---For Y (Ends)---
}


/* OUTPUT-1
 *
 *The Grammar is: 
S->aX
X->XY | cd | c
Y->dS

Enter a string: acddac
Valid String!

Execution time is 0 milli second(s)
*/

/* OUTPUT-2
 *
 *The Grammar is: 
S->aX
X->XY | cd | c
Y->dS

Enter a string: adaac
Invalid String!

Execution time is 0 milli second(s)
 
*/