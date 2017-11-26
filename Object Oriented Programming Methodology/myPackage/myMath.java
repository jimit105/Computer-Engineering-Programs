package myPackage;

public class myMath
{
	public static double power(double x, double y)
	{
		if(y == 0)
			return 1;
		else
			return(x * power(x, y-1));
	}
	
	public static double fact(double n)
	{
		if(n == 0)
			return 1;
		else
			return(n * fact(n-1));
	}
}