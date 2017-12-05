/* PRIM'S */

#include<stdio.h>
#include<conio.h>
int a,b,u,v,n,i,j,ne=1;
int visited[10]={0},min,mincost=0,cost[10][10];
void main()
{
 clrscr();
 printf("\n Enter the number of nodes:");
 scanf("%d",&n);
 printf("\n Enter the adjacency matrix:\n");
 for(i=1;i<=n;i++)
  for(j=1;j<=n;j++)
  {
   scanf("%d",&cost[i][j]);
   if(cost[i][j]==0)
    cost[i][j]=999;
  }
 visited[1]=1;
 printf("\n");
 while(ne<n)
 {
  for(i=1,min=999;i<=n;i++)
   for(j=1;j<=n;j++)
    if(cost[i][j]<min)
     if(visited[i]!=0)
     {
      min=cost[i][j];
      a=u=i;
      b=v=j;
     }
  if(visited[u]==0 || visited[v]==0)
  {
   printf("\n Edge %d:(%d %d) cost:%d",ne++,a,b,min);
   mincost+=min;
   visited[b]=1;
  }
  cost[a][b]=cost[b][a]=999;
 }
 printf("\n Minimum cost=%d",mincost);
 getch();
}

/* OUTPUT


 Enter the number of nodes:6                                                    
                                                                                
 Enter the adjacency matrix:                                                    
0 6 3 0 0 0                                                                     
6 0 2 5 0 0                                                                     
3 2 0 3 4 0
0 5 3 0 2 3
0 0 4 2 0 5
0 0 0 3 5 0


 Edge 1:(1 3) cost:3
 Edge 2:(3 2) cost:2
 Edge 3:(3 4) cost:3
 Edge 4:(4 5) cost:2
 Edge 5:(4 6) cost:3
 Minimum cost=13

*/








