import java.util.*;

class Exp01
{

 static int gcd(int x,int y)
 {
  if(x%y==0)
   return y;
  else return gcd(y,x%y);
  }

 public static void main(String args[])
 {
  int a,b;
  Scanner sc=new Scanner(System.in);
  System.out.println("Enter two numbers ");
  Exp01a e1=new Exp01a();
  a=sc.nextInt();
  b=sc.nextInt();
  int g=e1.gcd(a,b);
  int l=(a*b)/g;
  System.out.println("The GCD of two numbers is "+g);
  System.out.println("The LCM of two numbers is "+l);
  }

} 


/* OUTPUT

Enter two numbers
3 7
The GCD of two numbers is 1
The LCM of two numbers is 21  */
