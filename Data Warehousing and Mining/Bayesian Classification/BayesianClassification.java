		/* Bayesian Classification */

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

/**
 *
 * @author Jimit
 */
 
public class BayesianClassification {
    static String[][] data = new String[250][7];
    
    public static void main(String[] args) throws java.lang.Exception{
        final String FILE_NAME = "Dataset.csv";
        
        
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));
        
        String splitBy = ",";       //Values are separated by comma for .csv files
        int rowNo = 0;             //row number
        int columnNo = 0;            //column number
        
        String line;            //each line of the file
        String[] dataTemp;
         
        while( (line = br.readLine()) != null){            
            dataTemp = line.split(splitBy);
            
            System.arraycopy(dataTemp, 0, data[rowNo], 0, 7);
            rowNo++;
        }
        
        /*
        for(int i = 0; i < rowNo ; i++){
            for(int j = 0 ; j < 7 ; j++){
                System.out.print(data[i][j] + "\t");
            }
            System.out.println();
        }
        */
        
        System.out.println("---CAR EVALUATION SYSTEM---");
        
        System.out.println("\nATTRIBUTE \t\t\t VALUES\n");
        System.out.println("Buying Price \t\t vhigh, high, med, low");
        System.out.println("Maintainance Cost \t vhigh, high, med, low");
        System.out.println("Doors \t\t\t\t 2, 3, 4, 5more");
        System.out.println("People \t\t\t\t 2, 4, more");
        System.out.println("Luggage Boot \t\t small, med, big");
        System.out.println("Safety \t\t\t\t low, med, high");
        
        System.out.print("\nEnter Buying Price: ");
        String buying = sc.next();
        
        System.out.print("\nEnter Maintainance Cost: ");
        String maintainance = sc.next();
        
        System.out.print("\nEnter Number of Doors: ");
        String doors = sc.next();
        
        System.out.print("\nEnter Capacity in terms of People: ");
        String people = sc.next();
        
        System.out.print("\nEnter Size of Luggage Boot: ");
        String luggageBoot = sc.next();
        
        System.out.print("\nEnter Estimated Safety: ");
        String safety = sc.next();
        
   //     System.out.println("\nEntered Query is " + buying + "\t" + maintainance + "\t" + doors + "\t" + people + "\t" + luggageBoot + "\t" + safety);
        
        double probabilityUnacc = calculateProbability("unacc", buying, maintainance, doors, people, luggageBoot, safety, rowNo);
        System.out.println("\nProbability for Unacceptability is " + probabilityUnacc);
        
        double probabilityAcc = calculateProbability("acc", buying, maintainance, doors, people, luggageBoot, safety, rowNo);
        System.out.println("\nProbabilty for Acceptability is " + probabilityAcc);
        
        if(probabilityAcc == probabilityUnacc)
            System.out.println("\nThe Car MAY or MAY NOT be accepted");
        else{
            System.out.println("\nThe Car " + ((probabilityAcc > probabilityUnacc) ? "WILL be Accepted" : "WILL NOT be Accepted") );
        }
        
        
    }

    public static double calculateProbability(String value, String buying, String maintainance, String doors, String people, String luggageBoot, String safety, int lineNo){
        int total = 0;
        int favourable = 0;
        
        double probabilty = 1;        
        
        //Probabilty for Buying
        for(int i = 0 ; i < lineNo ; i++){            
            if(value.equals(data[i][6]))
                total++;
            if(buying.equals(data[i][0]) && value.equals(data[i][6]))
                favourable++;
        }
        
        double val = (double)favourable / total;
        probabilty = probabilty * val;       
        
        total = 0;
        favourable = 0;
        
        //Probabilty of Maintainance
        for(int i = 0 ; i < lineNo ; i++){
            if(value.equals(data[i][6]))
                total++;
            if(maintainance.equals(data[i][1]) && value.equals(data[i][6]))
                favourable++;
        }
        
        val = (double)favourable / total;
        probabilty = probabilty * val;       
                
        total = 0;
        favourable = 0;
        
        //Probabilty of Doors
        for(int i = 0 ; i < lineNo ; i++){
            if(value.equals(data[i][6]))
                total++;
            if(doors.equals(data[i][2]) && value.equals(data[i][6]))
                favourable++;
        }
        
        val = (double)favourable / total;
        probabilty = probabilty * val;
        
        total = 0;
        favourable = 0;
        
        //Probabilty of People
        for(int i = 0 ; i < lineNo ; i++){
            if(value.equals(data[i][6]))
                total++;
            if(people.equals(data[i][3]) && value.equals(data[i][6]))
                favourable++;
        }
        
        val = (double)favourable / total;
        probabilty = probabilty * val;
        
        total = 0;
        favourable = 0;
        
        //Probabilty of Luggage Boot
        for(int i = 0 ; i < lineNo ; i++){
            if(value.equals(data[i][6]))
                total++;
            if(luggageBoot.equals(data[i][4]) && value.equals(data[i][6]))
                favourable++;
        }
        
        val = (double)favourable / total;
        probabilty = probabilty * val;
        
        total = 0;
        favourable = 0;
        
        //Probabilty of Safety
        for(int i = 0 ; i < lineNo ; i++){
            if(value.equals(data[i][6]))
                total++;
            if(safety.equals(data[i][5]) && value.equals(data[i][6]))
                favourable++;
        }
        
        val = (double)favourable / total;
        probabilty = probabilty * val;
                
        return probabilty;
        
    }
}

/* OUTPUT
 *
 *---CAR EVALUATION SYSTEM---

ATTRIBUTE            VALUES

Buying Price         vhigh, high, med, low
Maintainance Cost    vhigh, high, med, low
Doors                2, 3, 4, 5more
People               2, 4, more
Luggage Boot         small, med, big
Safety               low, med, high

Enter Buying Price: med

Enter Maintainance Cost: med

Enter Number of Doors: 4

Enter Capacity in terms of People: 4

Enter Size of Luggage Boot: small

Enter Estimated Safety: med

Probability for Unacceptability is 4.773806048675222E-4

Probabilty for Acceptability is 6.39210551697531E-4

The Car WILL be Accepted
*/
