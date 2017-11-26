                /* Priority Queue using heap */

#include<stdio.h>
#include<math.h>
#define MAX 100

void swap(int*, int*);
void display(int[],int);
void insert(int[],int,int,int);
int del_hi_priori(int[],int,int);

int main()
{
    int lb,choice,num,n,a[MAX],data,s;
    choice = 0;
    n=0;	//Represents number of nodes in the queue
    lb=0;	//Lower bound of the array is initialized to 0
    while(choice != 4)
    {
        printf(".....MAIN MENU.....\n");
        printf("\n1.Insert.\n");
        printf("2.Delete.\n");
        printf("3.Display.\n");
        printf("4.Quit.\n");
        printf("\nEnter your choice : ");
        scanf("%d",&choice);
        switch(choice)
        {
        case 1:
            printf("Enter data to be inserted : ");
            scanf("%d",&data);
            insert(a,n,data,lb);
            n++;
            break;
        case 2:
            s=del_hi_priori(a,n+1,lb);
            if(s!=0)
            printf("The deleted value is : %d",s);
            if(n>0)
                n--;
            break;
        case 3:
            printf("\n");
            display(a,n);
            break;
        case 4:
            return 0;
        default:
            printf("Invalid choice\n");
        }
        printf("\n\n");
    }
return 0;
}

//-------INSERT-------
void insert(int a[],int heapsize,int data,int lb)
{
    int i,p;
    int parent(int);
    if(heapsize==MAX)
    {
        printf("Queue Is Full!!n");
        return;
    }
    i=lb+heapsize;
    a[i]=data;
    while(i>lb&&a[p=parent(i)]<a[i])
    {
        swap(&a[p],&a[i]);
        i=p;
    }
}

//-------DELETE-------
int del_hi_priori(int a[],int heapsize,int lb)
{
    int data,i,l,r,max_child,t;
    int left(int);
    int right(int);
    if(heapsize==1)
    {
        printf("Queue Is Empty!!\n");
        return 0;
    }
    t=a[lb];
    swap(&a[lb],&a[heapsize-1]);
    i=lb;
    heapsize--;
    while(1)
    {
        if((l=left(i))>=heapsize)
            break;
        if((r=right(i))>=heapsize)
            max_child=l;
        else
            max_child=(a[l]>a[r])?l:r;
        if(a[i]>=a[max_child])
            break;
        swap(&a[i],&a[max_child]);
        i=max_child;
    }
return t;
}

//Returns Parent Index
int parent(int i)
{
    float p;
    p=((float)i/2.0)-1.0;
    return ceil(p);
}

//Return Leftchild Index
int left(int i)
{
    return 2*i+1;
}

//Return Rightchild Index
int right(int i)
{
    return 2*i+2;
}

//-------DISPLAY-------
void display(int a[],int n)
{
    int i;
    if(n==0)
    {
        printf("Queue Is Empty!!\n");
        return;
    }
    for(i=0;i<n;i++)
        printf("%d ",a[i]);
    printf("\n");
}

//-------SWAP-------
void swap(int*p,int*q)
{
    int temp;
    temp=*p;
    *p=*q;
    *q=temp;
}


/* OUTPUT

.....MAIN MENU.....

1.Insert.
2.Delete.
3.Display.
4.Quit.

Enter your choice : 1
Enter data to be inserted : 5


.....MAIN MENU.....

1.Insert.
2.Delete.
3.Display.
4.Quit.

Enter your choice : 1
Enter data to be inserted : 3


.....MAIN MENU.....

1.Insert.
2.Delete.
3.Display.
4.Quit.

Enter your choice : 1
Enter data to be inserted : 2


.....MAIN MENU.....

1.Insert.
2.Delete.
3.Display.
4.Quit.

Enter your choice : 3

5 3 2


.....MAIN MENU.....

1.Insert.
2.Delete.
3.Display.
4.Quit.

Enter your choice : 2
The deleted value is : 5

.....MAIN MENU.....

1.Insert.
2.Delete.
3.Display.
4.Quit.

Enter your choice : 4
*/
