
/* KRUSHKAL'S */

#include<stdio.h>
#include<conio.h>
#include<stdlib.h>
int i,j,k,a,b,u,v,n,ne=1;
int min,mincost=0,cost[9][9],parent[9];
int find(int);
int uni(int,int);
void main()
{
 clrscr();
 printf("\n\n\tImplementation of Kruskal's algorithm\n\n");
 printf("\nEnter the no. of vertices\n");
 scanf("%d",&n);
 printf("\nEnter the cost adjacency matrix\n");
 for(i=1;i<=n;i++)
 {
  for(j=1;j<=n;j++)
  {
   scanf("%d",&cost[i][j]);
   if(cost[i][j]==0)
    cost[i][j]=999;
  }
 }
 printf("\nThe edges of Minimum Cost Spanning Tree are\n\n");
 while(ne<n)
 {
  for(i=1,min=999;i<=n;i++)
  {
   for(j=1;j<=n;j++)
   {
    if(cost[i][j]<min)
    {
     min=cost[i][j];
     a=u=i;
     b=v=j;
    }
   }
  }
  u=find(u);
  v=find(v);
  if(uni(u,v))
  {
   printf("\n%d edge (%d,%d) =%d\n",ne++,a,b,min);
   mincost +=min;
  }
  cost[a][b]=cost[b][a]=999;
 }
 printf("\n\tMinimum cost = %d\n",mincost);
 getch();
}
int find(int i)
{
 while(parent[i])
  i=parent[i];
 return i;
}
int uni(int i,int j)
{
 if(i!=j)
 {
  parent[j]=i;
  return 1;
 }
 return 0;
}

/* OUTPUT
	Implementation of Kruskal's algorithm

Enter the no. of vertices
7

Enter the cost adjacency matrix
0 2 0 0 0 14 8
2 0 19 0 0 25 0
0 19 0 9 5 17 0
0 0 9 0 1 0 0
0 0 5 1 0 13 0
14 25 17 0 13 0 21
8 0 0 0 0 21 0

The edges of Minimum Cost Spanning Tree are


1 edge (4,5) =1

2 edge (1,2) =2

3 edge (3,5) =5

4 edge (1,7) =8

5 edge (5,6) =13

6 edge (1,6) =14

	Minimum cost = 43

*/

