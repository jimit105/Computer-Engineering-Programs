import java.util.*;

class ThreadDemo extends Thread
{
	String[] a;
	int n;
	String threadName;

	public ThreadDemo()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("\nEnter the name of the thread: ");
		threadName = sc.nextLine();
		System.out.println("Enter the size of the array: ");
		n = sc.nextInt();
		a = new String[n];		
		for(int i = 0; i < n; i++)
		{
			System.out.println("Enter the string ");
			a[i] = sc.next();
		}
	}
	
	public void run()
	{
		System.out.println("\n");
		System.out.println("Thread "+threadName+" Start");
		try
		{
			for(int i = 0; i < n; i++)
			{
				System.out.println(a[i]);
				Thread.sleep(100);
			}
		}
		catch(Exception e)
		{
		}
	}
	
}

class Exp07
{
	public static void main(String[] args)
	{
		
		ThreadDemo x = new ThreadDemo();
		ThreadDemo y = new ThreadDemo();
		x.start();
		y.start();
		
		try
		{
			for(int i = 0; i < 10; i++)
			{
				System.out.println("main thread active");
				Thread.sleep(200);
			}
		}
		catch(Exception e)
		{
		}
	}
}
	
			
/* OUTPUT			

Enter the name of the thread:
Days
Enter the size of the array:
7
Enter the string
Sunday
Enter the string
Monday
Enter the string
Tuesday
Enter the string
Wednesday
Enter the string
Thursday
Enter the string
Friday
Enter the string
Saturday

Enter the name of the thread:
Months
Enter the size of the array:
12
Enter the string
January
Enter the string
February
Enter the string
March
Enter the string
April
Enter the string
May
Enter the string
June
Enter the string
July
Enter the string
August
Enter the string
September
Enter the string
October
Enter the string
November
Enter the string
December




Thread Months Start
January
main thread active
Thread Days Start
Sunday
February
Monday
main thread active
March
Tuesday
April
Wednesday
main thread active
Thursday
May
Friday
June
main thread active
Saturday
July
August
main thread active
September
October
main thread active
November
December
main thread active
main thread active
main thread active
main thread active	 */