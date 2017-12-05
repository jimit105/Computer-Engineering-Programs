import java.util.*;
class fcfs
{
	public static void main(String args[])
	{
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter no. of processes");
	int n = sc.nextInt();
	System.out.println("Enter n disk access points");
	int a[] = new int[n];
	for(int i=0;i<n;i++)
		a[i] = sc.nextInt();
		
	System.out.println("Enter head");
	int head = sc.nextInt();
	int time = 0;
	int curr = head;
	for(int i=0;i<n;i++)
	{
		int retrieve = a[i];
		System.out.println("Step "+(i+1)+" Current pointer is "+retrieve);
		
		time = time + Math.abs(retrieve-curr);
		curr = retrieve;
	}
	System.out.println("Average seeking time is "+(time/n));
	
	
			
	}
	
		
}
