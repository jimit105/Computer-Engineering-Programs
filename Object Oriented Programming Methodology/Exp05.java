import java.io.*;
import java.util.*;

class MarksOutOfRangeException extends Exception
{
	public String toString()
	{
		return "java.lang.MarksOutOfRangeException";
	}
}

class Exp05
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Marks ");
		int m = sc.nextInt();
		
		try
		{
			if( (m < 0) || (m > 100) ) throw new MarksOutOfRangeException();
			else
				System.out.println("Marks Entered Successfully");
		}
		
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}	
}			


/* OUTPUT - 1
 *
 *Enter Marks
75
Marks Entered Successfully  */

/* OUTPUT - 2
 *
 *Enter Marks
120
java.lang.MarksOutOfRangeException  */