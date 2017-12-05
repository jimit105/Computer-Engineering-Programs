		/* 0/1 Knapsack using Genetic Algorithm */

import java.util.*;

class Knapsack{
	
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number of items: ");
		int n = sc.nextInt();
		int wt[] = new int[n];
		int bt[] = new int[n];
		
		System.out.print("Enter the capacity of knapsack: ");
		int m = sc.nextInt();
		
		for(int i=0; i<n;i++){
			System.out.print("Enter the weight for item" + (i+1) +": ");
			wt[i] = sc.nextInt();
			System.out.print("Enter the profit for item" + (i+1) +": ");
			bt[i] = sc.nextInt();
		}
		
	
		double h = Math.pow(2,n);
		
		int a[][] = new int [(int)h][n+2]; //random initial population;
		
		int count = 0;
		for(int i=0; i<n;i++){
			if(wt[i]<=m){
				a[i][i] = 1;
				a[i][n] = wt[i];
				a[i][n+1] = bt[i];
			}
		}
		count = n;
		for(int i=0; i<n;i++){
			for(int j=i+1;j<n;j++){
				if(wt[i]+wt[j]<=m){
					a[count][i]=1;
					a[count][j]=1;
					a[count][n]=wt[i]+wt[j];
					a[count][n+1]=bt[i]+bt[j];
					count++;
				}
			}
		}
		
		int b[][] = new int [6][n+2];
		
		Random r = new Random();
		
		int count2 = 0;
		ArrayList<Integer> done = new ArrayList<Integer>();
		
		while(count2<6){
			int z = r.nextInt(count);
			if(!done.contains(z)){
				done.add(z);
				b[count2] = a[z];
				count2++;
			}
		}
		
		for(int i=0;i<n;i++){
			System.out.print(wt[i]+" ");
		}
		System.out.println();
		for(int i=0;i<n;i++){
			System.out.print(bt[i]+" ");
		}
		System.out.println("\nRandom initial population:\n");
				 
		for(int i=0;i<count2;i++){
			for(int j=0;j<n+2;j++){
				System.out.print(b[i][j]+" ");
			}	
			System.out.println();
		}
		
		
		
		int c[][] = new int [4][n+2];
		ArrayList<Integer> done2 = new ArrayList<Integer>();
		
		int count3 = 0;
		
		while(count3<4){
			
			int f = r.nextInt(count2);
			
			if(!done2.contains(f)){
				done2.add(f);
				c[count3] = b[f];
				count3++;
			}
		}
		System.out.println("\nRandom selection of chromosomes:\n");
				 
		for(int i=0;i<count3;i++){
			for(int j=0;j<n+2;j++){
				System.out.print(c[i][j]+" ");
			}	
			System.out.println();
		}
		
		int d[][]= new int[4][n+2];
		int u = r.nextInt(2);
		System.out.println("u = "+u);
		
		for(int i=0;i<4;i=i+2){
			if(u==0){
				for(int j=0;j<n/2;j++){
					d[i][j]=c[i+1][j];
					d[i+1][j] = c[i][j];
				}
				for(int j=n/2;j<n;j++){
					d[i][j] = c[i][j];
					d[i+1][j] = c[i+1][j];
				}
			}else{
				for(int j=0;j<n/2;j++){
					d[i][j]=c[i][j];
					d[i+1][j] = c[i+1][j];
				}
				for(int j=n/2;j<n;j++){
					d[i][j] = c[i+1][j];
					d[i+1][j] = c[i][j];
				}
			}
		}
		for(int i=0;i<count3;i++){
			d[i][n+1]  = 0;
		}
		
		System.out.println("\nCrossover of chromosomes:\n");
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				if(d[i][j]==1){
					d[i][n]=d[i][n]+wt[j];
					d[i][n+1]=d[i][n+1]+bt[j];
				}
			}
		}		 
		for(int i=0;i<count3;i++){
			for(int j=0;j<n+2;j++){
				System.out.print(d[i][j]+" ");
			}	
			System.out.println();
		}
		System.out.println("\nFlipping of random bit:\n");
		for(int i=0;i<count3;i++){
			int kk = r.nextInt(4);
			if(d[i][kk]==1){
				while(d[i][kk]==1){
					kk = r.nextInt(4);	
				}
				d[i][kk]=1;
			}else{
				d[i][kk]=1;
			}
		}
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				if(d[i][j]==1){
					d[i][n]=d[i][n]+wt[j];
					d[i][n+1]=d[i][n+1]+bt[j];
				}
			}
		}		
		
		for(int i=0;i<count3;i++){
			for(int j=0;j<n+2;j++){
				System.out.print(d[i][j]+" ");
			}	
			System.out.println();
		}
		int max = 0; 
		for(int i=0;i<count3;i++){
			if(d[i][n]<=m&&d[i][n+1]>max)
				max=d[i][n+1];
		}
		System.out.println("\nMaximum profit is "+max);
	}	
}

/* OUTPUT
 *
 *Enter the number of items: 4
Enter the capacity of knapsack: 10
Enter the weight for item1: 7
Enter the profit for item1: 42
Enter the weight for item2: 3
Enter the profit for item2: 12
Enter the weight for item3: 4
Enter the profit for item3: 40
Enter the weight for item4: 5
Enter the profit for item4: 25
7 3 4 5 
42 12 40 25 
Random initial population:

0 0 1 1 9 65 
0 0 0 1 5 25 
1 0 0 0 7 42 
1 1 0 0 10 54 
0 1 1 0 7 52 
0 1 0 0 3 12 

Random selection of chromosomes:

0 0 0 1 5 25 
1 0 0 0 7 42 
0 1 0 0 3 12 
0 0 1 1 9 65 
u = 0

Crossover of chromosomes:

1 0 0 1 12 67 
0 0 0 0 0 0 
0 0 0 0 0 0 
0 1 1 1 12 77 

Flipping of random bit:

1 0 1 1 28 174 
1 0 0 0 7 42 
1 0 0 0 7 42 
1 1 1 1 31 196 

Maximum profit is 42
*/