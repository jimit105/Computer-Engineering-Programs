	/*Operations on linked list-
	count no. of nodes, reverse
	and concatenate */

#include<stdio.h>
#include<conio.h>
#include<malloc.h>

//Declaration of node
struct node
{
 int data;
 struct node *next;
};
struct node *start=NULL, *ptr, *start1=NULL, *start2=NULL, *new_node;

//Declaration of functions
struct node *create(struct node *);
void *display(struct node *);
void *count(struct node *);
struct node *concat(struct node *, struct node *);
struct node *reverse(struct node *);

void main()
{
 int choice;
 clrscr();
 printf("Operations:\n1. Create a linked list\n2. Count the number of nodes\n3. Reverse the linked list\n4. Concatenate two linked lists\n");
 printf("\nEnter your choice ");
 scanf("%d",&choice);

 switch(choice)
 {
  case 1:
  start=create(start);
  printf("\nThe linked list is \n");
  display(start);
  break;

  case 2:
  start=create(start);
  count(start);
  break;

  case 3:
  start=create(start);
  start=reverse(start);
  printf("\nThe reverse of the linked list is \n");
  display(start);
  break;

  case 4:
  start1=create(start);
  start2=create(start);
  start1=concat(start1, start2);
  printf("\nThe concatenation of the two linked lists is \n");
  display(start1);
  break;

  default:
  printf("Invalid choice");
  break;
 }
 getch();
}


//-------CREATE-------
struct node *create(struct node *start)
{
 int n,i;           //n-No. of nodes
 printf("\nEnter the number of nodes ");
 scanf("%d",&n);

 //For accepting the values
 for(i=0;i<n;i++)
 {
  new_node=(struct node*)malloc(sizeof(struct node));
  printf("Enter the data ");
  scanf("%d",&new_node->data);
  new_node->next=NULL;
  if(start==NULL)          //Implies list is empty
   start=new_node;
  else
  {
   ptr=start;
   while(ptr->next!=NULL)
    ptr=ptr->next;
   ptr->next=new_node;
  }
 }
 return start;
}


//-------DISPLAY-------
void *display(struct node *start)
{
 if(start==NULL)
  printf("The linked list is empty");
 else
 {
  ptr=start;
  while(ptr!=NULL)
  {
   printf("%d \t",ptr->data);
   ptr=ptr->next;
  }
 }
}


//-------COUNT-------
void *count(struct node *start)
{
 int length=0;
 ptr=start;
 while(ptr!=NULL)
 {
  length++;
  ptr=ptr->next;
 }
 printf("\nThe number of nodes is %d",length);
}


//-------REVERSE------
struct node *reverse(struct node *start)
{
 struct node *temp, *temp1, *rev;  //rev-Reversed list
 temp=start;
 rev=NULL;
 while(temp!=NULL)
 {
  temp1=rev;
  rev=temp;
  temp=temp->next;
  rev->next=temp1;
 }
 start=rev;
 return start;
}


//-------CONCATENATE-------
struct node *concat(struct node *start1, struct node *start2)
{
 if(start1==NULL)
 {
  start1=start2;
  return start1;
 }
 if(start2==NULL)
  return start1;
 ptr=start1;
 while(ptr->next!=NULL)
  ptr=ptr->next;
 ptr->next=start2;
 return start1;
}

/* OUTPUT - 1

Operations:
1. Create a linked list
2. Count the number of nodes
3. Reverse the linked list
4. Concatenate two linked lists

Enter your choice 1

Enter the number of nodes 3
Enter the data 4
Enter the data 5
Enter the data 6

The linked list is
4       5       6	*/

/* OUTPUT - 2

Operations:
1. Create a linked list
2. Count the number of nodes
3. Reverse the linked list
4. Concatenate two linked lists

Enter your choice 2

Enter the number of nodes 3
Enter the data 4
Enter the data 5
Enter the data 6

The number of nodes is 3	*/

/* OUTPUT - 3

Operations:
1. Create a linked list
2. Count the number of nodes
3. Reverse the linked list
4. Concatenate two linked lists

Enter your choice 3
                                                                                
Enter the number of nodes 3
Enter the data 4
Enter the data 5
Enter the data 6

The reverse of the linked list is
6       5       4			*/

/* OUTPUT - 4

Operations:
1. Create a linked list
2. Count the number of nodes
3. Reverse the linked list
4. Concatenate two linked lists

Enter your choice 4

Enter the number of nodes 3
Enter the data 4                                                                
Enter the data 5                                                                
Enter the data 6                                                                
                                                                                
Enter the number of nodes 2
Enter the data 7
Enter the data 8

The concatenation of the two linked lists is
4       5       6       7       8		*/










                                                                                
                                                                                
                                                                                
                                                                                
                                                                                
                                                                                
                                                                                























