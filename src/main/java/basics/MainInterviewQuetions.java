package basics;

public class MainInterviewQuetions {
	
	//#1 We can overload main method. Return type is not considered for Overloading.Only Parameters
	//#2 We cant OVERRIDE static methods. @Override when added will throw error. It would be considered a separate method 
	//     in such cases
	
	//#3 Sequence of static public can be altered
	// if we remove public  and try running run as java is not visible. 
	// From CMD we will get this "Error: Could not find or load main class MainInterviewQuetions.java"
	
	
	
	 public static void  main(String[] args) {
	
		System.out.println("hi");
		main("sumit"); // static main
		
		main(5);  //5
		new MainInterviewQuetions().main("sumit", "sagar");  //sumit:sagar
		//new MainInterviewQuetions().main("love");  //non static main
		
	}
	 
	 static public void main(String name) {
			System.out.println("static main");		
		}
		
	 
//	  public void main(String name) {
//			System.out.println("non static main");		
//		}
		
	 
	 static public void main(int num) {
			
			System.out.println(num);
			
		}
	 
	  public void main(String name1,String name2) {			
			System.out.println(name1  +":"+name2);
		}
		
		
	
	
	
	
	

}

class Second extends MainInterviewQuetions{
	//@Override  //#Main is static and hence can ve overridden
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	
}
