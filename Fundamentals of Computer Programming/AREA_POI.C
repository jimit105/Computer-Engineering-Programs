#define PI 3.14
#include<stdio.h>
#include<conio.h>
float area(int *r)
{
 float a1;
 a1=PI*(*r)*(*r);
 return(a1);
 }
void main()
{
 float a;
 int r;
 clrscr();
 printf("Enter the radius ");
 scanf("%d",&r);
 a=area(&r);
 printf("The area is %f",a);
 getch();
 }
