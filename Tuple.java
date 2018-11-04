//package org.javatuples;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList; 

	

//String[] names= {"ram","dhruv"};

public class Tuple {
	
	public static  ArrayList al = new ArrayList<>();

	public static void main(String args[]) throws InterruptedException
	{
//Thread Synchronization 
//       Iterator<Triplet1<String, Integer, Boolean>> it = al.iterator(); 
//        while (it.hasNext())
//        {System.out.println(it.next());}

		
	while (true) 
		{
		//public static List<Triplet1<String, Integer,Boolean>> list = new ArrayList<>();
		
		//	Threads.al.add(4);
			Threads T1=new Threads();
			Threads T2=new Threads();
			Threads T3=new Threads();
			Threads T4=new Threads();
			Threads T5=new Threads();

		// Creating thread Id
			//long t1id=T1.currentThread().getId();
		// Settting name for process
			T1.setName("Process 1");
			T2.setName("Process 2");
			T3.setName("Process 3");
			T4.setName("Process 4");
			T5.setName("Process 5");
			long t2id=T2.currentThread().getId();
//			//T1.sleep(2000);
		try {
			T1.start();
			Thread.sleep(1000);
			
			T2.start();
			Thread.sleep(2000);

			
			T3.start();
			Thread.sleep(5000);
			T4.start();
			Thread.sleep(2500);
			T5.start();
			Threads.sleep(2800);
		
		}
		catch (NumberFormatException e1){  
			
		}
			
		}
	}
}
