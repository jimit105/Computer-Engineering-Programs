			/* MERGE SORT */

#include<stdio.h>
#include<stdlib.h>
#include<conio.h>
#include<time.h>

int arr[10000], n, b[10000];

void MergeSort(int low, int high);
void Merge(int low, int mid, int high);
void show();

int main()
{
// int arr[100], n;
 int i;
 time_t start, end;
 time_t diff;
 clrscr();

 printf("\nEnter the number of elements: ");
 scanf("%d", &n);

 randomize();     //Generates random elements

// printf("\nEnter the elements: ");
 for(i=0; i<n; i++)
 {
//  scanf("%d", &a[i]);
 arr[i]=random(100);
 }
 printf("\nThe elements are ");
 for(i=0; i<n; i++)
 {
  printf("%d ", arr[i]);
 }

 start=time(NULL);
 printf("\n\nThe passes are:");
 MergeSort(0, n-1);
 end=time(NULL);
 diff=difftime(end, start);

 printf("\n\nThe sorted array is ");
 for(i=0; i<n; i++)
  printf("%d ", arr[i]);

 printf("\n\nTime taken is %ld seconds", diff);

 getch();
 return 0;
}

//-------MERGE SORT-------
void MergeSort(int low, int high)
{
 if(low<high)     //more than 1 element
 {
  //Divide p into sub-problems
  //Find where to split the set
  int mid=(low+high)/2;

  //Solve the sub-problems
  MergeSort(low, mid);
  MergeSort(mid+1, high);

  //Combine the solutions
  Merge(low, mid, high);
 }
}

//-------MERGE THE ARRAYS-------
void Merge(int low, int mid, int high)
{
 int h=low;
 int i=low;
 int j=mid+1;
 int k;

 show();

 while((h<=mid) && (j<=high))
 {
  if(arr[h]<=arr[j])
  {
   b[i]=arr[h];
   h++;
  }
  else
  {
   b[i]=arr[j];
   j++;
  }
 i++;
 }

 if(h>mid)
  for(k=j; k<=high;k++)
  {
   b[i]=arr[k];
   i++;
  }
 else
  for(k=h; k<=mid; k++)
  {
   b[i]=arr[k];
   i++;
  }

 for(k=low; k<=high; k++)
  arr[k]=b[k];
}

//-------PRINT ELEMENTS OF THE ARRAY FOR EACH PASS-------
void show()
{
    int j;
//    printf("\nPasses are: ");
    printf("\n");
    for(j=0; j<n; j++)
	printf("   %d", arr[j]);
}

/* OUTPUT

Enter the number of elements: 5

The elements are 24 7 18 99 76

The passes are:
   24   7   18   99   76
   7   24   18   99   76
   7   18   24   99   76
   7   18   24   76   99

The sorted array is 7 18 24 76 99

Time taken is 0 seconds
*/
                                                                                
                                                                                
                                                                                
                                                                                
                                                                                
                                                                                
                                                                                
                                                                                
                                                                                
                                                                                
                                                                                
