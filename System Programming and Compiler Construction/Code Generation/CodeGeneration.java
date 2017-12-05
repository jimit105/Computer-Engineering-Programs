		/* Code Generation */

import java.util.*;

class CodeGeneration {
	public static void main(String args[]) {
		System.out.print("Enter input expression: ");
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		
		char variable = 't';				//variables for intermediate expressions
		char final_variable = s.charAt(0);
		
		Map<String, String> expressions = new TreeMap<>();		//Map<Expression, Variable>
		int open_br, close_br;				//index of opening and closing brackets
		String line = new String();			//line- final output expression
		do {
			open_br = s.indexOf('(');
			if(open_br != -1) {
				close_br = s.indexOf(')');
				String x = s.substring(open_br+1, close_br);
				line += s.substring(0, open_br);
				if(expressions.get(x) == null) {
					line += variable;		//next intermediate variable
					expressions.put(x, Character.toString(variable++));
				} else {
					line += expressions.get(x);
				}
				s = s.substring(close_br+1, s.length());
			}
		} while(open_br != -1);
		line = line.substring(line.indexOf('=')+1, line.length()).trim();	//RHS of line
		
		while(line.length() > 3) {		//if it is not a 3 address code
			String expression = line.substring(0,3);
			CharSequence cs1 = expression;
			String replacement = expressions.get(expression);
			CharSequence cs2 = replacement;
			if(cs2 == null) {			//if there is no entry for the variable
				cs2 = Character.toString(variable);
				expressions.put(expression, Character.toString(variable++));
			}
			line = line.replace(cs1, cs2);
		}
		expressions.put(line, Character.toString(final_variable));		
		Iterator<String> iterator = expressions.keySet().iterator();
		while(iterator.hasNext()) {
			String x = iterator.next();
			System.out.println(expressions.get(x) + "=" + x);
		}
		createTable(expressions);
	}
	
	static String oper_string(String operator) {		//Operator in text format
		if(operator.equals("+")) {
			return "ADD";
		} else if(operator.equals("-")) {
			return "SUB";
		} else if(operator.equals("*")) {
			return "MUL";
		} else {
			return "DIV";
		}
	}
	
	static void createTable(Map<String, String> m) {
		List<String> code = new LinkedList<>();
		Map<Integer, String> register = new HashMap<>();
		Set<String> expressions = m.keySet();
		Iterator<String> iterator = expressions.iterator();
		while(iterator.hasNext()) {
			String x = iterator.next();
			String var1 = "" + x.charAt(0);
			String operator = "" + x.charAt(1);
			String var2 = "" + x.charAt(2);
			String s1 = null;
			String s2 = null;
			Iterator<Integer> setIterator = register.keySet().iterator();
			while(setIterator.hasNext()) {
				int i = setIterator.next();
				String y = register.get(i);
				if(y.equals(var1)) {
					s1 = "" + i;
				}
				if(y.equals(var2)) {
					s2 = "" + i;
				}
			}
			if((s1 == null) && (s2 == null)) {			// Register doesn't contain either of the variables
				
				s1 = "" + register.size();
				register.put(Integer.valueOf(s1), var1);
				code.add("MOV " + var1 + ", R" + s1);
				code.add(oper_string(operator) + " " + var2 + ", R" + s1);
				register.put(Integer.valueOf(s1), m.get(x));
				
			} else if((s1 != null) && (s2 != null)) {		// Registers contains both variables
				
				code.add(oper_string(operator) + " R" + s2 + ", R" + s1);
				register.put(Integer.valueOf(s1), m.get(x));
			} else {										// Register contains only one of the variables
				
				if(s1 != null) {
					code.add(oper_string(operator) + " " + var2 + ", R" + s1);
					register.put(Integer.valueOf(s1), m.get(x));
				}
				if(s2 != null) {
					code.add(oper_string(operator) + " " + var1 + ", R" + s2);
					register.put(Integer.valueOf(s2), m.get(x));
				}
			}
			if(!iterator.hasNext()) {
				setIterator = register.keySet().iterator();
				while(setIterator.hasNext()) {
					int i = setIterator.next();
					String y = register.get(i);
					if(y.equals(m.get(x))) {
						s1 = "" + i;
						code.add("MOV R" + i + ", " + m.get(x));
					}
				}
			}

			System.out.println("\n\nStatement:\n" + m.get(x) + "=" + x + "\n\nCode Generated:");
			for(String i : code) {
				System.out.println(i);
			}
			code.clear();
			System.out.println("\nRegisters:\n" + register);
		}
	}
	
	
}