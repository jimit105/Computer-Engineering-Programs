import java.util.*;

class Exp02
{
 public static void main(String args[])
 {
  int n,m,p[][],i,j,avg[],sum[];
  Scanner sc=new Scanner(System.in);
  System.out.println("Enter the number of players");
  n=sc.nextInt();
  p=new int[n][];   //Initialization of number of rows
  avg=new int[n];
  sum=new int[n];

  for(i=0;i<n;i++)
  {
   System.out.println("Enter the number of matches for player "+(i+1));
   m=sc.nextInt();
   p[i]=new int[m];   //Dynamic Allocation of columns
   }
  
  for(i=0;i<n;i++)
  {
   sum[i]=0;
   for(j=0;j<p[i].length;j++)
   {
    System.out.println("Enter the runs of player "+(i+1)+" in match "+(j+1));
    p[i][j]=sc.nextInt();
    sum[i]=sum[i]+p[i][j];
    }
   avg[i]=sum[i]/p[i].length;
   
   }

  for(i=0;i<n;i++)
  {
   System.out.println("The average runs of player "+(i+1)+" is "+avg[i]);
   }

  for(i=0;i<n;i++)
  { 
   System.out.println("Player "+(i+1)+":");
   for(j=0;j<p[i].length;j++)
   {
    System.out.print("\tMatch "+(j+1)+"\tRuns "+p[i][j]+"\n");
    }
   System.out.print("Total "+sum[i]+" Average "+avg[i]+"\n\n");
  }

 }
}


/*OUTPUT

Enter the number of players
3
Enter the number of matches for player 1
2
Enter the number of matches for player 2
3
Enter the number of matches for player 3
4
Enter the runs of player 1 in match 1
5
Enter the runs of player 1 in match 2
10
Enter the runs of player 2 in match 1
12
Enter the runs of player 2 in match 2
16
Enter the runs of player 2 in match 3
18
Enter the runs of player 3 in match 1
12
Enter the runs of player 3 in match 2
13
Enter the runs of player 3 in match 3
16
Enter the runs of player 3 in match 4
14
The average runs of player 1 is 7
The average runs of player 2 is 15
The average runs of player 3 is 13
Player 1:
        Match 1 Runs 5
        Match 2 Runs 10
Total 15 Average 7

Player 2:
        Match 1 Runs 12
        Match 2 Runs 16
        Match 3 Runs 18
Total 46 Average 15

Player 3:
        Match 1 Runs 12
        Match 2 Runs 13
        Match 3 Runs 16
        Match 4 Runs 14
Total 55 Average 13     */