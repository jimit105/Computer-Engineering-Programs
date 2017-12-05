#include<stdio.h>
#include<conio.h>
void main()
{
 int m,y;
 clrscr();
 printf("Enter Month and Year ");
 scanf("%d%d",&m,&y);
 switch(m)
 {
  case 1:
  case 3:
  case 5:
  case 7:
  case 8:
  case 10:
  case 12:
  printf("No. of days=31");
  break;
  case 4:
  case 6:
  case 9:
  case 11:
  printf("No. of days=30");
  break;
  case 2:
  if (y%400==0||y%100!=0&&y%4==0)
  printf("No. of days=29");
  else
  printf("No. of days=28");
  break;
  default:
  printf("Invalid Month");
  }
 getch();
 }