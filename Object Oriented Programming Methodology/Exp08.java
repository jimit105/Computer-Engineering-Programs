import java.util.*;
public class Exp08 
{
        public static void main(String args[])
        {
               Scanner sc=new Scanner(System.in);
               int a[]=new int[100];
               System.out.println("Use of hashMap:");
               System.out.println("Enter the number of elements:");
               int n=sc.nextInt();
               System.out.println("Enter the elements:");
               for(int i=0;i<n;i++)
               {
                   a[i]=sc.nextInt();
               }

               hm(a,n);
               System.out.println("\nUse of hashTable:");
               ht();
        }
        
        
        static void hm(int a[],int n)
        {
       		  //   HashMap<Integer,Integer> cache=new HashMap<Integer,Integer>();
    		Hashtable<Integer,Integer> source=new Hashtable<Integer,Integer>();
      		HashMap<Integer,Integer> map=new HashMap(source);
        	int key;
        	int occ;
        	for(int i=0;i<n;i++)
        	{
                    if(map.containsKey(a[i]))
                    {
	                    occ=(Integer)map.get(a[i]).intValue();
                    	map.put(a[i],new Integer(occ+1));
                    }
                    else
                    {
                        occ=1;
                        map.put(a[i],1);
                    }
            }

            
     	    Set set = map.entrySet();      
     	    Iterator i = set.iterator();
      
       		System.out.println("The hashmap elements are as follows:");
      		System.out.println("Key : Occurance");
      		while(i.hasNext()) 
      		{
         		Map.Entry me = (Map.Entry)i.next();
         		System.out.print(me.getKey() + ": ");
         		System.out.println(me.getValue());
      		}

        }
        
        
        static void ht()
        {
			int a[] = {1,2,3,4,5};
			int b[] = {2,3,1,0,5};
			boolean b1;
			Hashtable<Integer,Integer> ht = new Hashtable<Integer,Integer>(a.length);
			Hashtable<Integer,Integer> hash = new Hashtable<Integer,Integer>(b.length);
	
			for(int i=0;i<a.length;i++)
			{	
				ht.put(i,a[i]);            
       		}
       	
			for(int i=0;i<b.length;i++)
			{
				hash.put(i,b[i]);
			}
		
			Enumeration e1=ht.keys();
			Enumeration e2=hash.keys();
		
	outer:	while(e1.hasMoreElements())
			{
				Integer f1=(Integer)e1.nextElement();
				b1=true;
            	e2=hash.keys();
				while(e2.hasMoreElements())
				{
					Integer f2=(Integer)e2.nextElement();
					if(ht.get(f1)==hash.get(f2))
					{
						b1=false;
						continue outer;
					}
				}
			
				System.out.println("The element not present is:");
           		if(b1==true)
				{
     	            System.out.println(ht.get(f1));
				}
			}
        }

}


/* OUTPUT
 *
 *Use of hashMap:
Enter the number of elements:
8
Enter the elements:
1
2
3
5
2
1
4
3
The hashmap elements are as follows:
Key : Occurance
1: 2
2: 2
3: 2
4: 1
5: 1

Use of hashTable:
The element not present is:
4						*/