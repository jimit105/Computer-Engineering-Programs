                /* Write a program to read the text file ,
                        one line at a time and
                print the line read  with text reversed.*/

#include<stdio.h>
#include<conio.h>
#include<string.h>
#define MAX 150

char stk[150];
int top = -1;

void push(char stk[], char val);
void pop(char stk[]);

int main()
{
    FILE *fp;
    char line[150];
    int i, len;
    clrscr();

    fp = fopen("sample.txt", "r");
    if(fp == NULL)
    {
	printf("\nERROR-Unable to open file");
    }
    else
    {
	while(1)
	{
	    if(fgets(line, 150, fp) == NULL)
		break;
	    len = strlen(line);

	    printf("\n\nThe contents of the file are: \n");
	    for(i = 0; i < len; i++)
	    {
		printf("%c", line[i]);
		push(stk, line[i]);
	    }

	    printf("\n\nThe reverse of the contents is: \n");
	    for(i = 0; i < len; i++)
	    {
		pop(stk);
	    }

	}
    }
    fclose(fp);
    getch();
    return 0;
}

void push(char stk[], char val)
{
    if(top == MAX-1)
    {
	printf("\nSTACK OVERFLOW");
    }
    else
    {
        top++;
        stk[top] = val;
    }
}

void pop(char stk[])
{
    if(top == -1)
    {
        printf("\nSTACK UNDERFLOW");
    }
    else
    {
        printf("%c", stk[top]);
        top--;
    }
}


/* OUTPUT

The contents of the file are:
Deal with your problems before they deal with your happiness.

The reverse of the contents is:
.ssenippah ruoy htiw laed yeht erofeb smelborp ruoy htiw laeD
*/
