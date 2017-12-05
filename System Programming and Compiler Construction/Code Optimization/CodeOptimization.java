		/*Code Optimization- Common Sub-Expression Elimination */

import java.io.*;
import java.util.*;

class CodeOptimization {
	
    public static void main(String args[]) throws IOException {
    	
        String s, temp;
        String arr[][] = new String[10][2]; 			//assuming 10 expressions
        
        int flag = 0, index = 0;
        
        long startTime = System.currentTimeMillis();
        
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
        BufferedReader br2 = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
        System.out.println("The input is: ");
 		String line = null;
 		while ((line = br2.readLine()) != null) {
 		  System.out.println(line);
 		}
        
        PrintWriter output = new PrintWriter(new FileWriter("output.txt"), true);
        
        while((s = br.readLine()) != null) {
        	
            temp = s.substring(s.indexOf("=") + 1);
            
            for (int i = 0; i < index; i++) {
            	
                if (temp.equals(arr[i][1])) {
                    flag = 1;					//previous match found
                    break;
                    
                } else if (temp.contains(arr[i][1]))
                    s = s.replaceAll(arr[i][1], arr[i][0]);
            }
            
            if (flag == 0) {			//previous match not found
                arr[index][0] = s.substring(0, s.indexOf("="));
                arr[index][1] = temp;
                index++;
                output.write(s);
                output.print("\n");
            }
            flag=0;
        }
        
        output.close();
        
        System.out.println("\nThe output is: ");
        BufferedReader br1 = new BufferedReader(new FileReader("output.txt"));
 		String line1 = null;
 		while ((line1 = br1.readLine()) != null) {
  			 System.out.println(line1);
 		}
        
        long endTime = System.currentTimeMillis();
        
        long diffTime = endTime - startTime;
        System.out.println("\nElapsed time is " + diffTime + " milli seconds");
    }
}