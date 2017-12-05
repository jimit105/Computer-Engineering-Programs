#include<stdio.h>
#include<conio.h>
void main()
{
 float f,c;
 clrscr();
 printf("Enter temperature in Degree Centigrade ");
 scanf("%f",&c);
 f=(1.8*c)+32;
 printf("The temperature in Fahrenheit is %f",f);
 getch();
 }