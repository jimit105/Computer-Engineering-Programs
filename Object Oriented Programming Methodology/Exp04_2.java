class Exp04_2
{
 public static void main(String[] args)
  {
   int k,count=0;
   k=args.length;
   String s=new String();
   for(int j=0;j<k;j++)
   { 
   s=args[j];
   int n=s.length();
   char c[]=new char[n];
   c=s.toCharArray();
   for(int i=0;i<n;i++)
   {
    if (c[i]=='a'||c[i]=='A'||c[i]=='e'||c[i]=='E'||c[i]=='i'||c[i]=='I'||c[i]=='o'||c[i]=='O'||c[i]=='u'||c[i]=='U')
    {
     count++;
    }
   }
   }
   System.out.println("The number of vowels is "+count);
 }
}


/* OUTPUT

C:\OOPM>java Exp04_2 jimit dholakia
The number of vowels is 6                      */