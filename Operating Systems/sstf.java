import java.util.*;
class sstf
{
	public static int fetch()
	{
		int ans=-1;
		int offset = Integer.MAX_VALUE;
		for(int i=0;i<list.size();i++)
		{
			int delta = Math.abs(list.elementAt(i).point - curr);
			if(delta<=offset)
			{
				offset = delta;
				ans = i;
			}
		}
		return ans;
	}
	
	public static void main(String args[])
	{
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter number of processes");
	int n = sc.nextInt();
	System.out.println("Enter disk access points of processes");
	
	for(int i=0;i<n;i++)
		{
			System.out.println("Enter access point for disk id "+i);
			process p = new process(i,sc.nextInt());
			list.addElement(p);
		}
		
	System.out.println("Enter disk head point");
	int head = sc.nextInt();
	
	
	 curr = head;
	
	
	for(int i=0;i<n;i++)
	{
		
		int temp = fetch();
		System.out.println("Process executed = "+list.elementAt(temp).id+" and access point is "+list.elementAt(temp).point);
		seek_time += Math.abs(curr-list.elementAt(temp).point);
		curr = list.elementAt(temp).point;
		System.out.println("Current disk point is "+curr);
		
		list.removeElementAt(temp);
		
	}
	
	
	System.out.println("Average seeking time is "+(seek_time/n));
	
	
			
	}
	public static int seek_time = 0;
	public static Vector<process> list = new Vector<process>();
	public static int curr;	
}

class process
{
	public int id;
	public int point;
	
	public process(int id,int point)
	{
		this.id=id;
		this.point = point;
	}
	
}
