import java.util.*;
class cscandisk
{
	public static int DISK_SIZE = 200;
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter no. of processes");
		int n = sc.nextInt();
		
		System.out.println("Enter location of each process");
		int a[] = new int[n];
		for(int i=0;i<n;i++)
			a[i] = sc.nextInt();
		
		Arrays.sort(a);
		
		System.out.println("Enter head pointer");
		 int head = sc.nextInt();
		 int seek = 0;
		 int pointer = head;
		 int m=0;
		 while(a[m]<head)
		 {m++;}
		 int breaker = m;
		 System.out.println("Disk Pointer moved to "+pointer);
		 while(true)
		 {
		 	seek+=Math.abs(a[m]-pointer);
		 	m++;
		 	if(m==n)
		 	{
		 		seek+=DISK_SIZE-pointer;
		 		pointer = 0;
		 		break;
		 	}
		 			 		
		 	pointer = a[m];
		 	System.out.println("Pointer moved to "+pointer);

		 		
		 } //Ascending done;
		 
		 seek += DISK_SIZE;
		 pointer = 0;
		 m=0;
		 System.out.println("Pointer currently at "+pointer);	
		 if(breaker!=0)
		 {
		 	
		 while(true)
		 {
		 	seek +=Math.abs(a[m] - pointer);
		 	m++;
		 	if(m==breaker)
		 	{
		 		break;
		 	}
		 	pointer = a[m];
		 	System.out.println("Pointer currently at "+pointer);
		 }
		 System.out.println("Pointer moved to "+pointer);
		 }
		 System.out.println("Average Seek time is "+ seek/n);
		 
		 
		 
		 
			
    }
}
