import java.util.*;

class Account
{
	String name;
	int ac_no;
	char ac_type;
	float balance = 1000;
	
	public void input()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Your Name:");
		name = sc.nextLine();
		System.out.println("Enter Account Number:");
		ac_no = sc.nextInt();
		System.out.println("Enter Account Type (s/c):");
		ac_type=sc.next().charAt(0);
	}
	
	float getBalance()
	{
		return (this.balance);
	}
}

class Current extends Account
{
	float min_bal, penalty, deposit, withdraw;
	float balance = getBalance();
	
	Current()
	{
		min_bal = 1000;
		penalty = 500;
	}
	
	public void deposit()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("\nEnter amount to deposit");
		deposit = sc.nextFloat();
		balance = balance + deposit;
		System.out.println("\nThe new balance is Rs."+balance+"\n");
	}
	
	public void minimumBalance()
	{
		if(balance < min_bal)
		{
			System.out.println("\nThe balance in your account is less than the minimum balance required");
			System.out.println("You will be charged a penalty of Rs. "+penalty);
			balance=balance-penalty;
			System.out.println("The new balance is Rs."+balance);
		}
		else
			System.out.println("\nSufficient Balance Present\n");		
	}
	
	public void withdraw()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("\nEnter amount to be withdrawn");
		withdraw = sc.nextFloat();
		if(balance > withdraw)
			balance = balance - withdraw;
		else
			System.out.println("Insufficient Balance");
		System.out.println("Your balance is Rs."+balance+"\n");
		
	}
	
	public void chequeBook()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("\nDo you want a Cheque Book? (Yes/No)");
		if(sc.nextLine().equalsIgnoreCase("yes"))
		{
			System.out.println("Enter the number of cheques (25/50)");
			int cheque_no = sc.nextInt();
			if( (cheque_no == 25) || (cheque_no == 50) )
				System.out.println("A cheque book containing "+cheque_no+" cheques will be soon issued to you\n");
			else
				System.out.println("Invalid Number of Cheques\n");
		}
	}
}

class Savings extends Account
{
	float deposit, withdraw;
	int r, n;
	float balance = getBalance();
	
	Savings()
	{
		r=10;
		n=1;
	}
	
	
	public void deposit()
	{
		
		Scanner sc = new Scanner(System.in);
		System.out.println("\nEnter amount to deposit");
		deposit = sc.nextFloat();
		balance = balance + deposit;
		System.out.println("The new balance is Rs."+balance+"\n");
	}
	
	public void compoundInterest()
	{
		double r = 10, n = 1;
		double compound_interest, amount;
		compound_interest = Math.pow( (1 + (r / 100)), n);
		amount = balance * compound_interest;
		System.out.println("\nAmount available with interest is Rs."+amount+"\n");		
	}
	
	public void withdraw()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("\nEnter amount to be withdrawn");
		withdraw = sc.nextFloat();
		if(balance > withdraw)
			balance = balance - withdraw;
		else
			System.out.println("Insufficient Balance");
		System.out.println("Your balance is Rs."+balance+"\n");
	}	
}

class Exp03
{
	public static void main(String[] args)
	{
		Account a = new Account();
		a.input();
		
		if(a.ac_type == 's')
		{
			Savings s = new Savings();
			int i;
			do
			{
				System.out.println("\n1.Deposit Amount\n2.Find Interest\n3.Withdraw Amount\n4.Exit");
				System.out.println("\nEnter Your Choice");
				Scanner sc = new Scanner(System.in);
				i = sc.nextInt();
				switch(i)
				{
					case 1:
						s.deposit();
						break;
					case 2:
						s.compoundInterest();
						break;
					case 3:
						s.withdraw();
						break;						
				}				
			}while(i != 4);
		}
		else if(a.ac_type == 'c')
		{
			Current c = new Current();
			int j;
			do
			{
				System.out.println("\n1.Deposit Amount\n2.Withdraw Amount\n3.Check Minimum Balance\n4.Issue Cheque Book\n5.Exit");
				System.out.println("Enter Your Choice");
				Scanner sc = new Scanner(System.in);
				j = sc.nextInt();
				switch(j)
				{
					case 1:
						c.deposit();
						break;
					case 2:
						c.withdraw();
						break;
					case 3:
						c.minimumBalance();
						break;
					case 4:
						c.chequeBook();
						break;
				}			
				
			}while(j != 5);				
		}
		else
			System.out.println("Invalid Choice");
	}
}

/* OUTPUT - 1
 *
 *Enter Your Name:
Jimit
Enter Account Number:
100596
Enter Account Type (s/c):
s

1.Deposit Amount
2.Find Interest
3.Withdraw Amount
4.Exit

Enter Your Choice
1

Enter amount to deposit
100
The new balance is Rs.1100.0


1.Deposit Amount
2.Find Interest
3.Withdraw Amount
4.Exit

Enter Your Choice
2

Amount available with interest is Rs.1210.0


1.Deposit Amount
2.Find Interest
3.Withdraw Amount
4.Exit

Enter Your Choice
3

Enter amount to be withdrawn
150
Your balance is Rs.950.0


1.Deposit Amount
2.Find Interest
3.Withdraw Amount
4.Exit

Enter Your Choice
4                                      */

/* OUTPUT - 2
 *
 *Enter Your Name:
Jimit
Enter Account Number:
100596
Enter Account Type (s/c):
c

1.Deposit Amount
2.Withdraw Amount
3.Check Minimum Balance
4.Issue Cheque Book
5.Exit
Enter Your Choice
1

Enter amount to deposit
200

The new balance is Rs.1200.0


1.Deposit Amount
2.Withdraw Amount
3.Check Minimum Balance
4.Issue Cheque Book
5.Exit
Enter Your Choice
2

Enter amount to be withdrawn
100
Your balance is Rs.1100.0


1.Deposit Amount
2.Withdraw Amount
3.Check Minimum Balance
4.Issue Cheque Book
5.Exit
Enter Your Choice
3

Sufficient Balance Present


1.Deposit Amount
2.Withdraw Amount
3.Check Minimum Balance
4.Issue Cheque Book
5.Exit
Enter Your Choice
4

Do you want a Cheque Book? (Yes/No)
yes
Enter the number of cheques (25/50)
25
A cheque book containing 25 cheques will be soon issued to you


1.Deposit Amount
2.Withdraw Amount
3.Check Minimum Balance
4.Issue Cheque Book
5.Exit
Enter Your Choice
5								*/