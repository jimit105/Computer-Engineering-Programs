#include<stdio.h>
#include<conio.h>
#include<math.h>
void main()
{
 float r,x1,y1,x2,y2,d;
 clrscr();
 printf("Enter co-ordinates of center ");
 scanf("%f%f",&x1,&y1);
 printf("Enter radius of circle ");
 scanf("%f",&r);
 printf("Enter co-ordinates of a point ");
 scanf("%f%f",&x2,&y2);
 d=sqrt(pow(x2-x1,2)+pow(y2-y1,2));
 if (d<r)
 printf("The point lies inside the circle ");
 else if (d==r)
 printf("The point lies on the circle ");
 else
 printf("The point lies outside the circle ");
 getch();
 }