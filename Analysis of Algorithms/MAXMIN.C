		/* MAX-MIN USING DIVIDE AND CONQUER */

#include<stdio.h>
#include<conio.h>
#include<stdlib.h>
#include<time.h>

void MaxMin(int i,int j);

int arr[1000], max, min;

int main()
{
 int n,i;
 time_t start, end;
 time_t diff;
 clrscr();

 printf("Enter the number of elements: ");
 scanf("%d",&n);
 printf("Enter the elements: ");
 randomize();         //Generates random numbers
 for(i=0;i<n;i++)
 {
//  scanf("%d",&arr[i]);
  arr[i]=random(100);
 }
 for(i=0;i<n;i++)
 {
  printf("%d ",arr[i]);
 }

 min=arr[0];
 max=arr[0];
 start=time(NULL);
 MaxMin(0,n-1);
 printf("\n\nMaximum value: %d \nMinimum value: %d\n",max,min);
 end=time(NULL);
 diff=difftime(end, start);
 printf("\nTime taken is %ld seconds\n",diff);

 getch();
 return 0;
}

//-------FIND MAX AND MIN-------
void MaxMin(int i,int j)
{
 int max1,min1;
 if(i==j)             //Only 1 element
  max=min=arr[i];
 else if(j==i+1)     //2 elements
 {
  if(arr[i]<arr[j])
  {
   min=arr[i];
   max=arr[j];
  }
  else
  {
   min=arr[j];
   max=arr[i];
  }
 }
 else                 //More than 2 elements
 {
  int mid=(i+j)/2;
  MaxMin(i,mid);
  max1=max;
  min1=min;
  MaxMin(mid+1,j);

  if(min1<min)
   min=min1;
  if(max<max1)
   max=max1;
 }
}

/* OUTPUT

Enter the number of elements: 10
Enter the elements: 98 61 53 75 28 92 93 94 22 90

Maximum value: 98
Minimum value: 22

Time taken is 0 seconds
*/
                                                                                
                                                                                
                                                                                
                                                                                
                                                                                
                                                                                
                                                                                
                                                                                
                                                                                
                                                                                
                                                                                
                                                                                
                                                                                
                                                                                
                                                                                
                                                                                
                                                                                
                                                                                
