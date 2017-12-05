import java.util.*;
import java.io.*;

class OptimizeLoop{
	static HashMap<String,ArrayList<String>> statements;
	static char loop_iterator;
	static BufferedReader reader;
	static ArrayList<String> lines;
	static ArrayList<String> loopInvariantStatements;
	static BufferedWriter writer;

	public static void main(String args[]){
		
		statements = new HashMap<String,ArrayList<String>>();
		lines = new ArrayList<String>();
		loopInvariantStatements = new ArrayList<String>();
		try{
			reader = new BufferedReader(new FileReader(new File("input.txt")));
			String line = null;
			while((line = reader.readLine()) != null){
				line = line.trim();
				lines.add(line);
				if(line.indexOf("for") != -1){
					loop_iterator = line.charAt(line.indexOf(";")+1);
					parseLoop();
				}
			}
			System.out.println(statements);
			optimizeLoop();
			generateOutput();
			System.out.println(Arrays.toString(loopInvariantStatements.toArray()));
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void parseLoop() throws IOException{
		String line = null;
		while((line = reader.readLine()) != null){
			line = line.trim();
			lines.add(line);
			int x = line.indexOf("=");
			if(x != -1){
				String lhs = line.substring(0,x);
				String rhs = line.substring(x+1);
				if(! statements.containsKey(lhs))
					statements.put(lhs,new ArrayList<String>());
				statements.get(lhs).add(rhs);				
			}
		}
	}

	public static void optimizeLoop(){
		for(String line : lines){
			if(! (line.indexOf("for") != -1 || line.indexOf("}") != -1)){
				//System.out.println("\n\n"+line);
				StringTokenizer st = new StringTokenizer(line.substring(line.indexOf("=")+1,line.length()-1),"+-*/");
				ArrayList<String> subExpr = new ArrayList<String>();  
				while(st.hasMoreTokens()){
					subExpr.add(st.nextToken());
				}
				boolean isLoopInvariantLine = isLoopInvariantStatement(subExpr,line.substring(0,line.indexOf("=")));
				if(isLoopInvariantLine)
					loopInvariantStatements.add(line);
			}
		}
	}

	public static boolean isLoopInvariantStatement(ArrayList<String> subExpr, String lhs){
		boolean isLoopInvariantSymbol = true;
		for(int i=0; i<subExpr.size() && isLoopInvariantSymbol; i++){
			//System.out.println(subExpr.get(i)+" : "+lhs);
			ArrayList<String> symbolStack = new ArrayList<String>();
			symbolStack.add(lhs);
			isLoopInvariantSymbol = isLoopInvariantSymbol && isLoopInvariant(subExpr.get(i),symbolStack);
		}
		return isLoopInvariantSymbol;
	}

	public static boolean isLoopInvariant(String subExpr, ArrayList<String> symbolStack){
		try{
			Integer.parseInt(subExpr);
			//System.out.println(subExpr);
			return true;
		}
		catch(Exception e){
			if(! statements.containsKey(subExpr))
				return true;
			else{
				ArrayList<String> symbolStatements = statements.get(subExpr);
				if(symbolStack.indexOf(subExpr) != -1){
					for(String x : symbolStatements){
						System.out.println("x = "+x);
						if(x.length() != 2)
							return false;
					}
				}
					
				symbolStack.add(subExpr);
				System.out.println(Arrays.toString(symbolStack.toArray()));	

				boolean isIndependent = true;
				for(String x : symbolStatements){
					ArrayList<String> subExprs = new ArrayList<String>();
					StringTokenizer st = new StringTokenizer(x.substring(0,x.length()-1),"+-*/");
					while(st.hasMoreTokens()){
						subExprs.add(st.nextToken());
					}
					for(String y : subExprs)
						isIndependent = isIndependent && isLoopInvariant(y,symbolStack);
				}
				return isIndependent;
			}
		}
	}

	public static void generateOutput() throws IOException{
		writer = new BufferedWriter(new FileWriter("output.txt"));
		for(int i=0;i<loopInvariantStatements.size();i++)
			writer.write(loopInvariantStatements.get(i)+"\n");
		for(int i=0; i<lines.size() ; i++){
			if(loopInvariantStatements.indexOf(lines.get(i)) == -1)
				writer.write(lines.get(i)+"\n");
		}
		writer.close();
	}
}