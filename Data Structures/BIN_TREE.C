                    /* BINARY SEARCH TREE */

#include<stdio.h>
#include<conio.h>
#include<malloc.h>

struct node
{
	int data;
	struct node *left;
	struct node *right;
};
struct node *tree;

void create_tree(struct node *);
struct node *insertElement(struct node *, int);
void preorderTraversal(struct node *);
void inorderTraversal(struct node *);
void postorderTraversal(struct node *);
struct node *deleteNode(struct node *, int);
struct node *searchElement(struct node *, int val);
struct node *minValueNode(struct node *);

int main()
{
	int choice, val;
	struct node *ptr;
	create_tree(tree);
    clrscr();
	do
	{
        printf("\n");
		printf("\n1.Insert Element");
        printf("\n2.Search Element");
		printf("\n3.Delete Element");
		printf("\n4.Preorder Traversal");
		printf("\n5.Inorder Traversal");
		printf("\n6.Postorder Traversal");
		printf("\n7.Exit");
		printf("\n\nEnter Your Choice: ");
		scanf("%d", &choice);
		switch(choice)
		{
			case 1:
				printf("\nEnter the value of the new node: ");
				scanf("%d", &val);
				tree = insertElement(tree, val);
				break;
            case 2:
				printf("\nEnter the value to be searched: ");
				scanf("%d", &val);
				tree = searchElement(tree, val);
				break;
			case 3:
				printf("\nEnter the element to be deleted: ");
				scanf("%d", &val);
				deleteNode(tree, val);
				break;
			case 4:
				printf("\nThe elements in the tree are: \n");
				preorderTraversal(tree);
				break;
			case 5:
				printf("\nThe elements in the tree are: \n");
				inorderTraversal(tree);
				break;
			case 6:
				printf("\nThe elements in the tree are: \n");
				postorderTraversal(tree);
				break;
		}
	}while(choice != 7);
	getch();
	return 0;
}

//-------CREATE TREE-------
void create_tree(struct node *tree)
{
	tree = NULL;
}

//-------INSERT ELEMENT-------
struct node *insertElement(struct node *tree, int val)
{
	struct node *ptr, *nodeptr, *parentptr;
	ptr = (struct node *)malloc(sizeof(struct node));
	ptr->data = val;
	ptr->left = NULL;
	ptr->right = NULL;
	if(tree == NULL)
	{
		tree = ptr;
		tree->left = NULL;
		tree->right = NULL;
	}
	else
	{
		parentptr = NULL;
		nodeptr = tree;
		while(nodeptr != NULL)
		{
			parentptr = nodeptr;
			if(val < nodeptr->data)
				nodeptr = nodeptr->left;
			else
				nodeptr = nodeptr->right;
		}
		if(val < parentptr->data)
			parentptr->left = ptr;
		else
			parentptr->right = ptr;
	}
	return tree;
}

//-------SEARCH ELEMENT-------
struct node *searchElement(struct node *tree, int val)
{
    struct node *ptr;
    ptr = tree;
    if(ptr == NULL)
        printf("Tree does not exist");
    else
    {
        while(ptr != NULL)
        {
            if(val == ptr->data)
            {
                printf("%d found", val);
                break;
            }
            else if(val < ptr->data)
                ptr = ptr->left;
            else
                ptr = ptr->right;
        }
        if(ptr == NULL)
            printf("%d not found", val);
    }
    return tree;
}

//-------PREORDER TRAVERSAL-------
void preorderTraversal(struct node *tree)
{
	if(tree != NULL)
	{
		printf("%d\t", tree->data);
		preorderTraversal(tree->left);
		preorderTraversal(tree->right);
	}
}

//-------INORDER TRAVERSAL-------
void inorderTraversal(struct node *tree)
{
	if(tree != NULL)
	{
		inorderTraversal(tree->left);
		printf("%d\t", tree->data);
		inorderTraversal(tree->right);
	}
}

//-------POSTORDER TRAVERSAL-------
void postorderTraversal(struct node *tree)
{
	if(tree != NULL)
	{
		postorderTraversal(tree->left);
		postorderTraversal(tree->right);
		printf("%d\t", tree->data);
	}
}

//-------FIND MIN. VALUE NODE-------
struct node *minValueNode(struct node* node)
{
    struct node* current = node;

    /* loop down to find the leftmost leaf */
    while (current->left != NULL)
        current = current->left;

    return current;
}

//-------DELETE ELEMENT-------
struct node *deleteNode(struct node *root, int key)
{

    // base case
    if (root == NULL) return root;

    // If the key to be deleted is smaller than the root's key,
    // then it lies in left subtree
    if (key < root->data)
        root->left = deleteNode(root->left, key);

    // If the key to be deleted is greater than the root's key,
    // then it lies in right subtree
    else if (key > root->data)
        root->right = deleteNode(root->right, key);

    // if key is same as root's key, then This is the node
    // to be deleted
    else
    {
        // node with only one child or no child
        if (root->left == NULL)
        {
            struct node *temp = root->right;
            free(root);
            return temp;
        }
        else if (root->right == NULL)
        {
            struct node *temp = root->left;
            free(root);
            return temp;
        }

        // node with two children: Get the inorder successor (smallest
        // in the right subtree)
        struct node *temp = minValueNode(root->right);

        // Copy the inorder successor's content to this node
        root->data = temp->data;

        // Delete the inorder successor
        root->right = deleteNode(root->right, temp->data);
    }
    return root;
}


/* OUTPUT

1.Insert Element
2.Search Element
3.Delete Element
4.Preorder Traversal
5.Inorder Traversal
6.Postorder Traversal
7.Exit

Enter Your Choice: 1

Enter the value of the new node: 5


1.Insert Element
2.Search Element
3.Delete Element
4.Preorder Traversal
5.Inorder Traversal
6.Postorder Traversal
7.Exit

Enter Your Choice: 1

Enter the value of the new node: 2


1.Insert Element
2.Search Element
3.Delete Element
4.Preorder Traversal
5.Inorder Traversal
6.Postorder Traversal
7.Exit

Enter Your Choice: 1

Enter the value of the new node: 6


1.Insert Element
2.Search Element
3.Delete Element
4.Preorder Traversal
5.Inorder Traversal
6.Postorder Traversal
7.Exit

Enter Your Choice: 1

Enter the value of the new node: 3


1.Insert Element
2.Search Element
3.Delete Element
4.Preorder Traversal
5.Inorder Traversal
6.Postorder Traversal
7.Exit

Enter Your Choice: 2

Enter the value to be searched: 6
6 found

1.Insert Element
2.Search Element
3.Delete Element
4.Preorder Traversal
5.Inorder Traversal
6.Postorder Traversal
7.Exit

Enter Your Choice: 4

The elements in the tree are:
5       2       3       6

1.Insert Element
2.Search Element
3.Delete Element
4.Preorder Traversal
5.Inorder Traversal
6.Postorder Traversal
7.Exit

Enter Your Choice: 3

Enter the element to be deleted: 5


1.Insert Element
2.Search Element
3.Delete Element
4.Preorder Traversal
5.Inorder Traversal
6.Postorder Traversal
7.Exit

Enter Your Choice: 5

The elements in the tree are:
2       3       6

1.Insert Element
2.Search Element
3.Delete Element
4.Preorder Traversal
5.Inorder Traversal
6.Postorder Traversal
7.Exit

Enter Your Choice: 6

The elements in the tree are:
3       2       6

1.Insert Element
2.Search Element
3.Delete Element
4.Preorder Traversal
5.Inorder Traversal
6.Postorder Traversal
7.Exit

Enter Your Choice: 7        */
