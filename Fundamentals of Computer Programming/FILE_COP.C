#include<stdio.h>
#include<conio.h>
void main()
{
 FILE *fp1,*fp2;
 char line[100];
 clrscr();
 fp1=fopen("a.txt","r");
 fp2=fopen("b.txt","w");
 if (fp1==NULL)
  printf("Can't open file");
 else
 {
  while(!(feof(fp1)))
  {
   fgets(line,100,fp1);
   fputs(line,fp2);
   }
  }
 getch();
 }