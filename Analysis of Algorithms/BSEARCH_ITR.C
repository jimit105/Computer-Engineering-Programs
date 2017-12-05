	/* BINARY SEARCH- ITERATIVE APPROACH */

#include<stdio.h>
#include<conio.h>

void main()
{
 int n, arr[50], first, mid, last, key, loc, i;
 int flag=0;
 clrscr();

 printf("\nEnter number of elements: ");
 scanf("%d", &n);
 printf("\nEnter the elements: ");
 for(i=0; i<n; i++)
  scanf("%d", &arr[i]);

 first=0;
 last=n;

 printf("\nEnter the element to be searched: ");
 scanf("%d", &key);

 while(first<=last)
 {
  mid=(first+last)/2;

  if(arr[mid]==key)
  {
   flag=1;
   printf("\nElement found at location %d", mid+1);
   break;
  }
  else if(key>arr[mid])
   first=mid+1;
  else
   last=mid-1;
 }

 if(flag==0)
 printf("\nElement not found");

 getch();
}

/* OUTPUT-1


Enter number of elements: 5                                                     
                                                                                
Enter the elements: 1 3 4 6 7                                                   
                                                                                
Enter the element to be searched: 4                                             
                                                                                
Element found at location 3
*/

/* OUTPUT-2


Enter number of elements: 5                                                     
                                                                                
Enter the elements: 1 3 4 6 7                                                   
                                                                                
Enter the element to be searched: 5                                             
                                                                                
Element not found
*/


                                                                                
                                                                                
                                                                                
                                                                                
                                                                                
                                                                                
                                                                                
                                                                                
                                                                                
                                                                                
                                                                                
                                                                                
                                                                                
                                                                                
                                                                                

                                                                                
                                                                                
                                                                                
                                                                                
                                                                                
                                                                                
                                                                                
                                                                                
                                                                                
                                                                                
                                                                                
                                                                                
                                                                                
                                                                                
                                                                                
                                                                                
                                                                                



