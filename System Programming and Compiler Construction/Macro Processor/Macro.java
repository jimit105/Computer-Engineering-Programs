		/* 2 PASS MACRO PROCESSOR */

/* Problem Definition:
 *Design and implement 2 pass Macro Processor
 */

/* Input Files:
 *Source Code: input.txt
 */
 
/* Output Files:
 *MNT: output_mnt.txt
 *MDT: output_mdt.txt
 *Pass 1 ALA: output_ala_pass1.txt
 *Pass 1 Output: output_pass1.txt
 *Pass 2 ALA: output_ala_pass2.txt
 *Pass 2 Output: output_pass2.txt
 */ 

import java.util.*;
import java.io.*;

//---CLASS for MNT (Starts)---
class MNT{
	String macro_name;
	int index;
	
	MNT(String s, int i){
		macro_name = s;
		index = i;
	}
	
	public String toString(){
		return(macro_name + " " + index);
	}
	
}
//---CLASS for MNT (Ends)---

class Macro{
	static Vector<MNT> mnt = new Vector<>();
	static List<String> mdt = new ArrayList<>();
	static int mntc = 0;
	static int mdtc = 0;
	static int mdtp;
	static List<List<String>> ala = new LinkedList<>();			//For multiple ALAs.. so List of List
	static Map<String, Integer> ala_macro = new HashMap<>();;	//To bind ALA with Macro
	
	static BufferedReader input;
	
	public static void main (String[] args) throws Exception{
				
		long startTime = System.currentTimeMillis();

		System.out.println("\n---PASS 1 Starts---");
		pass1();	
		long end_pass1 = System.currentTimeMillis();		
		System.out.println("\n---PASS 1 Complete---");
		
		System.out.println("\n---PASS 2 Starts---");
		pass2();
		long end_pass2 = System.currentTimeMillis();
		System.out.println("\n---PASS 2 Complete---");
		
		long pass1_time = end_pass1-startTime;
		long pass2_time = end_pass2-startTime;
		
		System.out.println("\nExecution time of Pass 1 is " + pass1_time + " milli seconds");
		System.out.println("Execution time for Both Passes is " + pass2_time + " milli seconds");
	}
	
	//---PASS 1 (Starts)---
	static void pass1() throws Exception{
		String s = new String();
		input = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		PrintWriter output = new PrintWriter(new FileOutputStream("output_pass1.txt"), true);
		
		while((s=input.readLine()) != null){
			if(s.equalsIgnoreCase("MACRO")){
				processMacro();
			} else {
				output.println(s);	
			}
		}
		
		System.out.println("\nMNT: ");
		displayMNT();
		System.out.println("\nMDT: ");
		displayMDT();
		System.out.println("\nALA: ");
		displayALA(1);
	}
	//---PASS 1 (Ends)---
	
	
	//---PROCESS MACRO DEFINITION (Starts)---
	static void processMacro() throws Exception{
		String str = input.readLine();			//Macro Definition
		String macro_name = str.substring(0, str.indexOf("\t"));
		
		mnt.add(new MNT(macro_name, mdtc));		//add to MNT table
		mntc++;		
		alaPass1(str);					//Generate ALA for Macro
		
		StringTokenizer st = new StringTokenizer(str, " ,\t", false);
		String s = st.nextToken();		//macro-name
		for(int i=s.length(); i<12; i++){
			s = s + " ";			
		}
		
		String token = new String();
		token = st.nextToken();		//first argument
		s = s + token;
		while(st.hasMoreTokens()){	//all remaining arguments
			token = st.nextToken();
			s += "," + token;
		}
		
		mdt.add(s);				//add macro name and arguments in MDT table
		mdtc++;
		addToMDT(ala.size()-1);		
	}
	//---PROCESS MACRO DEFINITION (Ends)---
	
	
	//---ALA FOR PASS 1 (Starts)---
	static void alaPass1(String s){
		StringTokenizer st = new StringTokenizer(s, " ,\t", false);
		String macro_name = st.nextToken();
		List<String> arg = new ArrayList<>();	//arguments list
		int index;
		
		while(st.hasMoreTokens()){
			String x = st.nextToken();
			if((index = x.indexOf("=")) != -1){		//for &ARG2=DATA2 (default parameters case)
				x = x.substring(0, index);
			}
			arg.add(x);							//String for all arguments
		}
		ala.add(arg);							//Add arguments in ALA
		ala_macro.put(macro_name, ala_macro.size());	//Bind ALA with Macro
	}
	//---ALA FOR PASS 1 (Ends)---
	
		
	
