import java.util.*;
import java.util.concurrent.Semaphore;
public class Dining_Problem
{
	public static Semaphore Fork[];
	public static int n; 
	public static void main( String Args[] )
	{
		Scanner Sc = new Scanner( System.in );
		System.out.print("Enter the number of Philosophers : ");
		n = Sc.nextInt();
		Fork = new Semaphore[n];
		for( int i = 0 ; i < n ; i++ )
			Fork[i] = new Semaphore(1);
		for( int i = 0 ; i < n ; i++ )
			new Philosopher("Philosopher " + (i+1) , i);
	}
}
class Philosopher implements Runnable
{
	int i , l , r;
	String Name;
	public Philosopher( String Name , int i )
	{
		this.i = i;
		this.Name = Name;
		l = i ;
		r=((++i)%Dining_Problem.n);
		new Thread(this , Name).start();
	}
	public void run()
	{
		try
		{
			Dining_Problem.Fork[l].acquire();
			Dining_Problem.Fork[r].acquire();
		}
		catch( InterruptedException E )
		{
			System.out.println("Interrupted Exception Caught !!!!! ");
		}
		finally 
		{
			try
			{
				System.out.println(Name + " has Started Eating");
				Thread.currentThread().sleep(2000);
				System.out.println(Name + " has Finished Eating");
			}
			catch( InterruptedException E )
			{
				System.out.println("Interrupted Exception is Caught !!!!! ");
			}		
			finally
			{
				Dining_Problem.Fork[r].release();
				Dining_Problem.Fork[l].release();
			}	
		}			
	}	
}