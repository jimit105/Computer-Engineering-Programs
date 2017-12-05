#include<stdio.h>
#include<conio.h>
#include<stdlib.h>

void inputIP();
void classA();
void classB();
void classC();

int octet1, octet2, octet3, octet4;
int networks, address;
//networks- number of networks
//address- number of addresses in each network

int main()
{
 char class_input;

 clrscr();

 printf("\nEnter class: ");
 scanf("%c", &class_input);

 printf("\nEnter starting IP Address: ");
 inputIP();

 printf("\nEnter number of networks: ");
 scanf("%d", &networks);
 printf("\nEnter number of address in each network: ");
 scanf("%d", &address);

 switch(class_input)
 {
  case 'a':
  case 'A':
   if(octet1<0 || octet1>127)
    printf("\nInvalid IP");
   else
    classA();
   break;

  case 'b':
  case 'B':
   if(octet1<128 && octet1>191)
    printf("\nInvalid IP");
   else
    classB();
   break;

  case 'c':
  case 'C':
   if(octet1<192 && octet1>223)
    printf("\nInvalid IP");
   else
    classC();
  break;

  default:
   printf("\nInvalid Class");

 }


 getch();
 return 0;
}

//---- INPUT STARTING IP ADDRESS ----

void inputIP()
{
 printf("\n\t1st Octet: ");
 scanf("%d", &octet1);
 printf("\n\t2nd Octet: ");
 scanf("%d", &octet2);
 printf("\n\t3rd Octet: ");
 scanf("%d", &octet3);
 printf("\n\t4th Octet: ");
 scanf("%d", &octet4);

 printf("\nThe IP Address entered is %d.%d.%d.%d", octet1, octet2, octet3, octet4);

}

//---- Class A ----
void classA()
{
 int i;

 printf("\nNetwork\tStarting Address\tEnding Address\n");
 for(i=0;i<networks;i++)
 {
  printf("   %d\t", i+1);
  printf("  %d.%d.%d.%d\t", octet1+i,octet2, octet3, octet4);
  printf("         %d.%d.%d.%d",octet1+i, octet2, octet3, octet4+address-1);
  printf("\n");
 }
}

//---- Class B ----
void classB()
{
 int i;

 printf("\nNetwork\tStarting Address\tEnding Address\n");
 for(i=0;i<networks;i++)
 {
  printf("   %d\t", i+1);
  printf("  %d.%d.%d.%d\t", octet1,octet2+i, octet3, octet4);
  printf("         %d.%d.%d.%d",octet1, octet2+i, octet3, octet4+address-1);
  printf("\n");
 }
}

void classC()
{
 int i;

 printf("\nNetwork\tStarting Address\tEnding Address\n");
 for(i=0;i<networks;i++)
 {
  printf("   %d\t", i+1);
  printf("  %d.%d.%d.%d\t", octet1,octet2, octet3+i, octet4);
  printf("         %d.%d.%d.%d",octet1, octet2, octet3+i, octet4+address-1);
  printf("\n");
 }
}


