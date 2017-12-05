		/* TWO PASS ASSEMBLER */
		
/* Problem Definition:
 *Design and implement 2 pass assembler.
 */

/* Input Files:
Source Code: input.txt
Machine Opcode Table: mot.txt
Pseudo Opcode Table: pot.txt
*/

/* Output Files:
Pass 1: output_pass1.txt
Symbol Table: output_symbolTable.txt
Literal Table: output_literalTable.txt

Pass 2: output_pass2.txt
*/

import java.util.*;
import java.io.*;



public class Assembler{
	static Vector<MOT> mot=new Vector();
	static Vector<String> pot=new Vector();
	static Vector<ST> SymbolTable=new Vector();
	static Vector<LT> LitTable=new Vector();
	
	static int lc;
	
	static PrintWriter output_pass1;
	
	static PrintWriter output_pass2;
	static int line_no;
	static Vector lcTable=new Vector();	
	static Map<Integer, Integer> BaseTable = new HashMap<>();
		
	public static void main (String[] args) throws Exception{
		initialize();
		
		/* ---START TIMER--*/
		long startTime = System.currentTimeMillis();
		
		
		System.out.println("\n---PASS 1 Starts---");
		pass1();	
		long end_pass1 = System.currentTimeMillis();
		System.out.println("\n---PASS 1 Complete---");
		
		System.out.println("\n---PASS 2 Starts---");
		pass2();
		long end_pass2 = System.currentTimeMillis();
		
		System.out.println("\n---PASS 2 Complete---");	
		
		long pass1_time = end_pass1 - startTime;
		long pass2_time = end_pass2 - startTime;
		
		System.out.println("\nExecution time for Pass 1 is " + pass1_time + " milli seconds");
		System.out.println("Execution time for Both Passes is " + pass2_time + " milli seconds");				
		
	}
	
