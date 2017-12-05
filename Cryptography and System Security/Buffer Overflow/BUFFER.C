#include<stdio.h>
#include<conio.h>
#include<string.h>
void main()
{
	char *ptr;
	char *dptr;
	clrscr();
	ptr=(char*)malloc(10*sizeof(char));
	dptr=(char*)malloc(10*sizeof(char));
	printf("Address of ptr %d\n",ptr);
	printf("Address of dptr %d\n",dptr);
	printf("\n\nEnter the String:\n");
	gets(ptr);
	system(dptr);
	getch();
}