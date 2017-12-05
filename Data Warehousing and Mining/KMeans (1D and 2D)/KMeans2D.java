		/* Implementation of K-Means Algorithm in 2 dimensions */

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Random;

//Assumption- Number of clusters is 2

class KMeans2D {

    static ArrayList<Integer> a = new ArrayList<Integer>();
    static ArrayList<Integer> b = new ArrayList<Integer>();

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        int i, j;
        int l1 = 0, l2 = 0, k1 = 0, k2 = 0;	//Assume initial centroids to be (0, 0) and (0, 0)- for comparison
        int diff1, diff2;

        System.out.print("Enter number of objects: ");
        int n = sc.nextInt();
        int arr[][] = new int[n][2];
        int c[][] = new int[n][2];

    //    System.out.println("\nEnter the elements: (x, y)");
        for (i = 0; i < n; i++) {        	
            for (j = 0; j < 2; j++) {            	
    //            arr[i][j] = sc.nextInt(); 
                arr[i][j] = ThreadLocalRandom.current().nextInt(1, 10); //generates random numbers from 1 to 10
            }            
        }
        
        System.out.println("\nThe elements are: ");
        for (i = 0; i < n; i++) {
        	System.out.print("(");
            for (j = 0; j < 2; j++) {
                System.out.print(arr[i][j]);
                System.out.print( (j<1) ? "," : "" );
            }
            System.out.print(")");
            System.out.println();
        }
     	
		int num1 = 0;
		int num2 = 1;  	        
        
        int m1 = arr[num1][0];
        int m2 = arr[num1][1];
        System.out.println("\nCentroid 1: (" + m1 + "," + m2 + ")");
        
        int n1 = arr[num2][0];
        int n2 = arr[num2][1];
        System.out.println("Centroid 2: (" + n1 + "," + n2 + ")");
        
        int z = 0;
        
        //Continue till the points are same
        
        while (check_prev_curr_points(l1, l2, k1, k2, m1, m2, n1, n2)) {
            if (z != 0) {
                m1 = k1;
                m2 = k2;
                n1 = l1;
                n2 = l2;

            }            
            
            for (i = 0; i < n; i++) {
                c[i][0] = dist(arr[i][0], arr[i][1], m1, m2);
                c[i][1] = dist(arr[i][0], arr[i][1], n1, n2);
            }
            
            System.out.println("\nCentroid Distance: ");
            for (i = 0; i < n; i++) {
                for (j = 0; j < 2; j++) {
                    System.out.print(c[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();

            for (i = 0; i < n; i++) {

                if (c[i][0] < c[i][1]) {
                    a.add(arr[i][0]);
                    a.add(arr[i][1]);
                } else {
                    b.add(arr[i][0]);
                    b.add(arr[i][1]);
                }
            }

            System.out.print("Cluster 1: ");
            for (i = 0; i < a.size(); i++) {
                System.out.print( ((i%2==0) ? "(" : "") + a.get(i) + ((i%2==0) ? "," : "") + ((i%2==0) ? "" : "), ") );
            }
            System.out.println();

            System.out.print("Cluster 2: ");
            for (i = 0; i < b.size(); i++) {
                System.out.print( ((i%2==0) ? "(" : "") + b.get(i) + ((i%2==0) ? "," : "") + ((i%2==0) ? "" : "), ") );
            }
            System.out.println();

            int sum1 = 0, sum2 = 0;

            for (i = 0; i < a.size(); i = i + 2) {
                sum1 = sum1 + a.get(i);
                sum2 = sum2 + a.get(i + 1);
            }

            k1 = (sum1 / (b.size() / 2));
            k2 = (sum2 / n);

            sum1 = 0;
            sum2 = 0;
            for (i = 0; i < b.size(); i = i + 2) {
                sum1 = sum1 + b.get(i);
                sum2 = sum2 + b.get(i + 1);
            }
            l1 = (sum1 / (b.size() / 2));
            l2 = (sum2 / (b.size() / 2));

         
            a.clear();
            b.clear();

            z++;

        }

    }
	
	//Check if previous and current points are same
	/*@return false if the previous and current points are same
     *@return true if the previous and current points are same
     */
    public static boolean check_prev_curr_points(int l1, int l2, int k1, int k2, int m1, int m2, int n1, int n2) {
        if (k1 == m1) {
            if (k2 == m2) {
                if (l1 == n1) {
                    if (l2 == n2) {
                        return false;
                    }
                }
            }
        }
        return true;

    }
	
	
	//---CALCULATE EUCLIDEAN DISTANCE---//
	/* param a - x coordinate of 1st point
	 * param b - y coordinate of 1st point
	 * param c - x coordinate of 2nd point
	 * param d - y coordinate of 2nd point
	 */	 
    public static int dist(int a, int b, int c, int d) {
        int ans = (int) Math.sqrt(Math.pow((a - c), 2) + Math.pow((b - d), 2));
        return ans;
    }
}


/* OUTPUT
 *
 *Enter number of objects: 5

The elements are: 
(7,3)
(5,9)
(3,5)
(6,3)
(5,8)

Centroid 1: (7,3)
Centroid 2: (5,9)

Centroid Distance: 
0 6 
6 0 
4 4 
1 6 
5 1 

Cluster 1: (7,3), (6,3), 
Cluster 2: (5,9), (3,5), (5,8), 

Centroid Distance: 
3 5 
8 2 
4 2 
2 4 
7 1 

Cluster 1: (7,3), (6,3), 
Cluster 2: (5,9), (3,5), (5,8), 
*/