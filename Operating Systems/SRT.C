/* SHORTEST REMAINING TIME */

#include<stdio.h>
#include<conio.h>

int k,i,z;
int at[100],bt[100],rem[100],tg[100][100];

int sort(int x[100])
{
 int j,temp,min;
 min=10000;
 for(z=0;z<k;z++)
 {
  if(x[z]<min&&i>=at[z]&&x[z]>0)
  {
   min=x[z];
   temp=z;
  }
 }
  return temp;
}

void main()
{
 int j,n,sum=0,count,temp,min;
 clrscr();
 for(i=0;i<3;i++)
  for(j=0;j<30;j++)
   tg[i][j]=0;
 printf("Enter the number of processes: \n");
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
 for(i=0;i<k;i++)
 {
  sum=sum+bt[i]+at[i];
  rem[i]=bt[i];
 }
 n=sum;
 i=0;j=0;
 for(i=0;i<n;i++)
 {
  min=sort(rem);
  rem[min]=rem[min]-1;
  tg[min][i]=1;
 }
 for(i=0;i<k;i++)
  for(j=0;j<n;j++)
   if(tg[i][j]!=1)
    tg[i][j]=0;
 for(i=0;i<k;i++)
 {
  printf("\n");
  for(j=0;j<n;j++)
   printf("%d",tg[i][j]);
 }
 getch();
}


