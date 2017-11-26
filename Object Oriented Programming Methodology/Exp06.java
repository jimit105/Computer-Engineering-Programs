import java.util.*;

class Student
{
	int rollno;
	String name;
	double g_t;
	Student (int r, String name1, double total)
	{
		rollno=r;
		name=name1;
		g_t=total;
	}
	public String toString()
	{
		return("Roll No.: "+rollno+"\t\tName: "+name+"\t\tTotal Marks: "+g_t);
	}
}

class Vector1
{
	Vector<Student> v=new Vector<Student>();
	void Create()
	{
		System.out.println("\nEnter the total number of students ");
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		for (int i=0;i<n;i++)
		{
			System.out.println("\nEnter the roll number of student "+(i+1));
			int r=sc.nextInt();
			System.out.println("\nEnter the name of student "+(i+1));
			String name=sc.next();
			System.out.println("\nEnter the total marks of student "+(i+1));
			double total=sc.nextDouble();
			Student s=new Student (r, name, total);
			if(v.size()==0)
				v.add(s);
			else
			{
				int j;
				for(j=0;j<v.size();j++)
				{
					if(((Student)v.elementAt(j)).g_t < total)
						break;
				}
				v.insertElementAt(s,j);
			}
		}
	}
	
	void Display()
	{
		for(int i=0;i<v.size();i++)
		{
			System.out.println("\nDetails of student "+(i+1)+":");
			String s1=v.elementAt(i).toString();
			System.out.println("\n"+s1);
		}
	}
	
	
	void Insert()
	{
		int j;
		Scanner sc=new Scanner(System.in);
		System.out.println("\nEnter the roll number ");
		int r=sc.nextInt();
		System.out.println("\nEnter the name ");
		String name=sc.next();
		System.out.println("\nEnter the total marks ");
		double total=sc.nextDouble();
		Student s=new Student (r, name, total);
		for(j=0;j<v.size();j++)
		{
			if(((Student)v.elementAt(j)).g_t < total)
				break;
		}
		v.insertElementAt(s,j);
	}
	
	void deleteByName()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("\nEnter the name of the student ");
		String name1=sc.next();
		for(int i=0;i<v.size();i++)
		{
			if(((Student)v.elementAt(i)).name.equals(name1))
			{
				v.removeElementAt(i);
				break;
			}
		}
	}
	
	void deleteByRollNo()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("\nEnter the roll number of the student ");
		int rn=sc.nextInt();
		for(int i=0;i<v.size();i++)
		{
			if(((Student)v.elementAt(i)).rollno==rn)
			{
				v.removeElementAt(i);
				break;
			}
		}
	}
}

class Exp06
{
	public static void main(String args[])
	{
		int ch;
		Vector1 obj=new Vector1();
	 	Scanner sc=new Scanner(System.in);
	 	System.out.println("\nEnter the details ");
		obj.Create();
		obj.Display();
		do
		{
			System.out.println("\nEnter your choice\n1.Insert\n2.Delete By Name\n3.Delete By Roll Number\n4.Exit");
			ch=sc.nextInt();
			if(ch==1)
			{
				obj.Insert();
				obj.Display();
			}
			else if(ch==2)
			{
				obj.deleteByName();
				obj.Display();
			}
			else if(ch==3)
			{
				obj.deleteByRollNo();
				obj.Display();
			}
		}while(ch!=4);
	
	}
}
	

/* OUTPUT
 *
 *Enter the details 

Enter the total number of students 
3

Enter the roll number of student 1
1

Enter the name of student 1
abc

Enter the total marks of student 1
40

Enter the roll number of student 2
2

Enter the name of student 2
pqr

Enter the total marks of student 2
35

Enter the roll number of student 3
3

Enter the name of student 3
xyz

Enter the total marks of student 3
45

Details of student 1:

Roll No.: 3		Name: xyz		Total Marks: 45.0

Details of student 2:

Roll No.: 1		Name: abc		Total Marks: 40.0

Details of student 3:

Roll No.: 2		Name: pqr		Total Marks: 35.0

Enter your choice
1.Insert
2.Delete By Name
3.Delete By Roll Number
4.Exit
1

Enter the roll number 
4

Enter the name 
lmn

Enter the total marks 
55

Details of student 1:

Roll No.: 4		Name: lmn		Total Marks: 55.0

Details of student 2:

Roll No.: 3		Name: xyz		Total Marks: 45.0

Details of student 3:

Roll No.: 1		Name: abc		Total Marks: 40.0

Details of student 4:

Roll No.: 2		Name: pqr		Total Marks: 35.0

Enter your choice
1.Insert
2.Delete By Name
3.Delete By Roll Number
4.Exit
2

Enter the name of the student 
abc

Details of student 1:

Roll No.: 4		Name: lmn		Total Marks: 55.0

Details of student 2:

Roll No.: 3		Name: xyz		Total Marks: 45.0

Details of student 3:

Roll No.: 2		Name: pqr		Total Marks: 35.0

Enter your choice
1.Insert
2.Delete By Name
3.Delete By Roll Number
4.Exit
3

Enter the roll number of the student 
3

Details of student 1:

Roll No.: 4		Name: lmn		Total Marks: 55.0

Details of student 2:

Roll No.: 2		Name: pqr		Total Marks: 35.0

Enter your choice
1.Insert
2.Delete By Name
3.Delete By Roll Number
4.Exit
4

Process completed.   */

