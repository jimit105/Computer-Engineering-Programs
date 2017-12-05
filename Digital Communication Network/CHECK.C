/* CHECKSUM */

#include<stdio.h>
#include<conio.h>

void main()
{
 int a[4], b[4], s_check, r_check, s_sum=0, r_sum=0;
 int i;
 clrscr();

 printf("\n----SENDER----");
 printf("\nEnter the values in hex: ");
 for(i=0;i<4;i++)
 {
  scanf("%x", &a[i]);
 }

 printf("\nEnter checksum: ");
 scanf("%x", &s_check);

 for(i=0; i<4; i++)
 {
  s_sum=s_sum+a[i];
 }
 s_sum=s_sum+s_check;
 printf("\nThe sum is %x", s_sum);
 s_sum=s_sum+1;
 s_sum=~s_sum;
 printf("\nThe checksum generated is %x", s_sum);

 printf("\n----RECEIVER----");
 printf("\nEnter the values in hex: ");
 for(i=0;i<4;i++)
 {
  scanf("%x", &b[i]);
 }

 printf("\nEnter checksum: ");
 scanf("%x", &r_check);

 for(i=0; i<4; i++)
 {
  r_sum=r_sum+b[i];
 }
 r_sum=r_sum+r_check;
 printf("\nThe sum is %x", r_sum);
 r_sum=r_sum+1;
 r_sum=~r_sum;
 printf("\nThe checksum generated is %x", r_sum);

 if(r_sum==0000)
  printf("\nNo Error in Transmission");
 else
  printf("\nError!");


 getch();
}

/* OUTPUT


----SENDER----
Enter the values in hex: 466f 726f 757a 616e

Enter checksum: 0000

The sum is 8fc6
The checksum generated is 7038
----RECEIVER----
Enter the values in hex: 466f 726f 757a 616e

Enter checksum: 7038

The sum is fffe
The checksum generated is 0
No Error in Transmission
*/