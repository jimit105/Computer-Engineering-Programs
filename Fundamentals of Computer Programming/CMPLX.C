#include<stdio.h>
#include<conio.h>
struct cmplx
{
 float r,i;
 };
void add(struct cmplx c1,struct cmplx c2);
void subtract(struct cmplx c1,struct cmplx c2);
struct cmplx c1,c2,c3;
void main()
{
 clrscr();
 printf("Enter first number ");
 scanf("%f%f",&c1.r,&c1.i);
 printf("Enter second number ");
 scanf("%f%f",&c2.r,&c2.i);
 add(c1,c2);
 subtract(c1,c2);
 getch();
 }
 void add(struct cmplx c1,struct cmplx c2)
 {
  c3.r=c1.r+c2.r;
  c3.i=c1.i+c2.i;
  printf("\nThe addition is %.2f + %.2fi",c3.r,c3.i);
  }
 void subtract(struct cmplx c1,struct cmplx c2)
 {
  c3.r=c1.r-c2.r;
  c3.i=c1.i-c2.i;
  printf("\nThe subtraction is %.2f + %.2fi",c3.r,c3.i);
  }