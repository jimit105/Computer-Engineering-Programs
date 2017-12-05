		/* Implementation of K-Means Algorithm in 1 dimension */

import java.util.Scanner;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class KMeans {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int data[] = new int[n];

        //System.out.println("Enter elements: ");
        for (int i = 0; i < n; i++)
        //data[i] = sc.nextInt();
            data[i] = ThreadLocalRandom.current().nextInt(1, 101); //generates random numbers from 1 to 100

        System.out.print("The elements are: ");
        for (int i = 0; i < n; i++)
            System.out.print(data[i] + " ");

        System.out.print("\n\nEnter the number of clusters: ");
        int k = sc.nextInt();
        int m[] = new int[k];

        //  System.out.println("Mean selected:");
        /*	for ( int i = 0 ; i < k ; i++ )
        	{
        		m[i] = data[i];
        		System.out.println(m[i]);
        	}
        */

        for (int i = 0; i < k; i++) {
            m[i] = data[new Random().nextInt(data.length)]; //random generates index of the data array
        }
        System.out.print("The means are ");
        for (int i = 0; i < k; i++) {
            System.out.print(m[i] + " ");
        }

        System.out.println();

        int clustarr[][] = new int[k][n];
        for (int i = 0; i < k; i++)
            for (int j = 0; j < n; j++) {
                clustarr[i][j] = -1;
            }

        for (int i = 0; i < n; i++) {
            int min = Math.abs(data[i] - m[0]);
            int pos = 0;

            for (int j = 0; j < k; j++) {
                int d = Math.abs(data[i] - m[j]);
                if (min > d) {
                    min = d;
                    pos = j;
                }
            }

            int s = -1;
            for (int j = 0; j < n; j++)
                if (clustarr[pos][j] == -1) {
                    s = j;
                    break;
                }
            clustarr[pos][s] = data[i];
        }

        for (int i = 0; i < k; i++) {
            System.out.println("\nCluster " + (i + 1) + ": ");
            for (int j = 0; j < n; j++) {
                if (clustarr[i][j] != -1)
                    System.out.print(clustarr[i][j] + "\t");
            }
            System.out.println();
        }
    }
}


/* OUTPUT
 *
 *Enter number of elements: 5
The elements are: 2 84 62 7 89 

Enter the number of clusters: 2
The means are 7 89 

Cluster 1: 
2   7   

Cluster 2: 
84  62  89 
 
*/