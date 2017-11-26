		/* INSERTION AND SELECTION SORTING */

#include<stdio.h>
#include<conio.h>

void insertion_sort();
int smallest(int k);
void selection_sort();

void input();
void print();

int arr[10], n;

int main()
{
//    int arr[10], i, n;
    int ch;
    clrscr();
    printf("\n1.Insertion Sort");
    printf("\n2.Selection Sort");
    printf("\nEnter your choice: ");
    scanf("%d", &ch);
    switch(ch)
    {
    case 1:
	input();
	insertion_sort();
	print();
	break;
    case 2:
	input();
	selection_sort();
	print();
	break;
    default:
	printf("\nInvalid Choice");
	break;
    }
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
    }
}

//-------PRINT ELEMENTS OF THE ARRAY-------
void print()
{
    int i;
    printf("\nThe sorted array is: ");
    for(i=0; i<n; i++)
	printf("\t%d", arr[i]);
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
    for(k = 0; k < n; k++)
    {
	pos = smallest(k);
	temp = arr[k];
	arr[k] = arr[pos];
	arr[pos] = temp;
    }
}

/* OUTPUT-1

1.Insertion Sort
2.Selection Sort
Enter your choice: 1

Enter the number of elements in the array: 4

Enter the elements of the array: 2 4 1 5

The sorted array is:    1       2       4       5
*/

/* OUTPUT-2

1.Insertion Sort
2.Selection Sort
Enter your choice: 2

Enter the number of elements in the array: 4

Enter the elements of the array: 2 4 1 5

The sorted array is:    1       2       4       5
*/