	//---INITIALIZE THE TABLES- MOT and POT (Starts)---
	static void initialize() throws Exception{
		BufferedReader br;
		String s;
		
		br = new BufferedReader(new InputStreamReader(new FileInputStream("mot.txt")));
		while((s = br.readLine()) != null){
			StringTokenizer st = new StringTokenizer(s, " \t", false);
			mot.addElement(new MOT(st.nextToken(), st.nextToken(), st.nextToken(), st.nextToken()));
		}
		
		br = new BufferedReader(new InputStreamReader(new FileInputStream("pot.txt")));
		while((s = br.readLine()) != null){
			pot.addElement(s);
		}						
	}	
	//---INITIALIZE THE TABLES- MOT and POT (Ends)---	
		
	
	//---PASS 1 (Starts)---	
	static void pass1() throws Exception{
		BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
							
		output_pass1 = new PrintWriter(new FileWriter("output_pass1.txt"), true);	
		
		PrintWriter output_symbol = new PrintWriter(new FileWriter("output_symbolTable.txt"), true);
		PrintWriter output_literal = new PrintWriter(new FileWriter("output_literalTable.txt"), true);
		
		String s;
		
		while((s = input.readLine()) != null){
			StringTokenizer st = new StringTokenizer(s, " \t", false);
			int n = st.countTokens();
			String[] entry = new String[n];		//entry- each line of input
			
			for(int i=0; i<n; i++){
				entry[i] = st.nextToken();		//entry[i]- each word of each line
			}
			
			if(searchPOT1(entry) == false){
				searchMOT1(entry);
				output_pass1.println(s);
			}
			
			lcTable.addElement(lc);	
		//	System.out.println(s);				//to print input		
		}
		
		
		
		String output = new String();
		
		//Printing Symbol Table (Starts)
		System.out.println("\nSymbol Table:");
		System.out.println("Symbol\tValue\tLength\tRelocation");
		
		for(ST i : SymbolTable){
			output = i.sym + "\t" + i.value + "\t\t" + i.length + "\t\t" + i.reloc;
			
			System.out.println(output);
			output_symbol.println(output);					
		}
		//Printing Symbol Table (Ends)
		
		//Printing Literal Table (Starts)
		System.out.println("\nLiteral Table:");
		System.out.println("Literal\tValue\tLength\tRelocation");
		
		for(LT i : LitTable){
			output = i.lit + "\t" + i.value + "\t\t" + i.length + "\t\t" + i.reloc;
			
			System.out.println(output);
			output_literal.println(output);					
		}
		//Printing Literal Table (Ends)
		
	}
	//---PASS 1 (Ends)---
	
		
	//---SEARCH POT for PASS 1 (Starts)---
	static boolean searchPOT1(String[] str){
		int i = 0;				//i=0 indicates that label is absent
		int len = 0;			//l- length of operands
		int pot_index=0;	
			
		if(str.length == 3){	//i=1 indicates that label is present
			i = 1;
		}
		
		str = separateOperands(str);
		
		if(str[i].equalsIgnoreCase("DC") || str[i].equalsIgnoreCase("DS")){
			pot_index = 1;
		}
		if(str[i].equalsIgnoreCase("EQU")){
			pot_index = 2;
		}
		if(str[i].equalsIgnoreCase("START")){
			pot_index = 3;
		}
		if(str[i].equalsIgnoreCase("LTORG")){
			pot_index = 4;
		}
		if(str[i].equalsIgnoreCase("END")){
			pot_index = 5;
		}
		
		switch(pot_index){
			//DC or DS
			case 1:			
				String x = str[i+1];
				int index_f = x.indexOf("F");
				
				if(i ==1){	//label is present means that it contains only one constant
					SymbolTable.addElement(new ST(str[0], lc, 4, "R"));
				}
				
				if(index_f != 0){	//Ends with F ie. DS statement
					len = Integer.parseInt(x.substring(0, x.length()-1));	//Contains (length-1) constants
					len = len * 4;
				}
				else{				//Starts with F ie. DC statement
					for(int j=i+1; j<str.length; j++){
						len = len + 4;
					}
				}
				
				lc = lc + len;
			return true;		//Pseudo-op is present so return true
			
			//EQU	
			case 2:			
				if(!str[2].equals("*")){
					SymbolTable.addElement(new ST(str[0], Integer.parseInt(str[2]), 4, "A"));					
				}
				else{					
					SymbolTable.addElement(new ST(str[0], lc, 1, "R"));	
				}
			return true;	//Pseudo-op is present so return true
			
			
			//START
			case 3:
				SymbolTable.addElement(new ST(str[0], Integer.parseInt(str[2]), 1, "R"));
			return true;	//Pseudo-op is present so return true
			
			//LTORG
			case 4:
				ltorg(false);
			return true;	//Pseudo-op is present so return true
			
			//END
			case 5:
				ltorg(true);
			return true;	//Pseudo-op is present so return true									
		}
		
		return false;		//Pseudo-op is absent so return false
		
	}
	//---SEARCH POT for Pass 1 (Ends)---
	
	
	//---SEARCH MOT for PASS 1 (Starts)---
	static void searchMOT1(String[] str){
		MOT m = new MOT();
		
		int i = 0;				//i=0 indicates that label is absent					
		if(str.length == 3){	//i=1 indicates that label is present
			i = 1;
		}	
		
		str = separateOperands(str);
		
		for(int j=i+1; j<str.length; j++){
			if(str[j].startsWith("=")){
				LitTable.addElement(new LT(str[j].substring(1, str[j].length()), -1, 4, "R"));
			}
		}
		
		if((i == 1) && (!str[0].equalsIgnoreCase("END"))){
			SymbolTable.addElement(new ST(str[0], lc , 4, "R"));
		}
		
		for(MOT x : mot){
			if(str[i].equals(x.mnemonic)){
				m = x;
				break;
			}
		}
		
		lc = lc + m.length;
		
	}
	//---SEARCH MOT for PASS 1 (Ends)---
	
	
	//---SEPARATE OPERANDS IF IT CONTAINS COMMA (Starts)---
	static String[] separateOperands(String[] str){
		Vector<String> str1 = new Vector<>();
	//	List str1 = new LinkedList();
		
		for(int j=0; j<str.length-1; j++){
			str1.addElement(str[j]);			
		}
		
		StringTokenizer st = new StringTokenizer(str[str.length-1], " ,", false);
		while(st.hasMoreTokens()){
			str1.addElement(st.nextToken());
		}
		
		str = str1.toArray(new String[0]);
		return str;
	}
	//---SEPARATE OPERANDS IF IT CONTAINS COMMA (Ends)---

	
	//--LTORG Function (Starts)---
	static void ltorg(boolean isEnd) {
		Iterator<LT> itr = LitTable.iterator();
		LT lt = new LT();
		boolean isBroken = false;	//value is assigned
		
		while(itr.hasNext()) {
			lt = itr.next();
			if(lt.value == -1) {
				isBroken = true;	//value is not assigned
				break;
			}
		}
		
		if(!isBroken) {			//if value is assigned then return
			return;
		}
		if(!isEnd) {			//if not END then find next lc for assigning values
			while(lc%8 != 0) {
				lc++;
			}
		}
		
		lt.value = lc;
		lc = lc + 4;
		while(itr.hasNext()) {
			lt = itr.next();
			lt.value = lc;
			lc = lc + 4;
		}
	}
	//---LTORG Function (Ends)---
	
	
	//---PASS 2 (Starts)---
	static void pass2() throws Exception{
		line_no = 0;
		output_pass2 = new PrintWriter(new FileWriter("output_pass2.txt"),true);
		//Output of pass 1 is input to pass 2
		BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream("output_pass1.txt")));	
		
		String s;
		
		//Print input for pass 2 ie. output of pass 1
		System.out.println("Pass 1 Output: ");
		while((s = input.readLine()) != null){
			System.out.println(s);
			
			StringTokenizer st = new StringTokenizer(s, " \t", false);
			int n = st.countTokens();
			String[] entry = new String[n];		//entry- each line of input
			
			for(int i=0; i<n; i++){
				entry[i] = st.nextToken();		//entry[i]- each word of each line
			}
			
			if(searchPOT2(entry) == false){
				searchMOT2(entry);
			}
			line_no++;			
		}
		
		//Print output of Pass 2
		System.out.println("\nPASS 2 Output:");
		BufferedReader printing = new BufferedReader(new InputStreamReader(new FileInputStream("output_pass2.txt")));
		while((s=printing.readLine()) != null){
			System.out.println(s);
		}
		
	}
	//---PASS 2 (Ends)---
	
	
	//---SEARCH POT for PASS 2 (Starts)---
	static boolean searchPOT2(String[] str){
		int i = 0;				//i=0 indicates that label is absent
					
		if(str.length == 3){	//i=1 indicates that label is present
			i = 1;
		}
		
		if(Collections.binarySearch(pot, str[i]) >= 0){
			if(str[i].equalsIgnoreCase("USING")){
				str = separateOperands(str);
				
				if(str[i+1].equals("*")){
					str[i+1] = lcTable.get(line_no) + "";				
				}
				else{
					for(int j=i+1; j<str.length; j++){
						int value = getSymbolValue(str[j]);
						if(value != -1){
							str[j] = value + "";							
						}
					}
				}
				
				BaseTable.put(new Integer(str[i+2].trim()), new Integer(str[i+1].trim()));
			}
			return true;
		}
		return false;		
	}
	//---SEARCH POT for PASS 2 (Ends)---
	
	
	//---SEARCH MOT for PASS 1 (Starts)---
	static void searchMOT2(String[] str){
		MOT m = new MOT();
		int i = 0;				//i=0 indicates that label is absent
		int j;
		
		if(str.length==3){		//i=1 indicates that label is present
			i=1;
		}
		
		str = separateOperands(str);
		
		for(MOT x : mot){
			if(str[i].equals(x.mnemonic)){
				m = x;
				break;
			}
		}
		
		String output = new String();
		String mask = new String();
		
		if(str[i].equals("BNE")){
			mask = "7";				
		} else if(str[i].equals("BR")){
			mask = "15";
		} else{
			mask = "0";
		}
		
		if(str[i].startsWith("B")){
			if(str[i].endsWith("R")){
				str[i] = "BCR";
			} else{
				str[i] = "BC";
			}
			List<String> temp = new ArrayList<>();
			for (String x : str){
				temp.add(x);				
			}
			temp.add(i+1, mask);
			str = temp.toArray(new String[0]);
		}
		
		if(m.format.equals("RR")){
			output = str[i];
			for(j=str[i].length();j<6;j++){
				output = output + " ";				
			}
			for(j=i+1; j<str.length; j++){
				int value = getSymbolValue(str[j]);
				if(value != -1){
					str[j] = value + "";						
				}
			}
			output = output + str[i+1];
			for(j=i+2; j<str.length;j++){
				output = output + ", " + str[j];
			}
		} else{
			output = str[i];
			for(j=str[i].length(); j<6; j++){
				output = output + " ";
			}
			for(j=i+1; j<str.length-1; j++){
				int value = getSymbolValue(str[j]);
				if(value != -1){
					str[j] = value + "";
				}
			}
			str[j] = createOffset(str[j]);
			output = output + str[i+1];
			for(j=i+2; j<str.length; j++){
				output = output + ", "+ str[j];
			}
		}
		output_pass2.println(output);
	}
	//---SEARCH MOT for PASS 2 (Ends)---
	
		
	//---Return Value of Symbol from Symbol Table
	static int getSymbolValue(String str) {
		for(ST st : SymbolTable) {
			if(str.equalsIgnoreCase(st.sym)) {
				return st.value;
			}
		}
		return -1;
	}
	
	//---Return Value of Literal from Literal Table
	static int getLiteralValue(String str) {
		str = str.substring(1, str.length());
		for(LT lt : LitTable) {
			if(str.equalsIgnoreCase(lt.lit)) {
				return lt.value;
			}
		}
		return -1;
	}
	
	//---CREATE OFFSET (Starts)
	static String createOffset(String s) {
		String original = s;
		Integer[] key = BaseTable.keySet().toArray(new Integer[0]);
		int offset, new_offset;
		int index = 0;
		int value = -1;
		int index_reg = 0;
		if(s.startsWith("=")) {
			value = getLiteralValue(s);
		} else {
			int paranthesis = s.indexOf("(");
			String index_string = new String();
			if(paranthesis != -1) {
				s = s.substring(0, s.indexOf("("));
				index_string = original.substring(original.indexOf("(")+1, original.indexOf(")"));
				index_reg = getSymbolValue(index_string);
			}
			value = getSymbolValue(s);
		}
		offset = Math.abs(value - BaseTable.get(key[index]));
		for(int i=1 ; i<key.length ; i++) {
			new_offset = Math.abs(value - BaseTable.get(key[i]));
			if(new_offset < offset) {
				offset = new_offset;
				index = i;
			}
		}
		String result = offset + "(" + index_reg + ", " + key[index] + ")";
		return result;
	}
}


