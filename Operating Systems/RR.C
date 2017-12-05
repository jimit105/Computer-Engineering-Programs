/* ROUND ROBIN */

#include<stdio.h>
#include<conio.h>

void main()
{
 int quant,i,j,sum=0,temp,k,n;
 int at[100],bt[100],rem[100],tg[100][100];
 clrscr();
 for(i=0;i<100;i++)
  for(j=0;j<100;j++)
   tg[i][j]=0;
 printf("Enter the no. of processes: \n");
 scanf("%d",&k);
 printf("Enter the arrival times of processes: \n");
 for(i=0;i<k;i++)
  scanf("%d",&at[i]);
 printf("Enter the burst time of processes: \n");
 for(i=0;i<k;i++)
  scanf("%d",&bt[i]);
 for(i=0;i<k;i++)
 for(j=i+1;j<k;j++)
 if(at[i]>at[j])
 {
  temp=at[i];
  at[i]=at[j];
  at[j]=temp;
  temp=bt[i];
  bt[i]=bt[j];
  bt[j]=temp;
 }
 printf("Enter time quantum\n");
 scanf("%d",&quant);
 for(i=0;i<k;i++)
 {
  sum=sum+bt[i];
  rem[i]=bt[i];
 }
 n=sum;
 j=0;
 for(i=0;i<n;i=i+quant)
 {
  while(rem[j]<=0||j>(k-1))
  {
   j++;
   if(j>(k-1))
    j=0;
  }
  if(rem[j]>0)
  {
   rem[j]=rem[j]-quant;
   tg[j][i]=1;
   j++;
  }
 }
 for(i=0;i<k;i++)
  for(j=0;j<n;j++)
   if(tg[i][j]!=1)
    tg[i][j]=0;
 for(i=0;i<k;i++)
 {
  printf("\n");
  for(j=0;j<n;j=j+2)
   printf("%d",tg[i][j]);
 }
 getch();
}

