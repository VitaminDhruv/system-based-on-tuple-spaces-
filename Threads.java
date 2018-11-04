
import java.util.*;
import java.io.*;
import java.lang.reflect.Field;




class Triplet1<X,Y,Z> implements Serializable
 {
	public  Tuple t;
	// Creating a Field for Triplets
	public  X first;
	public  Y second;
	public Z third;
	
	
	public void setTuple(Tuple t) {
		this.t=t;
		
	}
	
	//Setter method for the Triplet 
	private Triplet1(X first,Y second,Z third)
	{
		this.first=first;
		this.second=second;
		this.third=third;
	}
	// This is a factory method for creating Triplet so its mandatory
	public static <U, V, T> Triplet1 <U, V, T> of(U a, V b, T c)
	{
		return new Triplet1 <>(a, b, c);
	}

	
	//
	public Object tobject(Object o) {
		// TODO Auto-generated method stub
		ArrayList check= new ArrayList<>();
		// Converting object into triplet format
		Triplet triplet = (Triplet) o;
		
		// 
		check= Tuple.al;
		for (int i=0;i<check.size();i++ ) 
		{
			if (o.equals( check.get(i) )   )
			{
					return o;
			}
		}
		return null;
		
		}
	// returning in string format 
	public String toString()
	{
		return "(" + first + ", " + second + ", " + third + ")";
		
	}
	public X getX() {
		
		return this.first;
	}
	public Y getY() {
		return this.second;
	}
	public Z getZ() {
		return this.third;
	}


 }

public class Threads extends Thread {
	
	
	private static final String Object = null;

	private static final Collection String = null;

	Random rand=new Random();
	
