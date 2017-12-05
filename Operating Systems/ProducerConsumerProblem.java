
import java.util.*;

public class ProducerConsumerProblem{
	
	public static void main(String[] args) throws Exception{
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("\nInput the size of the buffer queue: ");
		int buf = sc.nextInt();	
		
		int countingSemaphore = 0;
		int binarySemaphore = -1;
		boolean sleep = false;
		
		System.out.println("Initializing....\n");
		Thread.sleep(2000);
		
		System.out.println("Starting simulation...\n");
		Thread.sleep(1000);
		for(int i=1;i<=20;i++){
			double f = Math.random();
			
			System.out.print("t = "+i+"\t");
			//System.out.print(f+" ");
			if(f>0.5){
				f=1;			//Produce
				binarySemaphore = 1;
			}
			else {
				f=0;			//Consume
				binarySemaphore = 0;
			}
			
			if(binarySemaphore == 0){
				
				/*Code for consumer*/
				
				if(countingSemaphore>0){
					System.out.println("Consumer consuming resource...\n");
					countingSemaphore--;
					sleep = false;
				}
				else{
					if(sleep==true) {
						System.out.println("Consumer asleep....\n");
					}
					else{
						System.out.println("No items in the queue. Consumer is sleeping....\n");
						sleep = true;
						Thread.sleep(500);
					}
					continue;
				}
			}
			
			else{
				
				/*Code for producer*/
				
				if(countingSemaphore == buf){
					if(sleep==true){
						System.out.println("Producer asleep....\n");
					}	
					else{
						System.out.println("The queue is full! Producer is sleeping....\n");
						sleep = true;
						Thread.sleep(500);
					}
					continue;
				}
				else{
					countingSemaphore++;
					System.out.println("Producer producing resource...\n");
					sleep = false;
				}
			}
			
			Thread.sleep(500);
				
		}
		
		System.out.println("\n\nResources left in the queue: "+countingSemaphore);
	}
}