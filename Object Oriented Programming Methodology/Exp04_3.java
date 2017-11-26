import java.io.*;

class Exp04_3
{

 public static void main(String[] args) throws IOException
 {
  BufferedReader b=new BufferedReader(new InputStreamReader(System.in));
  System.out.println("Enter a string");
  String s1=b.readLine();
  System.out.println("\nEnter the character to be searched");
  char c=(char)b.read();
  int count=FindFrequencyCount(s1,c);
  System.out.println("\nThe number of appearance of "+c+" is "+count);
  ReplaceCharacter(s1);
  ReplaceFirstCharacter(s1);
 }

 public static int FindFrequencyCount(String s1, char c)
 {
  int n,count=0;
  n=s1.length();
  for(int i=0;i<n;i++)
  {
   if (s1.charAt(i)==c)
    count++;
   }
  return(count);
 }

 public static void ReplaceCharacter(String s1)
 {
  System.out.println("\nThe new string is "+s1.replace(s1.charAt(0),s1.toUpperCase().charAt(0)));
 }

 public static void ReplaceFirstCharacter(String s1)
 {
  System.out.println("\nString before modification: "+s1);
  s1.trim();
  StringBuffer sb=new StringBuffer();
  for(String onestring:s1.split(" "))
  {
   sb.append(onestring.substring(0,1).toUpperCase() );
   sb.append(onestring.substring(1));
   sb.append(" ");
  }
  System.out.println("String after modification: "+sb);
 }

}


/* OUTPUT

Enter a string
all the best

Enter the character to be searched
t

The number of appearance of t is 2

The new string is All the best

String before modification: all the best
String after modification: All The Best   */