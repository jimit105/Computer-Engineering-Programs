			/*Lexical Analyzer for C */

/* Problem Definition:
 *Design and implement the Lexical analyzer for C language and 
 *Construct Symbol Table, Function Table, Operator Table, Keyword Table.
*/

/*
 *@author Jimit Dholakia
 *version 1.0
 *
 */

import java.util.*;
import java.io.*;
import java.util.StringTokenizer;	//StringTokenizer to separate words

public class Lex
{
	public static void main(String args[]) throws Exception{
		
		Vector key = new Vector();		//keywords table
		Vector func = new Vector();		//functions table
		Vector oper = new Vector();		//operators table
		Vector spl = new Vector();		//special symbols table
		
		Vector sym = new Vector();		//symbols table
		Vector lit = new Vector();		//literals table
		Vector inv = new Vector();		//invalid symbols table
		
		//keywords table
		key.addElement("void");			
		key.addElement("int");
		key.addElement("float");
		key.addElement("char");
		key.addElement("long");
		key.addElement("double");
		key.addElement("if");
		key.addElement("else");
		key.addElement("while");
		key.addElement("do");
		key.addElement("for");
		key.addElement("return");
		key.addElement("include");
		key.addElement("stdio.h");
		key.addElement("conio.h");
		
		//functions table
		func.addElement("main");
		func.addElement("printf");
		func.addElement("scanf");		
		func.addElement("clrscr");
		func.addElement("getch");
		func.addElement("sqrt");
		
		//operators table
		oper.addElement("+");
		oper.addElement("-");
		oper.addElement("*");
		oper.addElement("/");
		oper.addElement("%");
		oper.addElement("=");
		oper.addElement("(");
		oper.addElement(")");
		
		//special symbols table
		spl.addElement(",");
		spl.addElement(";");
		spl.addElement("\"");
		spl.addElement("\'");
		spl.addElement("{");
		spl.addElement("}");
		spl.addElement("<");
		spl.addElement(">");
		spl.addElement("#");	
		
		/* ---START TIMER--*/
		long startTime = System.currentTimeMillis();
			
		
		/*	DISPLAY VECTOR 
		 *
		Enumeration keyEnum = key.elements();
		System.out.println("\n\nKeywords are: ");
		while(keyEnum.hasMoreElements())
			System.out.print(keyEnum.nextElement()+", ");
		
		Enumeration funcEnum = func.elements();
		System.out.println("\n\nFunctions are: ");
		while(funcEnum.hasMoreElements())
			System.out.print(funcEnum.nextElement()+", ");
			
		Enumeration operEnum = oper.elements();
		System.out.println("\n\nOperators are: ");
		while(operEnum.hasMoreElements())
			System.out.print(operEnum.nextElement()+", ");
			
		Enumeration splEnum = spl.elements();
		System.out.println("\n\nSpecial Symbols are: ");
		while(splEnum.hasMoreElements())
			System.out.print(splEnum.nextElement()+", ");
	
		//StringTokenizer Example
		String msg = "Hi, I.. am/ Jimit";
		StringTokenizer st = new StringTokenizer(msg, " ,./");
		while(st.hasMoreTokens())
		{
			System.out.println(st.nextToken());
		}
	*/	
				
		Collections.sort(key);
		Collections.sort(func);
		Collections.sort(oper);
		Collections.sort(spl);	
			
		/*Symbol and Literal Table are not sorted because their index value will change.
		 *
		 **/
				
		System.out.print("Specify input file: ");
		Scanner sc  = new Scanner(System.in);
		String file = sc.nextLine();		
		String input = readFile(file);		
		
		System.out.print("\nLoading file");
		for(int a=0;a<3;a++){
			System.out.print(".");
			Thread.sleep(500);
		}
		System.out.print("\n");
		
		System.out.print("Reading file");
		for(int a=0;a<3;a++){
			System.out.print(".");
			Thread.sleep(500);
		}
		System.out.print("\n");
		
		System.out.println("\nThe input file is: \n");
		System.out.println("---File Starts---\n");		
		System.out.println(input);
		System.out.println("--File Ends--");
		
		System.out.println("\nLegend: ");
		Thread.sleep(200);
		System.out.println("key: Keyword");
		Thread.sleep(100);
		System.out.println("func: Function");
		Thread.sleep(100);
		System.out.println("oper: Operator");
		Thread.sleep(100);
		System.out.println("spl: Special Symbol");
		Thread.sleep(100);
		System.out.println("sym: Symbol");
		Thread.sleep(100);
		System.out.println("lit: Literal");
		Thread.sleep(100);
		System.out.println("inv: Invalid Token");
		
		
		/*---StringTokenizer---
		 *
		 *http://www.javatpoint.com/string-tokenizer-in-java
		 *
		 *
		StringTokenizer(String str, String delim, boolean returnValue)
		creates StringTokenizer with specified string, delimeter and returnValue. 
		If return value is true, delimiter characters are considered to be tokens. 
		If it is false, delimiter characters serve to separate tokens.
		*/
		StringTokenizer st = new StringTokenizer(input, " \n,+-=*/%#<>(){};\"\'", true);
		int n = st.countTokens();
		String token[] = new String[n];
		for(int i=0; i<n; i++){
			token[i] = st.nextToken();
		}
		
		System.out.println("\n");
		
		System.out.print("Analyzing the file");
		for(int a=0;a<3;a++){
			System.out.print(".");
			Thread.sleep(500);
		}
		System.out.println("\n");
		
		System.out.println("---TOKENS GENERATED---");
		for(int j=0; j<n; j++){
			if(token[j].equals(" ")) {
				System.out.print(" ");
				}
			else if(token[j].equals("\n")) {
				System.out.println("\n");
				}
			else if(key.contains(token[j])){		//check if token is a keyword
				int index = Collections.binarySearch(key,token[j]);
				System.out.print("key#"+index+" ");								
			}
			else if(func.contains(token[j])){		//check if token is a function
				int index = Collections.binarySearch(func,token[j]);
				System.out.print("func#"+index+" ");
			}
			else if(oper.contains(token[j])){		//check if token is an operator
				int index = Collections.binarySearch(oper,token[j]);
				System.out.print("oper#"+index+" ");				
			}
			else if(spl.contains(token[j])){		//check if token is a special symbol
				int index = Collections.binarySearch(spl,token[j]);
				System.out.print("spl#"+index+" ");
			}
			else{									//for literals, symbols and invalid tokens
			
				/*Check is token is literal using regular expression
				 *
				 *http://stackoverflow.com/questions/15111420/how-to-check-if-a-string-contains-only-digits-in-java
				 *
				 **/
				
				String regex = "[0-9]+";	//regular expression for digits. Alternative: String regex = "\\d+";				
				
				if(token[j].matches(regex)){		//check is token is literal (constant)
					if(!lit.contains(token[j]))					
						lit.addElement(token[j]);
					
					int index = lit.indexOf(token[j]);
					System.out.print("lit#"+index+" ");
				}
				else if(token[j].substring(0,1).matches("\\d")){	//if first character is digit ie. invalid symbol
					if(!inv.contains(token[j]))
						inv.addElement(token[j]);
					int index = inv.indexOf(token[j]);
					System.out.print("inv#"+index+" ");
				}
				else{							//check is token is a symbol
					if(!sym.contains(token[j]))
						sym.addElement(token[j]);
					int index = sym.indexOf(token[j]);
					System.out.print("sym#"+index+" ");
				}	
			}
			Thread.sleep(100);			
		}
		
		System.out.println("Analysis Complete.");
		
		/* ---STOP TIMER---*/
		long endtime = System.currentTimeMillis();
		
		Enumeration symEnum = sym.elements();		//Printing Symbol Table
		System.out.println("\n\nSymbols are: ");
		while(symEnum.hasMoreElements())
			System.out.print(symEnum.nextElement()+", ");
			
		Enumeration litEnum = lit.elements();		//Printing Literal Table
		System.out.println("\n\nLiterals are: ");
		while(litEnum.hasMoreElements())
			System.out.print(litEnum.nextElement()+", ");
			
		Enumeration invEnum = inv.elements();		//Printing Invalid Tokens
		System.out.println("\n\nInvalid Tokens are: ");
		while(invEnum.hasMoreElements())
			System.out.print(invEnum.nextElement()+", ");
			
		long totalTime = endtime-startTime;
		System.out.print("\n\nElapsed time is "+totalTime+"milliseconds");
		System.out.print("\nElapsed time is "+totalTime/1000+"seconds");
		
	}	
		
