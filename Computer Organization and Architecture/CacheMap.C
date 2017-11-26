#include<stdio.h>
#include<conio.h>

void printa(int tag[],int flag[])
{
 int i,j;
 for(i=0;i<32;i++)
 {
  if(i%2==0)
   printf("\n");
  printf("set=%3d",i);
  for(j=0;j<8;j++)
  {
   if(flag[i]==0)
    printf("%3d",-1);
   else
    printf("%4d",tag[i]*8+j);
  }
 }
}

void printsa(int tag[],int flag[])
{
 int i,j;
 for(i=0;i<32;i++)
 {
  if(i%2==0)
   printf("\nset=%3d(0)",i/2);
  else
   printf("set=%3d(1)",i/2);
  for(j=0;j<8;j++)
  {
   if(flag[i]==0)
    printf("%3d",-1);
   else
    printf("%4d",tag[i]*128+i*4+j);
  }
 }
}

void printd(int tag[],int flag[])
{
 int i,j;
 for(i=0;i<32;i++)
 {
  if(i%2==0)
   printf("\n");
  printf("set=%3d",i);
  for(j=0;j<8;j++)
  {
   if(flag[i]==0)
    printf("%3d",-1);
   else
   printf("%4d",tag[i]*256+i*8+j);
  }
 }
}

void main()
{
int tag[32],LRU[32],flag[32];
 int op,i,j,n,T,W,L,A,k;
 clrscr();
 do
 {
  printf(" \n\n 1 : Direct Mapping\n");
  printf(" 2 : Associative Mapping\n");
  printf(" 3 : Quit\n");
  printf("Enter your choice\n");
  scanf("%d",&op);
  switch(op)
  {
   case 1 :
	    for(i=0;i<32;i++)
	     flag[i]=0;
	    printf("Enter number of addresses");
	    scanf("%d",&n);
	    for(i=0;i<n;i++)
	    {
	     printf("\nEnter next addresses\n");
	     scanf("%d",&A);
	     W= A & 0x0007;
	     L= (A & 0x00F8)>>3;
	     T= (A & 0x3F00)>>8;
	     if(flag[L]==0 || flag[L]==1 && tag[L] !=T)
	     {
	      printf("Cache miss...\n");
	      flag[L]=1;
	      flag[L]=T;
	     }
	     else
	      printf("Cache hit...\n");
	     printd(tag,flag);
	    }
	    break;

   case 2 :
	    for(i=0;i<32;i++)
	    {
	     flag[i]=0;
	     LRU[i]=0;
	    }
	    printf("Enter number of addresses\n");
	    scanf("%d",&n);
	    for(i=0;i<n;i++)
	    {
	     printf("\nEnter next addresses\n");
	     scanf("%d",&A);
	     W = A & 0x0007;
	     T = A>>3;
	     for(j=0;j<32;j++)
	      if(flag[j]==1 || tag[j]==T)
	      {
	       printf("Cache hit...\n");
	      LRU[j]=i;
	       goto l1;
	      }
	     printf("Cache miss...\n");
	     for(j=0;j<32;j++)
	      if(flag[j]==0)
	      {
	       flag[j]=1;
	       tag[j]=T;
	       LRU[j]=i;
	       goto l1;
	      }
	      k=0;
	      for(j=0;j<32;j++)
	      if(LRU[j] < LRU[k])
		k=j;
	       tag[k]=T;
	      LRU[k]=i;
	      l1 : printa(tag,flag);
	     }
	     break;
  }
  getch();
 }
 while(op!=3);
}

