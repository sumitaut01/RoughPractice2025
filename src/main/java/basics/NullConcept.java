package basics;

public class NullConcept {

	public static void main(String[] args) {

		// 1 //Null can be assigned to Wrapper classes.
		// Ex. Integer class can have null as a value.
		// However primitive numeric  can't hold null value. 
		Integer i = null;
		// int i= null; // Not Allowed System.out.println(name.concat("test"));

		// 2
		Integer num = 10;
       System.out.println(num instanceof Integer); // true
      
       Integer dummy = null;
       System.out.println(dummy instanceof Integer); // false
       
       
       NullConcept nc=new NullConcept();
       System.out.println(nc instanceof NullConcept); // true
       
       NullConcept nc2=new NullConcept();
       nc2=null;
       System.out.println(nc2 instanceof NullConcept); // false
       
       
       
       
       
       
       //3
       
       //class references( without actual object i.e without new ) can access static methods
       
       NullConcept obj=null;
       obj.staticMethod();   //works
       obj.nonstaticMethod(); //java.lang.NullPointerException

	}
	
	
	
	public static void staticMethod() {
		
		System.out.println("static Method");
		
	}

	
public  void nonstaticMethod() {
		
	System.out.println("non static Method");
	
	}
}