//---CLASSES FOR EACH TABLE (Starts)---

class MOT{
	String mnemonic, bin_opcode, format;
	int length;
	
	MOT(){}

	MOT(String m, String b, String l, String f){
		mnemonic=m;
		bin_opcode=b;
		length=Integer.parseInt(l);
		format=f;
	}	
}
/*
class POT{
	String pseudo_op;
		
	POT(String p){
		pseudo_op=p;
	}
}*/

class ST{
	String sym, reloc;		//sym- Symbol, reloc- Relocation bit
	int value, length;
	
	ST(String s, int v, int l, String r){
		sym=s;
		value=v;
		length=l;
		reloc=r;
	}
}

class LT{
	String lit, reloc;		//lit- Literal, reloc- Relocation bit
	int value, length;
	
	LT(){}
	
	LT(String lt, int v, int l, String r){
		lit=lt;
		value=v;
		length=l;
		reloc=r;
	}
}
//---CLASSES FOR EACH TABLE (Ends)---


/* OUTPUT-1
 *
 *---PASS 1 Starts---

Symbol Table:
Symbol  Value   Length  Relocation
JOHN    0       1       R
FOUR    12      4       R
FIVE    16      4       R
TEMP    20      4       R

Literal Table:
Literal Value   Length  Relocation

---PASS 1 Complete---

---PASS 2 Starts---
Pass 1 Output: 
    USING   *,15
    L   1,FIVE
    A   1,FOUR
    ST  1,TEMP

PASS 2 Output:
L     1, 16(0, 15)
A     1, 12(0, 15)
ST    1, 20(0, 15)

---PASS 2 Complete---

Execution time for Pass 1 is 11 milli seconds
Execution time for Both Passes is 14 milli seconds
*/

/* OUTPUT-2
 *
 *---PASS 1 Starts---

Symbol Table:
Symbol  Value   Length  Relocation
JIMIT   0       1       R
XYZ 5       4       A
A   24      4       R
B   28      4       R

Literal Table:
Literal Value   Length  Relocation
F'5'    8       4       R
F'1'    32      4       R

---PASS 1 Complete---

---PASS 2 Starts---
Pass 1 Output: 
    USING   *,15
    L   1,B
    L   2,=F'5'
    USING   *,14
    AR  1,2
    ST  1,=F'1'
    ST  1,A
    BR  14

PASS 2 Output:
L     1, 28(0, 15)
L     2, 8(0, 15)
AR    1, 2
ST    1, 24(0, 14)
ST    1, 16(0, 14)
BCR   15, 14

---PASS 2 Complete---

Execution time for Pass 1 is 5 milli seconds
Execution time for Both Passes is 9 milli seconds
*/