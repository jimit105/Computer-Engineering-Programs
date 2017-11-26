			/* LRU PAGE REPLACEMENT */

#include<stdio.h>
#include<conio.h>
#include<stdlib.h>
int page[100], f[3]={'@','@','@'};

void main()
{
 int i,n=0,j,pfn=0;
 clrscr();
 printf("Enter . to stop input.\n");
 printf("Start entering pages. Press ant key to start!\n\nReady?");
 getch();
 clrscr();
 printf("Enter : ");
 for(i=0;i<100;i++)
 {
  char c;
  if(i!=0) printf(",");
  c = getche();
  if(c==(char)'.')
  {
   clrscr();
   printf("Enter : %d",page[0]);
   for(j=1;j<n;j++)
   {
    printf(",%d",page[j]);
   }
   printf(".");
   break;
  }
  page[i] = (int)((char)c - 48);
  n++;
 }
 printf("\n\nProcessing..........");
 printf("\nPage reference\tPage Fault\tFrame\n");
 for(i=0;i<n;i++)
 {
  int k,pf=1;
  printf("%d",page[i]);
  for(j=0;j<3;j++)
  {
   if(f[j]==page[i])
   {
    pf=0;
    pfn--;
    break;
   }
  }
  if(j>2) j=0;
  for(k=j;k<2;k++)
  {
   f[k] = f[k+1];
  }
  f[2] = page[i];
  printf("\t\t%d",pf);
  printf("\t\t");
  if(f[0]=='@') printf("_");
  else printf("%d",f[0]);
  for(j=1;j<3;j++)
  {
   if(f[j]=='@') printf(",_");
   else printf(",%d",f[j]);
  }
  printf("\n");
  delay(400);
  pfn++;
 }
 printf("\nNumber of page faults : %d",pfn);
 j=0;
 printf("\nPress any key to exit.");
 getch();
}

/* OUTPUT

Enter : 7,0,1,2,0,3,0,4,2,3,0,3,2,1,2,0,1,7,0,1.

Processing..........
Page reference  Page Fault      Frame
7               1               _,_,7
0               1               _,7,0
1               1               7,0,1
2               1               0,1,2
0               0               1,2,0
3               1               2,0,3
0               0               2,3,0
4               1               3,0,4
2               1               0,4,2
3               1               4,2,3
0               1               2,3,0
3               0               2,0,3
2               0               0,3,2
1               1               3,2,1
2               0               3,1,2
0               1               1,2,0
1               0               2,0,1
7               1               0,1,7
0               0               1,7,0
1               0               7,0,1

Number of page faults : 12
Press any key to exit.
*/