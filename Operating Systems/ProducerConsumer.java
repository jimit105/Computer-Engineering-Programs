import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.concurrent.Semaphore;

class Producer extends Thread
{
    ProducerConsumer obj;
    Producer(ProducerConsumer obj1)
    {
       this.obj = obj1;
    }
    
    public void run()
    {
        int i = 0;
        int k = obj.items;
        while(k!=0)
        {
            if(obj.empty_Count.availablePermits() == 0)
            {
              try{
                System.out.println("Putting the Producer to sleep since Item Buffer is full");
              this.suspend();}catch(Exception e){System.out.println(e); }
            
            }
            try{
            obj.mutex.acquire();
            obj.empty_Count.acquire();
            
            System.out.println("Item produced and added to buffer. Item No: " + (++i));
            //System.out.println(obj.empty_Count.availablePermits());
            obj.mutex.release();
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
            if(obj.empty_Count.availablePermits() < obj.buff_size )
            {
               //System.out.println("here");
                try{
                  obj.c_thread.resume();}catch(Exception e){System.out.println(e); }
            
            }
            k--;
            
        }
    }
}

class Consumer extends Thread
{
    ProducerConsumer obj;
    Consumer(ProducerConsumer obj1)
    {
       this.obj = obj1;
    }
    public void run()
    {
        int i = 0;
        int k = obj.items;
        while(k!=0)
        {
            if(obj.empty_Count.availablePermits() == obj.buff_size)
            {System.out.println("Putting the Consumer to sleep since Item Buffer is empty");
                this.suspend();
            
            }try{
            obj.mutex.acquire();
            obj.empty_Count.release();
            System.out.println("Item consumed: " + (++i));
            //System.out.println(obj.empty_Count.availablePermits());
            obj.mutex.release();
            }catch(Exception e){System.out.println(e); }
            
            if(obj.empty_Count.availablePermits() >= 1)
            obj.p_thread.resume();
            k--;
        }
    }
}
class ProducerConsumer
{
    static Semaphore empty_Count;
    static Semaphore mutex;
    static Semaphore full_count;
    static int items,buff_size;
    static Producer p_thread;
    static Consumer c_thread;
	public static void main (String[] args) throws java.lang.Exception
	{
		
		 System.out.println("Enter the no. of items to be produced");
		 Scanner sc = new Scanner(System.in);
		 items = sc.nextInt();
		 System.out.println("Enter the Buffer Size");
		  buff_size = sc.nextInt();
		  if(buff_size<1 || items < 1)
		  {
             System.out.println("Invalid Input/s");
             System.exit(12);
		  }
		  empty_Count = new Semaphore(buff_size);
          mutex = new Semaphore(1);
          full_count = new Semaphore(0);
        ProducerConsumer obj2 = new ProducerConsumer();
		 p_thread = new Producer(obj2);
		 c_thread = new Consumer(obj2);
		  p_thread.start();
		  c_thread.start();
		  try{
		      p_thread.join();
		      c_thread.join();
		  }
		  catch(Exception e){System.out.println(e);}
		  System.out.println("All items were succesfully produced and consumed");
		
	}
}

/* OUTPUT
 *
 *--------------------Configuration: <Default>--------------------
Enter the no. of items to be produced
5
Enter the Buffer Size
3
Item produced and added to buffer. Item No: 1
Item produced and added to buffer. Item No: 2
Item produced and added to buffer. Item No: 3
Putting the Producer to sleep since Item Buffer is full
Item consumed: 1
Item consumed: 2
Item consumed: 3
Putting the Consumer to sleep since Item Buffer is empty
Item produced and added to buffer. Item No: 4
Item produced and added to buffer. Item No: 5
Item consumed: 4
Item consumed: 5
All items were succesfully produced and consumed

Process completed.
*/