import java.util.*;

class Subnet
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter IP Address: ");
		String ip = sc.nextLine();		
		int[] ipaddr=new int[4];	
		System.out.print("Enter Mask: ");
		int mask = sc.nextInt();
		
		
		int i=0;
		for(String s : ip.split("\\."))
		{					
			ipaddr[i]=Integer.parseInt(s);
			i++;
		}
		
		
		
		System.out.print("\nThe IP Address is ");
		for(i=0;i<4;i++)
		{
			System.out.print(ipaddr[i]);
			if(i<3)
				System.out.print(".");
		}
		System.out.println("/"+mask);
		
		System.out.print("Enter the number of subnets: ");
		int subnets=sc.nextInt();
		
		int a=(int)Math.pow(2, 32-mask);
		System.out.println("The number of addresses available is "+ a);
		
		int x=(int)a/subnets;
		System.out.println("The number of addresses available in each subnet is "+x);
		
		i=1;
		while(x!=(int)Math.pow(2,i))
			i++;
		
		System.out.println("The number of bits required is "+ i);
		
		int d=32-i; //d- mask of each subnet
		
		
		for(int j=1;j<subnets;j++)
		{
			System.out.println("Subnet "+j);
			System.out.println("SA: "+ipaddr[0]+"."+ipaddr[1]+"."+ipaddr[2]+"."+ipaddr[3]);
			ipaddr[4]=ipaddr[4]+x-1;
			System.out.println("EA: "+ipaddr[0]+"."+ipaddr[1]+"."+ipaddr[2]+"."+ipaddr[3]);
			
		}
				
			
		
	}
}