#include<stdio.h>
#include<conio.h>
void main()
{
 int a[50],n,c=0,flag=0,s,i;
 clrscr();
 printf("Enter number of elements ");
 scanf("%d",&n);
 printf("Enter the elements ");
 for(i=0;i<=n-1;i++)
 {
  scanf("%d",&a[i]);
  }
 printf("Enter element to be searched ");
 scanf("%d",&s);
 for(i=0;i<=n-1;i++)
 {
  if(s==a[i])
  {
   flag=1;
   c++;
   }
  }
 if(flag==1)
 printf("The element occurs %d times",c);
 else
 printf("The element is not found");
 getch();
 }