	String[] names= {"Dhruv","Ram","Aman","Sarthak","Zeel","Priyanka","Himali","Rahul","Malav","Rudresh","Shyam","Priti"};
	int[] values= {15,18,10,9,8,7,19,25,36};
	Boolean[] status= {true,false};
	
	
	public void  run() {
		Thread currentThread=Thread.currentThread();
		
		//String[] x= {"String","Integer","Boolean"};
		// Creating Object for creating different types of tuples
		
		//Triplet1<> p4=Triplet1.of("ram ", 15,false); 
		Triplet1< String, Integer, Boolean> p1 = Triplet1.of(names[rand.nextInt(names.length-0)+0], values[rand.nextInt(values.length-0)+0], status[rand.nextInt(status.length-0)+0]);
		Triplet1< Integer, String, Boolean> p2 = Triplet1.of(values[rand.nextInt(values.length-0)+0],names[rand.nextInt(names.length-0)+0], status[rand.nextInt(status.length-0)+0]);
		Triplet1< Boolean, Integer, String> p3 = Triplet1.of(status[rand.nextInt(status.length-0)+0],values[rand.nextInt(values.length-0)+0], names[rand.nextInt(names.length-0)+0]);
		Triplet1<String,Boolean,Integer>   p4= Triplet1.of(names[rand.nextInt(names.length-0)+0],status[rand.nextInt(status.length-0)+0], values[rand.nextInt(values.length-0)+0]);
		Triplet1<Integer,Boolean,String>p5= Triplet1.of(values[rand.nextInt(values.length-0)+0], status[rand.nextInt(status.length-0)+0], names[rand.nextInt(names.length-0)+0]);
		Triplet1<Boolean,String,Integer>p6= Triplet1.of(status[rand.nextInt(status.length-0)+0],names[rand.nextInt(names.length-0)+0],values[rand.nextInt(values.length-0)+0]);
		
		
		
// simple array of object so the process will pick random Object from an Array of object	
		Object[] obj= {p1,p2,p3,p4,p5,p6};
		Object Tempsss=obj[rand.nextInt(obj.length)];

		
		// Switch case for assiging each thread a particular task 
		switch (currentThread.getName()) 
		{
			// Process 1 will add random tuple from the tuple array to the tuple space 
		case "Process 1":
			
			
			Object Temp11=obj[rand.nextInt(obj.length-1)];
			if(Tuple.al.contains(Temp11)) 
			
			{
				System.out.println("Tuple discarded! duplicate was added ");

			}
			else {
				Tuple.al.add(Temp11);
				//System.out.println("Duplicate found descarede automatically");
				System.out.println(currentThread.getName()+" writes in tuple space: "+Temp11);
				System.out.println("----");
			System.out.println("Tuple Space: "+Tuple.al);

			}
			
			
			System.out.println("-----------------------------------------");
			System.out.println("-----------------------------------------");

			break;
			// Two Different proccess will process 5 and 2 will do similar task 
		case "Process 5":
		case "Process 2":
			// Process 2 read from the tuple with the specific format
			// Now we are exatracting a Tuple with the spacific vlaue tuple
		
			//  We are extracting a tuple with the format (15,ram,false)
			
			ArrayList simobject= new ArrayList<>();
			int f_val=values[rand.nextInt(values.length)];
			String s_val="Ram";// simply we are converting to its type 
			Boolean t_val=false;
			
			String s1=((Object)f_val).getClass().getSimpleName();
			String s2=s_val.getClass().getSimpleName();
			String s3=t_val.getClass().getSimpleName();
			// Storing types of each object in an array
			
			ArrayList<String> s= new ArrayList<String>();
			s.add(s1);
			s.add(s2);
			s.add(s3);
			
			

			int size=Tuple.al.size();
			if(size>3) 
			{					
				// Now we specify which type of object we are looking for:
				
				//System.out.println("Process 2 looking for : ("+f_val+","+s_val+","+t_val+")");
				System.out.println(currentThread.getName()+" looking for tuples With format: "+s);
				// Now we extract a tuple from the arrayList and store it as an object
				// So firstly we just taking first object of arraylist and converting it into the object 
				// Now we iterate through all araylist object and print the match format
				
				for(int i=0;i<size;i++) 
				{
				// Storing each arrayList tuple in to the object
						ArrayList<String> check= new ArrayList<String>();
						Object Temp1=Tuple.al.get(i);
						//System.out.println("This tuple: "+Temp1+" has format of" );
						for (Field field : Temp1.getClass().getDeclaredFields()) 
						{
							field.setAccessible(true);
							String name = field.getName();
							Object value = null;
							try {
								value = field.get(Temp1);
							} 
							catch (IllegalArgumentException | IllegalAccessException e) 
							{
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
							if(name=="first" || name=="second" || name=="third")
							{
								check.add(value.getClass().getSimpleName());
							}
							//System.out.printf("Field name: %s, Field value: %s%n", name, value);
						}

						if(s.equals(check)) 
						{
							System.out.print("------------->");
							System.out.println(" Tuple Match: "+Temp1);
							simobject.add(Temp1);
						}
						//Set<ArrayList>distinctTriplets = new HashSet(check);

//						System.out.println(s[1]);
//						System.out.println(check.get(0));
						
				
				}
				System.out.println("---");
				System.out.println(currentThread.getName()+" read these Elements from the tuple space "+simobject);
				System.out.println("Tuple space: "+Tuple.al);
				System.out.println("-----------------------------------------");
				System.out.println("-----------------------------------------");

			
			}
			break;
			
		case "Process 3":
			
			// this is take process so this proces will take tuple with the similar format and remove it from the tuple space 
			int size1=Tuple.al.size();

			ArrayList simobject2=new ArrayList<>();
			if(size1>4)
			{
				// First create a format of what you want to remove 
				// String, int=Value, Boolean
				// This process will be same as read we are just removing a similar tuple from the tuple space 
				
				String f_pos="String";
				int s_pos=values[rand.nextInt(values.length)];
				Boolean t_pos=false;
				
				// we are just gonna compare the first and third format and value of the second 
				String f_pos1=f_pos.getClass().getSimpleName();
				String t_pos1=t_pos.getClass().getSimpleName();
				
				// Creating temp arraylist to store the foramt
				ArrayList remv= new ArrayList();
				remv.add(f_pos1);
				remv.add(s_pos);
				remv.add(t_pos1);
				System.out.println("--------");
				System.out.println(currentThread.getName()+" is looking for the Tuple with the format: "+remv);
				
				for (int i=0;i<size1;i++) {
					ArrayList check2= new ArrayList<>();
					// 
					Object T_el=Tuple.al.get(i);
					for (Field field : T_el.getClass().getDeclaredFields()) 
					{
						field.setAccessible(true);
						String name = field.getName();
						Object value = null;
						try {
							value = field.get(T_el);
						} 
						catch (IllegalArgumentException | IllegalAccessException e) 
						{
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						if(name=="first" || name=="third")
						{
							
							check2.add(value.getClass().getSimpleName());
						}
						if (name=="second") {
							check2.add(value);
						}
						//System.out.printf("Field name: %s, Field value: %s%n", name, value)
					
					}
					if(remv.equals(check2))
					{
						System.out.print("------------->");
						System.out.println("Tuple Found: "+T_el);
						simobject2.add(T_el);
						// SO ass soon as you remove it the main arraysize is reduce but your counter still looks for a next position got it
						
						System.out.println(currentThread.getName()+" remoeves "+T_el);
					}
					
				}
				
				
				
			Tuple.al.removeAll(simobject2);
			System.out.println("------------");
			System.out.println("Tuples removed so far: "+simobject2);
			System.out.println("");
			System.out.println("Tuple space: "+Tuple.al);
			System.out.println("-----------------------------------------");
			System.out.println("-----------------------------------------");

				
			// 
//			Object Tname=Tuple.al.remove(rand.nextInt(Tuple.al.size()-1));
//			System.out.println(currentThread.getName()+" take :"+Tname);
			}
			break;
			
			
		case "Process 4":
			// This process will update the value of any tuple and replace it to the 'the same position'
			
			int size3=Tuple.al.size();
			// We are simply updating the last value of tuple to any value
			
			if(size3>3) 
			{
				// Ok lets make it more simple we take a tuple and its position 
				// Exctracting a random position form the tuple space 
				int position=rand.nextInt(Tuple.al.size()+0);
				// extracting the tuple
				Object ext=Tuple.al.get(position);
				System.out.println("---");
				
				
				System.out.print(currentThread.getName()+" Executing...");
				System.out.println("This tuple : "+ext);
				Tuple.al.remove(ext);
				Tuple.al.add(position,Tempsss);
				System.out.println(" Updated to: "+Tempsss);
				System.out.println(currentThread.getName()+"...end");
				
				System.out.println("Tuple space: "+Tuple.al);
				System.out.println("-----------------------------------------");
				System.out.println("-----------------------------------------");

				
			}
				
			}
		}
	
	


	private Object tobject(int nextInt) {
		// TODO Auto-generated method stub
		return nextInt;
	}
}	