	private static String readFile(String fileName) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		try{
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();
			while(line != null){
				sb.append(line);
				sb.append("\n");
				line = br.readLine();					
			}
			return sb.toString();
		}		
		finally{
			br.close();
		}
	}
		
}


/* OUTPUT
 *
 *Specify input file: input.c

Loading file...
Reading file...

The input file is:

---File Starts---

#include<stdio.h>
#include<conio.h>
void main()
{
int c,a,b=10,1d;
a=5;
c=a+b;
printf("Result is %d",c);
getch();
return 0;
}

--File Ends--

Legend:
key: Keyword
func: Function
oper: Operator
spl: Special Symbol
sym: Symbol
lit: Literal
inv: Invalid Token


Analyzing the file...

---TOKENS GENERATED---
spl#1 key#8 spl#5 key#12 spl#6

spl#1 key#8 spl#5 key#1 spl#6

key#13  func#2 oper#1 oper#2

spl#7

key#9  sym#0 spl#3 sym#1 spl#3 sym#2 oper#7 lit#0 spl#3 inv#0 spl#4

sym#1 oper#7 lit#1 spl#4

sym#0 oper#7 sym#1 oper#4 sym#2 spl#4

func#3 oper#1 spl#0 sym#3  sym#4  oper#0 sym#5 spl#0 spl#3 sym#0 oper#2 spl#4

func#1 oper#1 oper#2 spl#4

key#11  lit#2 spl#4

spl#8

Analysis Complete.


Symbols are:
c, a, b, Result, is, d,

Literals are:
10, 5, 0,

Invalid Tokens are:
1d,

Elapsed time is 14484milliseconds
Elapsed time is 14seconds
 *
 */