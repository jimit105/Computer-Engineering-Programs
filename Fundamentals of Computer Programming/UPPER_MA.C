#include<stdio.h>
#include<conio.h>
void main()
{
 int a[20][20],m,i,j,sum=0;
 clrscr();
 printf("Enter the order of square matrix ");
 scanf("%d",&m);
 for(i=0;i<m;i++)
 {
  for(j=0;j<m;j++)
  {
   printf("Enter the element at a[%d][%d] ",i,j);
   scanf("%d",&a[i][j]);
   }
  }
 for(i=0;i<m;i++)
 {
  for(j=0;j<m;j++)
  {
   if(j>=i)
   sum=sum+a[i][j];
   }
  }
 printf("The sum of the diagonal elements is %d",sum);
 getch();
 }
