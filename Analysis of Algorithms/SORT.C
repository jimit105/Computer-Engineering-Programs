		/* INSERTION AND SELECTION SORTING */

#include<stdio.h>
#include<conio.h>
#include<stdlib.h>
#include<time.h>

void insertion_sort();
int smallest(int k);
void selection_sort();

void input();
void print();
void show(int i);

int arr[25000], n;

int main()
{
    int ch;
    time_t start, end;
    time_t diff;
    clrscr();
    printf("\n1.Insertion Sort");
    printf("\n2.Selection Sort");
    printf("\nEnter your choice: ");
    scanf("%d", &ch);
    switch(ch)
    {
    case 1:
	input();
//	start=time(NULL);
	insertion_sort();
	print();
	break;
    case 2:
	input();
//	start=time(NULL);
	selection_sort();
	print();
	break;
    default:
	printf("\nInvalid Choice");
	break;
    }
//    end=time(NULL);
//    diff=difftime(end,start);
//    printf("\n\nTime taken is %ld seconds", diff);
    getch();
    return 0;
}

//-------INPUT ELEMENTS OF THE ARRAY-------
void input()
{
    int i;
    printf("\nEnter the number of elements in the array: ");
    scanf("%d", &n);
    printf("\nEnter the elements of the array: ");
    for(i=0; i<n; i++)
    {
	scanf("%d", &arr[i]);
  //	arr[i]=random(1000);
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
	show(i);
    }
}

//-------FIND SMALLEST ELEMENT IN UNSORTED LIST-------
int smallest(int k)
{
    int pos = k, small = arr[k], i;
    for(i = k+1; i<n; i++)
    {
	if(arr[i] < small)
	{
	    small = arr[i];
	    pos = i;
	}
    }
    return pos;
}

//-------SELECTION SORT-------
void selection_sort()
{
    int k, pos, temp;
    for(k = 0; k < n-1; k++)
    {
	pos = smallest(k);
	temp = arr[k];
	arr[k] = arr[pos];
	arr[pos] = temp;
	show(k+1);
    }
}

//-------PRINT ELEMENTS OF THE ARRAY FOR EACH PASS-------
void show(i)
{
    int j;
    printf("\nPass %d: ",i);
    for(j=0; j<n; j++)
	printf("   %d", arr[j]);
}

/* OUTPUT-1 INSERTION SORT

1.Insertion Sort
2.Selection Sort
Enter your choice: 1

Enter the number of elements in the array: 10

Enter the elements of the array: -3 8 6 4 9 0 -7 5 1 3

Pass 1:    -3   8   6   4   9   0   -7   5   1   3
Pass 2:    -3   6   8   4   9   0   -7   5   1   3
Pass 3:    -3   4   6   8   9   0   -7   5   1   3
Pass 4:    -3   4   6   8   9   0   -7   5   1   3
Pass 5:    -3   0   4   6   8   9   -7   5   1   3
Pass 6:    -7   -3   0   4   6   8   9   5   1   3
Pass 7:    -7   -3   0   4   5   6   8   9   1   3
Pass 8:    -7   -3   0   1   4   5   6   8   9   3
Pass 9:    -7   -3   0   1   3   4   5   6   8   9

The sorted array is:    -7   -3   0   1   3   4   5   6   8   9
*/

/* OUTPUT-2 SELECTION SORT

1.Insertion Sort
2.Selection Sort
Enter your choice: 2

Enter the number of elements in the array: 10

Enter the elements of the array: -4 6 2 3 1 0 -9 8 5 7

Pass 1:    -9   6   2   3   1   0   -4   8   5   7
Pass 2:    -9   -4   2   3   1   0   6   8   5   7
Pass 3:    -9   -4   0   3   1   2   6   8   5   7
Pass 4:    -9   -4   0   1   3   2   6   8   5   7
Pass 5:    -9   -4   0   1   2   3   6   8   5   7
Pass 6:    -9   -4   0   1   2   3   6   8   5   7
Pass 7:    -9   -4   0   1   2   3   5   8   6   7
Pass 8:    -9   -4   0   1   2   3   5   6   8   7
Pass 9:    -9   -4   0   1   2   3   5   6   7   8

The sorted array is:    -9   -4   0   1   2   3   5   6   7   8
*/