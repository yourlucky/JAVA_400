// --== CS400 Project One File Header ==--
// Name: <YoonChae_Na>
// Email: <yna23@wisc.edu>
// Team: <BLUE>
// Group: <DE>
// TA: <Daniel>
// Lecturer: <Florian>
// Notes to Grader: <I put more than 100 hours>


public class HashtableMapTests {
	
	@SuppressWarnings("rawtypes")
	public static boolean test1() 
	{ /* test code here */ 
		
		// Check constructor and Linkedarray size
		
		HashtableMap t1_1= new HashtableMap(10);
		if (t1_1.KL_size != 10)
			return false;
		
		HashtableMap t1_2= new HashtableMap(100);
		if (t1_2.KL_size != 100)
			return false;
		
		HashtableMap t1_3= new HashtableMap();
		if (t1_3.KL_size != 20)
			return false;
		
		return true;
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static boolean test2() 
	{ /* test code here */ 
		
		// Check put function for various type for key-value 
		// Check put prevent duplicate key 
		
		HashtableMap t2_1= new HashtableMap(10);
		t2_1.put(1, 1);
		t2_1.put(2.1, 2);
		t2_1.put('a', 1);
		t2_1.put(12, 2.2);
		t2_1.put(31, 'b');
		t2_1.put('c', 'd');
		t2_1.put('e', 3.2);
		t2_1.put("keg", 3.2);
		t2_1.put(5, "jjjj");
		t2_1.put("kedg", "onod");
				
		
		if (t2_1.size() != 10)
			return false;
		
		// Check put prevent duplicate key 
		HashtableMap t2_2= new HashtableMap(10);
		t2_2.put('e', 3.2);
		if(t2_2.put('e', 34) == true)
			return false;
		
		
		return true;
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static boolean test3() 
	{ /* test code here */
		
		// Check get variety of key and works properly 
		// Check clear function
		//check clear function without changing the underlying array capacity
		
		
		HashtableMap t3_1= new HashtableMap(10);
		t3_1.put(1, 1);
		t3_1.put(2.5, 2);
		t3_1.put('a', 'z');

			
		if(!t3_1.get(1).equals(1))
			return false;
	
		if(!t3_1.get(2.5).equals(2))
			return false;
		
		if(!t3_1.get('a').equals('z'))
			return false;
		
		// Check clear function
		t3_1.clear();
		
		if(t3_1.size()>0)
			return false;

		
		//check clear function without changing the underlying array capacity
		
		HashtableMap t3_2= new HashtableMap(10);
		t3_2.put(1, 1);
		t3_2.put(2, 2);
		t3_2.put(3, 3);
		t3_2.put(4, 1);
		t3_2.put(5, 2);
		t3_2.put(6, 3);
		t3_2.put(7, 1);
		t3_2.put(8, 2);
		t3_2.put(9, 3);
		int before =t3_2.GetArraySize();
		
		t3_2.clear();
		int after = t3_2.GetArraySize();
		
		if(before == after)
			return false;
				
		return true;
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static boolean test4() 
	{ /* test code here */ 
		
		//check contain function 
		//check remove function
		//check remove function-null
		
		HashtableMap t4_1= new HashtableMap();
		t4_1.put(1, 1);
		t4_1.put(1.5, 10);
		t4_1.put('k', 10);
		
		if(t4_1.containsKey(1)!=true)
			return false;
		if(t4_1.containsKey(1.5)!=true)
			return false;
		if(t4_1.containsKey('k')!=true)
			return false;
		
	
		
		t4_1.remove(1);
		t4_1.remove(1.5);
		t4_1.remove('k');
		
		if(t4_1.containsKey(1)!=false)
			return false;
		if(t4_1.containsKey(1.5)!=false)
			return false;
		if(t4_1.containsKey('k')!=false)
			return false;
		
		//check remove function return value
		
		t4_1.put(100, 2);
		t4_1.put(200.1, 2.1);
		t4_1.put('c', 's');
		if(!t4_1.remove(100).equals(2))
			return false;
		if(!t4_1.remove(200.1).equals(2.1))
			return false;
		if(!t4_1.remove('c').equals('s'))
			return false;
		
		//check remove function return value null
		
		if(t4_1.remove('c') != null)
			return false;
		
		return true;
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static boolean test5() 
	{ /* test code here */
		
		//putting many data without error
		//putting many data auto increasing
		
		HashtableMap t5_1= new HashtableMap(5);
		
		int before =t5_1.GetArraySize();
		
		for(int i=0; i<10001; i++)
		{
			t5_1.put(i, 2*i);
		}
		
		if(!t5_1.get(10000).equals(20000))
			return false;
		
	
		int after = t5_1.GetArraySize();
		
		if(before == after)
			return false;
		
		return true;
	}

}
