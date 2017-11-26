import myPackage.*;
import java.util.*;

class Exp09
{
	Scanner sc = new Scanner(System.in);
	static double calculateSeries()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of terms ");
		int n = sc.nextInt();
		double ans = 1;
		int sign = -1;
		System.out.println("Enter the value of x ");
		double x = sc.nextInt();
		x = 3.142 * x / 180;
		for(int i = 2; i < 2 * n; i = i + 2)
		{
			ans = ans + sign * ( myMath.power(x, i) / myMath.fact(i) );
			sign = -sign;
		}
		return ans;
	}
	
	public static void main(String[] args)
	{
		double ans = calculateSeries();
		System.out.println("The answer is " + ans);
	}
}

/* OUTPUT
 *
 *Enter the number of terms 
5
Enter the value of x 
45
The answer is 0.7070347926963395	*/

