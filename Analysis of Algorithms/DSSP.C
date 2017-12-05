/* SINGLE SOURCE SHORTEST PATH USING DYNAMIC PROGRAMMING */

#include<stdio.h>
#include<conio.h>

int dist[10], cost[10][10], path[10], n, v, x;

int main()
{
 int i, j, u, v, c;
 clrscr();
 printf("\nEnter number of vertices: ");
 scanf("%d", &n);
 printf("\nEnter cost matrix: \n");
 for(i=1;i<=n;i++)
 {
  for(j=1;j<=n;j++)
  {
   scanf("%d", &cost[i][j]);
  }
 }

 printf("\nEnter source vertex: ");
 scanf("%d", &v);

 for(i=1;i<=n;i++)
 {
  if(i==v)
  {
   dist[i]=0;
 //  printf("dist[%d]=%d\n", i, dist[i]);
  }
  else
  {
   dist[i]=100;
//   printf("dist[%d]=%d\n", i, dist[i]);
  }
  path[i]=NULL;
 }

 for(i=1; i<n; i++)
 {
  for(u=1; u<=n; u++)
  {
   for(v=1;v<=n;v++)
   {
    if((cost[u][v])!=100 && u!=v)
    {
     if((dist[u]+cost[u][v]) < dist[v])
     {
      dist[v]=dist[u]+cost[u][v];
      path[v]=u;
     }
    }
   }
  }
 }

 printf("\n\nDistance\tPath\n");
 for(i=1;i<=n;i++)
 {
  printf("\ndist[%d]=%d\tp[%d]=%d\n", i, dist[i], i, path[i]);
 }

 getch();
 return 0;
}


/* OUTPUT

Enter number of vertices: 7

Enter cost matrix:
0 6 5 5 100 100 100
100 0 100 100 -1 100 100
100 -2 0 100 1 100 100
100 100 -2 0 100 -1 100
100 100 100 100 0 100 3
100 100 100 100 100 0 3
100 100 100 100 100 100 0

Enter source vertex: 1


Distance        Path

dist[1]=0       p[1]=0

dist[2]=1       p[2]=3

dist[3]=3       p[3]=4

dist[4]=5       p[4]=1

dist[5]=0       p[5]=2

dist[6]=4       p[6]=4

dist[7]=3       p[7]=5

*/