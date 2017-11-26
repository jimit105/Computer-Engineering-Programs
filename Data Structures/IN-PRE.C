		/* INFIX TO PREFIX AND EVALUATION */

#include<stdio.h>
#include<conio.h>
#include<string.h>
#include<ctype.h>
#define MAX 100

char st[MAX];
char st1[MAX];
int top=-1;
int top1=-1;

void reverse(char str[]);
void push(char st[],char);
char pop(char st[]);
void infixtopostfix(char source[],char target[]);
int getpriority(char);
char infix[100],postfix[100],temp[100],a[100],ev[100];
void evalpre(char st[]);

void main()
{
 clrscr();
 printf("\nEnter Infix Expression ");
 gets(infix);
 reverse(infix);
 strcpy(postfix,"");
 infixtopostfix(temp,postfix);
 printf("\nThe Corresponding Postfix Expression is ");
 puts(postfix);
 strcpy(temp,"");
 reverse(postfix);
 printf("\nThe Prefix Expression is ");
 puts(temp);
 strcpy(a,temp);
 strrev(a);
 evalpre(a);
 printf("\nResult=%d",ev[0]);
 getch();
}

//-------REVERSE-------
void reverse(char str[])
{
 int len=0,i=0,j=0;
 len=strlen(str);
 j=len-1;
 while(j>=0)
 {
  if(str[j]=='(')
   temp[i]=')';
  else if(str[j]==')')
   temp[i]='(';
  else
   temp[i]=str[j];
  i++,j--;
 }
 temp[i]='\0';
}

//-------INFIX TO POSTFIX-------
void infixtopostfix(char source[],char target[])
{
 int i=0,j=0;
 char temp;
 strcpy(target,"");
 while(source[i]!='\0')
 {
  if(source[i]=='(')
  {
   push(st,source[i]);
   i++;
  }
  else if(source[i]==')')
  {
   while(top!=-1 && st[top]!='(')
   {
    target[j]=pop(st);
    j++;
   }
   if(top==-1)
   {
    printf("\nInvalid Expression");
   }
   temp=pop(st);
   i++;
  }
  else if(isdigit(source[i]) || isalpha(source[i]))
  {
   target[j]=source[i];
   i++;
   j++;
  }
  else if(source[i]=='+' || source[i]=='-' || source[i]=='*' ||source[i]=='/' ||source[i]=='%' || source[i]=='^')
  {
   while(top!=-1 && (st[top]!='(') && getpriority(st[top])>getpriority(source[i]))
   {
    target[j]= pop(st);
    j++;
   }
  push(st,source[i]);
  i++;
  }
 else
 {
  printf("Invalid Expression\n");
 }
 }
 while((top!=-1) && (st[top]!='('))
 {
  target[j]=pop(st);
  j++;
 }
 target[j]='\0';
}

//-------GET PRIORITY-------
int getpriority(char op)
{
 if(op=='^')
  return 3;
 else if(op=='/'|| op=='%'|| op=='*')
  return 1;
 else if(op=='+' || op=='-')
  return 0;
}

//-------PUSH-------
void push(char st[],char val)
{
 if(top==MAX-1)
 {
  printf("Stack Overflow\n");
 }
 else
 {
  top++;
  st[top]=val;
 }
}

//-------POP-------
char pop(char st[])
{
 char val=' ';
 if(top==-1)
 {
  printf("Stack Underflow\n");
 }
 else
 {
  val=st[top];
  top--;
 }
 return val;
}

//-------EVALUATE PREFIX-------
void evalpre(char str[])
{
 int i=0,result;
 int op1,op2,res;
 while(str[i]!='\0')
 {
  if(isdigit(str[i]))
  {
   ev[++top1]=(int)str[i]-48;
  }
  else
  {
   op1=ev[top1--];
   op2=ev[top1];
   switch(str[i])
   {
    case '+':
     res=op1+op2;
     break;
    case '-':
     res=op1-op2;
     break;
    case'*':
     res=op1*op2;
     break;
    case'/' :
     res=op1/op2;
     break;
   }
   ev[top1]=res;
  }
  i++;
 }
}

/* OUTPUT

Enter Infix Expression 2*3+1

The Corresponding Postfix Expression is 132*+

The Prefix Expression is +*231

Result=7         */
                                                                                
                                                                                
                                                                                
                                                                                
                                                                                
                                                                                
                                                                                
                                                                                
                                                                                
                                                                                
                                                                                
                                                                                
                                                                                
                                                                                
                                                                                
                                                                                
                                                                                
                                                                                
                                                                                
                                                                                
                                                                                
                                                                                
                                                                                
                                                                                
                                                                                
                                                                                
                                                                                
                                                                                
                                                                                
                                                                                
                                                                                
                                                                                
                                                                                
                                                                                
                                                                                
                                                                                
                                                                                
                                                                                
                                                                                

