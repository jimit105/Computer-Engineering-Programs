			/* BINARY SEARCH */

#include<stdio.h>
#include<conio.h>
#include<stdlib.h>
#include<time.h>

void insertion_sort();
void print();
int binary(int arr[],int low,int high,int key);

int arr[100], n;

int main()
{
 int i, key, flag;
 time_t start, end;
 time_t diff;
 clrscr();

 printf("Enter the number of elements: ");
 scanf("%d",&n);
// printf("Enter the elements: ");
 for(i=0;i<n;i++)
 {
//  scanf("%d",&arr[i]);
  arr[i]=random(100);
 }
 printf("\nThe elements are ");
 for(i=0;i<n;i++)
 {
  printf("%d ", arr[i]);
 }

 insertion_sort();
 print();

 printf("\n\nEnter the element to be searched: ");
// scanf("%d",&key);
 key=random(100);
 printf("%d", key);

 start=time(NULL);
 flag=binary(arr,0,n-1,key);
 if(flag==-1)
  printf("\n%d not found",key);
 else
  printf("\n%d found at %d",key,flag+1);

 end=time(NULL);
 diff=difftime(end, start);
 printf("\n\nTime taken is %ld seconds", diff);

 getch();
 return 0;
}

//-------BINARY SEARCH-------
int binary(int arr[],int low,int high,int key)
{
 int mid;
  if(low>high)
  return -1;
 mid=(low+high)/2;
 if(key == arr[mid])
  return mid;
 else if(key < arr[mid])
  return(binary(arr,low,mid-1,key));
 else
  return(binary(arr,mid+1,high,key));
}

//-------INSERTION SORT-------
void insertion_sort()
{
    int i, j, temp;
    for(i=1; i<n; i++)
    {
	temp = arr[i];
	j = i-1;
	while((temp < arr[j]) && (j >= 0))
	{
	    arr[j+1] = arr[j];
	    j--;
	}
	arr[j+1] = temp;

    }
}

//-------PRINT ELEMENTS OF THE ARRAY-------
void print()
{
    int i;
    printf("\n\nThe sorted array is: ");
    for(i=0; i<n; i++)
	printf("   %d", arr[i]);
}

/* OUTPUT

Enter the number of elements: 10

The elements are 1 0 33 3 35 21 53 19 70 94

The sorted array is:    0   1   3   19   21   33   35   53   70   94

Enter the element to be searched: 27
27 not found

Time taken is 0 seconds
*/



                                                                                
                                                                                
                                                                                
                                                                                
                                                                                
                                                                                
                                                                                
                                                                                
                                                                                
                                                                                
