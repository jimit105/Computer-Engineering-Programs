class Exp04_1
{
 public static void main(String[] args)
  {
   String s=args[0];
   int n=s.length();
   int count=0;
   char c[]=new char[n];
   c=s.toCharArray();
   for(int i=0;i<n;i++)
   {
    if (c[i]=='a'||c[i]=='A'||c[i]=='e'||c[i]=='E'||c[i]=='i'||c[i]=='I'||c[i]=='o'||c[i]=='O'||c[i]=='u'||c[i]=='U')
    {
     count++;
    }
   }
   System.out.println("The number of vowels is "+count);
 }
}