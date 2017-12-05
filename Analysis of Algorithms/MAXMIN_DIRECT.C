	/* MAX-MIN USING DIRECT APPROACH */

#include<stdio.h>
#include<conio.h>

void main()
{
 int n, arr[50], i;
 int max=-32768, min=32767;
 clrscr();
 printf("\nEnter number of elements: ");
 scanf("%d", &n);
 printf("\nEnter the elements: ");
 for(i=0; i<n; i++)
  scanf("%d", &arr[i]);

 for(i=0; i<n; i++)
 {
  if(arr[i]>max)
   max=arr[i];
  if(arr[i]<min)
   min=arr[i];
 }

 printf("\nMaximum element=%d", max);
 printf("\nMinimum element=%d", min);

 getch();
}


