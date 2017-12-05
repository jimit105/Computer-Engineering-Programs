#include<stdio.h>
#include<conio.h>
void main()
{
 int n,m,sum=0,rev=0;
 clrscr();
 printf("Enter a number ");
 scanf("%d",&n);
 while (n!=0)
 {
  m=n%10;
  sum=sum+m;
  rev=rev*10+m;
  n=n/10;
  }
 printf("The sum of the digits is %d",sum);
 printf("\nThe reverse of the number is %d",rev);
 getch();
 }