		/* MinMax Algorithm */

import java.util.*;
class Node 
{
    public int a;
    public int b;
    public  int point;
    private final List<Node> children = new ArrayList<>();
    private final Node parent;

    public Node(Node parent) 
    {
        this.parent = parent;
    }

    public void setNum(int a, int b , int point)
    {
        this.a = a;
        this.b = b;
        this.point = point;
    }

    public List<Node> getChildren() 
    {
        return children;
    }

    public Node getParent() 
    {
        return parent;
    }
    
    public boolean ifEmpty()
    {
        return children.isEmpty() ;
    }
}

public class MinMax {
 
    public static int k = 0;
    public static void main(String[] args) {
        
        Node initial = new Node(null);
        initial.setNum(0,8,1);
        
        Node a1 = addChild(initial,1,7,1);
        Node a2 = addChild(initial,2,6,-1);
        Node a3 = addChild(initial,3,5,-1);
        
        Node b1 = addChild(a1,1,6,1);
        Node b2 = addChild(a1,2,5,1);
        Node b3 = addChild(a1,3,4,1);
        Node b4 = addChild(a2,1,5,1);
        Node b5 = addChild(a2,2,4,-1);
        Node b6 = addChild(a3,1,2,-1);
        Node b7 = addChild(a3,1,4,-1);
        Node b8 = addChild(a3,2,3,1);
        
        Node c1 = addChild(b1,1,5,-1);
        Node c2 = addChild(b1,2,4,1);
        Node c3 = addChild(b2,1,4,1);
        Node c4 = addChild(b2,2,3,-1);
        Node c5 = addChild(b3,1,2,1);
        Node c6 = addChild(b3,1,3,-1);
        Node c7 = addChild(b4,2,3,-1);
        Node c8 = addChild(b4,1,4,1);
        Node c9 = addChild(b5,1,3,-1);
        Node c10 = addChild(b7,1,3,-1);
        Node c11 = addChild(b8,1,2,1);
        
        Node d1 = addChild(c1,1,4,-1);
        Node d2 = addChild(c1,2,3,1);
        Node d3 = addChild(c2,1,3,1);
        Node d4 = addChild(c4,1,2,-1);
        Node d5 = addChild(c4,1,3,1);
        Node d6 = addChild(c6,1,2,-1);
        Node d7 = addChild(c7,1,2,-1);
        Node d8 = addChild(c8,1,3,1);
        Node d9 = addChild(c9,1,2,-1);
        Node d10 = addChild(c10,1,2,-1);
        
        Node e1 = addChild(d1,1,3,-1);
        Node e2 = addChild(d2,1,2,1);
        Node e3 = addChild(d3,1,2,1);
        Node e4 = addChild(d5,1,2,1);
        Node e5 = addChild(d8,1,2,1);
        
        Node f1 = addChild(e1,1,2,-1);
        
        play(initial,k);
    }
    
    private static Node addChild(Node parent, int a , int b ,int p)
    { 
        Node node = new Node(parent);
        node.setNum(a,b,p);
        parent.getChildren().add(node);
        return node;
    }
    
    public static void play(Node node , int k)
    {
        
        Node temp = null;
        Scanner sc = new Scanner(System.in);
        if(node.ifEmpty())   {
            if( k%2 != 0)  {
                System.out.println("Computer Won");
            }
            else           {
                System.out.println("We Won");
            }
             return ;
        }
           
        else if( k%2 == 0) {
            int i = 1;
            for ( Node each : node.getChildren() )
            {
    		System.out.println("Option "+i+"\t:"+each.a+" , "+each.b+" Point "+each.point);
                i++ ;
            }
            
            for ( Node each : node.getChildren() )
            {
    		if ( each.point == 1)	{
    		     temp = each;
                     System.out.println("Selected : \t"+each.a+" , "+each.b+" Point"+each.point+"\n");
                    break ; 
    		}
            }
        }        
        else     { 
            int i = 1;
            for ( Node each : node.getChildren() )
            {
    		System.out.println("Option "+i+"\t:"+each.a+" , "+each.b+" Point "+each.point);
                i++ ;
            }
            System.out.print("Enter the Values: ");
            int a1 = sc.nextInt();
            int b1 = sc.nextInt();
            int p = sc.nextInt();
            
            for ( Node each : node.getChildren() )
            {
    		if ( each.a == a1 && each.b == b1 && each.point == p)     {
    		     temp = each;   break ; 
    		}
            }
          System.out.println();
          }
         k++;
        play(temp , k); 
    }    
}

/* OUTPUT
 *
 *Option 1    :1 , 7 Point 1
Option 2    :2 , 6 Point -1
Option 3    :3 , 5 Point -1
Selected :  1 , 7 Point1

Option 1    :1 , 6 Point 1
Option 2    :2 , 5 Point 1
Option 3    :3 , 4 Point 1
Enter the Values: 3 4 1

Option 1    :1 , 2 Point 1
Option 2    :1 , 3 Point -1
Selected :  1 , 2 Point1

Computer Won
*/
