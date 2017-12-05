import java.io.*;
import java.util.*;
import java.util.concurrent.Semaphore;
import java.util.Arrays;
class ReaderInitiatorThread extends Thread
{
  ReaderWriter obj;
	ReaderInitiatorThread(ReaderWriter obj)
	{
	  this.obj=obj;
	}
	
	public void run()
	{
	  	for(int i= 1;i<=obj.nr;i++)
		{
			Reader t = new Reader(i,obj);
			t.start();
			try{this.sleep(1);}catch(Exception e){System.out.println(e);}
		}
	
	}

}
class WriterInitiatorThread extends Thread
{
  ReaderWriter obj;
	WriterInitiatorThread(ReaderWriter obj)
	{
	  this.obj = obj;
	}
	public void run()
	{
	  	for(int i= 1;i<=obj.wr;i++)
		{
			Writer t = new Writer(i,obj);
			t.start();
			
		}
	}

}
class Reader extends Thread
{
	ReaderWriter obj;
	int x;
	Thread t;
	Reader(int x, ReaderWriter obj)
	{
		this.x=x;
		this.obj=obj;
		t = this.currentThread();
		
	}

	public void run()
	{
	  try{
	   obj.reader.acquire();
	  
	  obj.reader.release();
	  {System.out.println("Reader "+x+" reading from shared document");
	  obj.threads[x]=t;
	  };
	  }catch(Exception e){System.out.println(e);}
	  
	}
}
class Writer extends Thread
{
    ReaderWriter obj;
    int x;
	Thread t;
	Writer(int x, ReaderWriter obj)
	{
		this.x=x;
		this.obj = obj;
		t = this.currentThread();
	}
	public void run()
	{
    try{
      //System.out.println(obj.reader.availablePermits());
      
    {obj.reader.acquire(obj.reader.availablePermits());
    obj.writer.acquire();
    System.out.println("Suspending currently Reading Threads:");
    for(int i=1;i<=obj.nr;i++)
    {
      if(obj.threads[i] == null )
      continue;
      obj.threads[i].suspend();
      System.out.print(i+" ");
    }
    System.out.println();
    System.out.println("Writer "+x+" is currently Writing");
    System.out.println("Writer has finished writing");
    System.out.println("Resuming Suspended Reader Threads:");
    for(int i=1;i<=obj.nr;i++)
    {
      if(obj.threads[i] == null )
      continue;
      obj.threads[i].resume();
      System.out.print(i+" ");
    }
    System.out.println();
    obj.reader.release(obj.nr+1);
    obj.writer.release();};
    }catch(Exception e){System.out.println(e);}
	}
}
  public class ReaderWriter{
	static Semaphore writer = new Semaphore(1);
	static Semaphore reader = new Semaphore(0);
	static int nr;
	static int wr,rc=0;
	static Thread [] threads = new Thread[1000001];
	static Semaphore res = new Semaphore(1);

	public static void main(String args[])
	{
		System.out.println("ReadersWriters Problem");
		System.out.println("Enter the no. of readers");
		Scanner sc = new Scanner(System.in);
		nr=sc.nextInt();
		Arrays.fill(threads,null);
		reader.release(nr+1);
		System.out.println("Enter the no. writers");
		wr = sc.nextInt();
		System.out.println("STARTING READER AND WRITER THREADS");
		ReaderWriter obj = new ReaderWriter();
        
        WriterInitiatorThread wit = new WriterInitiatorThread(obj);
        ReaderInitiatorThread rit = new ReaderInitiatorThread(obj);
        rit.start();
        wit.start();
        
	}
}

/* OUTPUT
 *
 *
ReadersWriters Problem
Enter the no. of readers
4
Enter the no. writers
3
STARTING READER AND WRITER THREADS
Suspending currently Reading Threads:

Writer 2 is currently Writing
Writer has finished writing
Resuming Suspended Reader Threads:

Suspending currently Reading Threads:

Reader 1 reading from shared document
Writer 1 is currently Writing
Writer has finished writing
Resuming Suspended Reader Threads:
1 
Suspending currently Reading Threads:
1 
Writer 3 is currently Writing
Writer has finished writing
Resuming Suspended Reader Threads:
Reader 2 reading from shared document
1 2 
Reader 3 reading from shared document
Reader 4 reading from shared document

Process completed.
*/