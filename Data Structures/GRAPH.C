			/* GRAPH- BFS and DFS */

#include<conio.h>
#include<stdio.h>
# define  MAX 20
int q[ MAX ], top = -1, front = -1, rear = -1, a[ MAX ][ MAX ], vis[ MAX ], stack[ MAX ];
int delete();
void add ( int item );
void bfs( int s, int n );
void dfs( int s, int n );
void push( int item );
int pop();
int main()
{
    int n, i, s, ch, j;
    char c;
    char dummy;
    clrscr();
    printf( "Enter the number of vertices: ");
    scanf( "%d", &n );
     printf( "Enter Adjacency Matrix: \n");
    for ( i = 0;i < n;i++ )
    {
	for ( j = 0;j < n;j++ )
	{

	    scanf( "%d",&a[i][j]);
	}
    }

    printf( "The Matrix is ");

    for ( i = 0;i < n;i++ )
    {
			printf("\n");
			for ( j = 0;j < n;j++ )
	    {
		printf( " %d", a[ i ][ j ] );
	    }
    }

	do
    {
	for ( i = 1;i <= n;i++ )
		{
	    vis[ i ] = 0;
		}
		printf( "\nMENU" );
	printf( "\n1.BFS\n2.DFS" );
	printf( "\nEnter Your Choice: " );
	scanf( "%d", &ch );
	printf( "Enter the source vertex: " );
	scanf( "%d", &s );
	switch ( ch )
	    {
	    case 1:
		bfs( s, n );
		break;
	    case 2:
		dfs( s, n );
		break;
	    }
	printf( "\nDo You Want To Continue? (Y/N)" );
	scanf( "%c", &dummy );
	scanf( "%c", &c );
    } while ( (c == 'y' ) );
    return 0;
}
void bfs( int s, int n )
{
    int p, i;
    add(s);
    vis[s] = 1;
    p = delete();
    if ( p != 0 )
	{
	printf( " %d", p );
	}
	while ( p != 0 )
	{
	    for ( i = 1;i <= n;i++ )
		if ( ( a[ p ][ i ] == 1 ) && ( vis[ i ] == 0 ) )
		    {
			add( i );

			vis[ i ] = 1;
		    }

	    p = delete();

	    if ( p != 0 )
		printf( " %d ", p );
	}

    for ( i = 1;i <= n;i++ )
	if ( vis[ i ] == 0 )
            bfs( i, n );
}
void add(int item)
{
    if ( rear == MAX-1 )
        printf( "\nQUEUE FULL" );
    else
        {
            if ( rear == -1 )
                {
                    q[ ++rear ] = item;
                    front++;
                }
            else
                q[ ++rear ] = item;
        }
}

int delete()
{
    int k;

    if ( ( front > rear ) || ( front == -1 ) )
        return ( 0 );
    else
        {
            k = q[ front++ ];
            return ( k );
        }
}
void dfs( int s, int n )
{
    int i, k;
    push( s );
    vis[ s ] = 1;
    k = pop();

    if ( k != 0 )
        printf( " %d ", k );

    while ( k != 0 )
    {
            for ( i = 1;i <= n;i++ )
                if ( ( a[ k ][ i ] == 1 ) && ( vis[ i ] == 0 ) )
                    {
                        push( i );
                        vis[ i ] = 1;
                    }

            k = pop();

            if ( k != 0 )
                printf( " %d ", k );
     }

    for ( i = 1;i <= n;i++ )
	{
        if ( vis[ i ] == 0 )
            dfs( i, n );
	}
}

void push( int item )
{
    if ( top == MAX-1 )
        printf( "Stack overflow " );
    else
        stack[++top] = item;
}

int pop()
{
    int k;
    if ( top == -1 )
	{
	return ( 0 );
	}
	else
    {
	k = stack[top--];
	return(k);
    }
}

/* OUTPUT

Enter the number of vertices: 5
Enter Adjacency Matrix:
0 0 0 1 0
0 0 0 1 1
0 0 0 0 1
1 1 0 0 1
0 1 1 1 0
The Matrix is
 0 0 0 1 0
 0 0 0 1 1
 0 0 0 0 1
 1 1 0 0 1
 0 1 1 1 0
MENU
1.BFS
2.DFS
Enter Your Choice: 1
Enter the source vertex: 1
 1 3  4  2  5
Do You Want To Continue? (Y/N)y

MENU
1.BFS
2.DFS
Enter Your Choice: 2
Enter the source vertex: 1
 1  4  2  3  5
Do You Want To Continue? (Y/N)n
*/