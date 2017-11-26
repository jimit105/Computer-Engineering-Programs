			/* FIFO PAGE REPLACEMENT */

#include<stdio.h>
#include<conio.h>
#include<dos.h>

int p[100],e=2,f[3]={999,999,999};

void main()
{
 int pfn=0,i,pf,j,n=0,k=1,t;
 clrscr();
 printf("\t\t   -----FIFO Page replacement program-----\n\n");
 printf("Start entering page references.\n\nInput 999 to stop entering.\n\nPress any key to get started...");
 getch();
 clrscr();
 for(i=0;;i++)
 {
  clrscr();
  printf("Page references : ");
  for(j=0;j<i;j++)
  {
   printf("%d,",p[j]);
  }
  scanf("%d",&p[i]);
  if(p[i]==999)
  {
   i--;
   clrscr();
   printf("Page references : ");
   for(j=0;j<=i;j++)
   {
    if(j==i) printf("%d",p[j]);
    else printf("%d,",p[j]);
   }
   break;
  }
 }
 n=i+1;
 printf("\nPage reference\tPage Fault\tFinal list\n");
 for(i=0;i<n;i++)
 {
  if(f[0]!=999&&k==0) e=0;
  pf=0;
  printf("%d\t\t",p[i]);
  for(j=2;j>=0;j--)
  {
   k=1;
   if(f[j]==999) k=0;
   if(f[j]==p[i]) break;
  }
  if(j==-1)
  {
   if(k==0)
   {
    for(j=0;j<2;j++)
    {
     f[j]=f[j+1];
    }
   }
   pf=1;
   pfn++;
   f[e] = p[i];
   if(k==1)
   {
    e++;
    if(e==3) e=0;
   }
  }
  delay(200);
  printf("%d\t\t",pf);
  delay(200);
  for(j=0;j<3;j++)
  {
   if(f[j]==999&&j!=2) printf("_,");
   else if(f[j]==999&&j==2) printf("_");
   else if(f[j]!=999&&j!=2) printf("%d,",f[j]);
   else printf("%d",f[j]);
   delay(200);
  }
  printf("\n");
 }
 printf("\nNumber of page faults encountered : %d\n",pfn);
 printf("\nPress any key to exit..");
 getch();
}

/* OUTPUT

Page references: 7,0,1,2,0,3,0,4,2,3,0,3,2,1,2,0,1,7,0,1

Page reference  Page Fault      Final list
7               1               _,_,7
0               1               _,7,0
1               1               7,0,1
2               1               2,0,1
0               0               2,0,1
3               1               2,3,1
0               1               2,3,0
4               1               4,3,0
2               1               4,2,0
3               1               4,2,3
0               1               0,2,3
3               0               0,2,3
2               0               0,2,3
1               1               0,1,3
2               1               0,1,2
0               0               0,1,2
1               0               0,1,2
7               1               7,1,2
0               1               7,0,2
1               1               7,0,1

Number of page faults encountered : 15

Press any key to exit..
*/