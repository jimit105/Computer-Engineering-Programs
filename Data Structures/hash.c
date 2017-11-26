                    /* Hashing- Linear and Quadratic Probing */

#include<stdio.h>
#include<conio.h>
int table[100],size;
int hash(int key)
{
    int pos;
    pos=key%size;
    return pos;
}

int linearhash(int key,int j)
{
    int hashv,poslh;
    hashv=hash(key);
    poslh=(hashv+j)%size;
    return poslh;
}

int quadhash(int key,int j)
{
    int rhashv,posqh;
    rhashv=hash(key);
    posqh=(rhashv+j*j)%size;
    return posqh;
}

void initlz()
{
    int i;
    for(i=0;i<100;i++)
    {
        table[i]=-1;
    }
}

void main()
{
    int i,j,n,prob,emppos,val[100];
    clrscr();
    printf("\nEnter the size of the table: ");
    scanf("%d",&size);
    printf("\nEnter the number of entries: ");
    scanf("%d",&n);

    printf("\n\nNote: You cannot enter negative numbers(-1....) as the array value\n\n");
    printf("Enter the elements: ");
    for(i=0;i<n;i++)
    {
        scanf("%d",&val[i]);
    }
    do
    {
        printf("\n\n1.Linear Probing \n2.Quadratic Probing \n3.Exit \nEnter the option: ");
        scanf("%d",&prob);
        switch(prob)
        {
        case 1:
            initlz();
            for(i=0;i<n;i++)
            {
            emppos=hash(val[i]);
            j=1;
            while(table[emppos]!=-1)
            {
            emppos=linearhash(val[i],j);
            j++;
            }
            table[emppos]=val[i];
            }
            printf("\n******Displaying the data-Linear probing******");
            printf("\nNote: '-1' Represents Empty Location\n");
            for(i=0;i<size;i++)
            {
                printf("\nTable[%d]=%d",i,table[i]);
            }
            break;
        case 2:
            initlz();
            for(i=0;i<n;i++)
            {
                emppos=hash(val[i]);
                j=1;
                while(table[emppos]!=-1)
                {
                    emppos=quadhash(val[i],j);
                    j++;
                }
                table[emppos]=val[i];
            }
            printf("\n******Displaying the data-Quadratic Probing******");
            printf("\nNote: '-1' Represents Empty Location\n");
            for(i=0;i<size;i++)
            {
                printf("\nTable[%d]=%d",i,table[i]);
            }
            break;
        }
    }while(prob!=3);
    getch();
}


/* OUTPUT

Enter the size of the table: 10

Enter the number of entries: 8


Note: You cannot enter negative numbers(-1....) as the array value

Enter the elements: 72 27 36 24 63 81 92 101


1.Linear Probing
2.Quadratic Probing
3.Exit
Enter the option: 1

******Displaying the data-Linear probing******
Note: '-1' Represents Empty Location

Table[0]=-1
Table[1]=81
Table[2]=72
Table[3]=63
Table[4]=24
Table[5]=92
Table[6]=36
Table[7]=27
Table[8]=101
Table[9]=-1

1.Linear Probing
2.Quadratic Probing
3.Exit
Enter the option: 2

******Displaying the data-Quadratic Probing******
Note: '-1' Represents Empty Location

Table[0]=-1
Table[1]=81
Table[2]=72
Table[3]=63
Table[4]=24
Table[5]=101
Table[6]=36
Table[7]=27
Table[8]=92
Table[9]=-1

1.Linear Probing
2.Quadratic Probing
3.Exit
Enter the option: 3
*/
