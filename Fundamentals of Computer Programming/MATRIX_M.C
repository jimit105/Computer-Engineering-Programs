#include<stdio.h>
#include<conio.h>
void main()
{
 int a[20][20],b[20][20],c[20][20],m1,n1,m2,n2,i,j,k;
 clrscr();

 printf("Enter order of first matrix ");
 scanf("%d%d",&m1,&n1);
 printf("Enter order of second matrix ");
 scanf("%d%d",&m2,&n2);
 if(n1!=m2)
 printf("Matrix Multiplication is not possible");
 else
 {
  for(i=0;i<m1;i++)
  {
   for(j=0;j<n1;j++)
   {
    printf("Enter element at a[%d][%d] ",i,j);
    scanf("%d",&a[i][j]);
    }
   }
  for(i=0;i<m2;i++)
  {
   for(j=0;j<n2;j++)
   {
    printf("Enter element at b[%d][%d] ",i,j);
    scanf("%d",&b[i][j]);
    }
   }
  for(i=0;i<m1;i++)
  {
   for(j=0;j<n2;j++)
   {
    c[i][j]=0;
    for(k=0;k<n1;k++)
    {
     c[i][j]=c[i][j]+a[i][j]*b[i][j];
     }
   printf("%d\t",c[i][j]);
    }
   printf("\n");
   }
  }
 getch();
 }
