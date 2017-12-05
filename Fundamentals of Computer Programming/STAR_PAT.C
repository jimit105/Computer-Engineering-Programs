#include<stdio.h>
#include<conio.h>
void main()
{
 int n,i,j,k;
 clrscr();
 printf("Enter number of rows ");
 scanf("%d",&n);
 for(i=1;i<=n;i++)
 {
  for(k=1;k<=n-i;k++)
  {
   printf(" ");
   }
  for(j=1;j<=i;j++)
  {
   printf("* ");
   }
   printf("\n");
  }
 getch();
}

/* OUTPUT

Enter number of rows 5
    *
   * *
  * * *
 * * * *
* * * * *

*/
                                                                                

                                                                                
                                                                                
                                                                                
                                                                                
                                                                                
                                                                                
                                                                                
                                                                                
                                                                                
                                                                                
                                                                                
                                                                                
                                                                                
                                                                                
                                                                                
                                                                                
                                                                                
