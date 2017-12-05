#include<stdio.h>
#include<conio.h>
int fact(int);
void main()
{
 int no;
 long fact1;
 clrscr();
 printf("Enter a number ");
 scanf("%d",&no);
 fact1=fact(no);
 printf("The factorial of the number is %ld", fact1);
 getch();
 }
int fact(int no)
{
 int i;
 long result=1;
 for(i=no;i>=1;i--)
 result=result*i;
 return result;
 }
