			/* N-QUEEN PROBLEM */

#include<stdio.h>
#include<conio.h>

static int count=0;
int x[100];
int mat[100][100]={0};

void nqueen(int k, int n);
int place(int k, int i);
void init(int n);
void show(int n);

int main()
{
 int n;
 clrscr();

 printf("Enter the value of n: ");
 scanf("%d",&n);

 printf("\nThe solutions are: \n");
 nqueen(1,n);

 printf("\nThe total number of solutions is %d",count);
 getch();
 return 0;
}

void nqueen(int k,int n)
{
 int i,j;
 for(i=1;i<=n;i++)
 {
  if(place(k,i))
  {
   x[k]=i;
   if(k==n)
   {
    for(j=1;j<=n;j++)
    {
     printf("%d ",x[j]);
    }
    count++;
    printf("\n\nIn Matrix Form:\n");
    show(n);
    printf("\n");
    init(n);
   }
   else
    nqueen(k+1,n);
  }
 }
}

//Returns 1 if a queen can be placed in kth row and ith column
//Else returns 0
int place(int k,int i)
{
 int j;

 for(j=1;j<k;j++)
  if((x[j]==i) || (abs(x[j]-i)==abs(j-k)))
   return 0;

 return 1;
}

void show(int n)
{
 int i, j;
 for(i=1;i<=n;i++)
 {
  mat[i][x[i]]=1;
 }
 for(i=1;i<=n;i++)
 {
  for(j=1;j<=n;j++)
  {
   printf("%d ", mat[i][j]);
  }
  printf("\n");
 }
}

void init(int n)
{
 int i,j;
 for(i=1;i<=n;i++)
  for(j=1;j<=n;j++)
   mat[i][j]=0;
}


/* OUTPUT

Enter the value of n: 4

The solutions are:
2 4 1 3

In Matrix Form:
0 1 0 0
0 0 0 1
1 0 0 0
0 0 1 0

3 1 4 2

In Matrix Form:
0 0 1 0
1 0 0 0
0 0 0 1
0 1 0 0


The total number of solutions is 2
*/