	//---ADD INTO MDT (Starts)---
	static void addToMDT(int ala_number) throws Exception {
		String temp = new String();
		String s = new String();
		List l = ala.get(ala_number);
		boolean isFirst;
		while(!s.equalsIgnoreCase("MEND")) {
			isFirst = true;
			s = input.readLine();
			String line = new String();
			StringTokenizer st = new StringTokenizer(s, " ,\t", false);
			temp = st.nextToken();
			for(int i=temp.length() ; i<12; i++) {
				temp += " ";
			}
			line += temp;
			while(st.hasMoreTokens()) {
				temp = st.nextToken();
				if(temp.startsWith("&")) {
					int x = l.indexOf(temp);
					temp = ",#" + x;
					isFirst = false;
				} else if(!isFirst) {
					temp = "," + temp;
				}
				line += temp;
			}
			mdt.add(line);
			mdtc++;
		}
	}
	//---ADD INTO MDT (Ends)---
	
	
	//---DISPLAY ALA (Starts)---
	static void displayALA(int pass) throws Exception{
		PrintWriter output = new PrintWriter(new FileOutputStream("output_ala_pass" + pass + ".txt"), true);
		for(List l : ala){
			System.out.println(l);	//Directly display output
			output.println(l);		//Adding to output file
		}
	}
	//---DISPLAY ALA (Ends)---
	
		
	//---DISPLAY MNT (Starts)---
	static void displayMNT() throws Exception{
		PrintWriter output = new PrintWriter(new FileOutputStream("output_mnt.txt"), true);
		for(MNT l: mnt){
			System.out.println(l);
			output.println(l);
		}
	}
	//---DISPLAY MNT (Ends)---
	
		
	//---DISPLAY MDT (Starts)---
	static void displayMDT() throws Exception{
		PrintWriter output = new PrintWriter(new FileOutputStream("output_mdt.txt"), true);
		for(String l: mdt){
			System.out.println(l);
			output.println(l);
		}
	}
	//---DISPLAY MDT (Ends)---
	
	
	//---PASS 2 (Starts)---
	static void pass2() throws Exception{
		input = new BufferedReader(new InputStreamReader(new FileInputStream("output_pass1.txt")));
		PrintWriter output = new PrintWriter(new FileOutputStream("output_pass2.txt"), true);
		String token = new String();
		String str;
		
		while((str = input.readLine()) != null){		//Each line of pass1 output
			StringTokenizer st = new StringTokenizer(str, " \t", false);
			while(st.hasMoreTokens()){
				token = st.nextToken();
				if(st.countTokens() > 2){
					token = st.nextToken();
				}
				
				MNT x = null;
				for(MNT m : mnt){						//Check if macro name is there in MNT
					if(m.macro_name.equalsIgnoreCase(token)){
						x = m;
						break;
					}
				}
				
				if(x != null){
					mdtp = x.index;
					List<String> l = alaPass2(str);
					mdtp++;
					String temp = new String();
					
					while(!(temp = mdt.get(mdtp)).trim().equalsIgnoreCase("MEND")) {
						String line = new String();
						StringTokenizer st2 = new StringTokenizer(temp, " ,\t",false);
						for(int i=0 ; i<12 ; i++) {
							line += " ";
						}
						String opcode = st2.nextToken();
						line += opcode;
						for(int i=opcode.length() ; i<24 ; i++) {
							line += " ";
						}
						line += st2.nextToken();
						while(st2.hasMoreTokens()) {
							String token2 = st2.nextToken();
							int index;
							if((index = token2.indexOf("#")) != -1) {
								line += "," + l.get(Integer.parseInt(token2.substring(index+1,index+2)));
							}
						}
						mdtp++;
						output.println(line);
						System.out.println(line);
					}
					break;
				}else {
					output.println(str);
					System.out.println(str);
					break;
				}
			}
		}
		System.out.println("\nALA: ");
		displayALA(2);
	}
	//---PASS 2 (Ends)---
	
	
	//---ALA for PASS 2 (Starts)---
	static List<String> alaPass2(String s) {
		StringTokenizer st = new StringTokenizer(s, " \t", false);
		int num_tokens = st.countTokens();
		String macro_name = st.nextToken();
		int ala_no = ala_macro.get(macro_name);
		List<String> l = ala.get(ala_no);
		int ctr = 0;
		StringTokenizer st2 = null;
		try {
			st2 = new StringTokenizer(st.nextToken(), ",", false);
			while(st2.hasMoreTokens()) {
				l.set(ctr, st2.nextToken());
				ctr++;
			}
		} catch(Exception e) {
			// do nothing
		}
		if(ctr < num_tokens) {
			String s2 = mdt.get(mdtp);
			StringTokenizer st3 = new StringTokenizer(s2, " ,\t", false);
			String token = new String();
			int index = 0;
			while(st3.hasMoreTokens()) {
				token = st3.nextToken();
				if((index = token.indexOf("=")) != -1) {
					try {
						l.set(ctr++, token.substring(index+1, token.length()));
					} catch(Exception e) {
						// do nothing
					}
				}
			}
		}
		ala.set(ala_no, l);
		return l;
	}
	//---ALA for PASS 2 (Ends)---
	
}


/* OUTPUT-1
 *
 *---PASS 1 Starts---

MNT: 
INCR1 0
INCR2 4

MDT: 
INCR1       &ARG1,&ARG2
A           1,#0
A           2,#1
MEND        
INCR2       &ARG4,&ARG5=5
L           1,#0
L           2,#1
MEND        

ALA: 
[&ARG1, &ARG2]
[&ARG4, &ARG5]

---PASS 1 Complete---

---PASS 2 Starts---
PRG START
    USING   *,15
            A                       1,DATA1
            A                       2,DATA2
            L                       1,DATA3
            L                       2,5
DATA1   DC  F'5'
DATA2   DC  F'10'
DATA3   DC  F'15'
    END

ALA: 
[DATA1, DATA2]
[DATA3, 5]

---PASS 2 Complete---

Execution time of Pass 1 is 10 milli seconds
Execution time for Both Passes is 14 milli seconds

*/