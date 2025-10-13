package basics.javapgms;


class NonSingleTon{
	
	
	public NonSingleTon() {
		
		System.out.println("Object Created");
	}
	
	
	
	
	
}

public class SingleTonDemo {

	private static SingleTonDemo instanceSingleTonDemo = null;

	private SingleTonDemo() {
		// Since we don't want object creation via constructor
	}

	public static SingleTonDemo getInstance() {
       if (instanceSingleTonDemo == null)
          instanceSingleTonDemo = new SingleTonDemo();
       
       System.out.println(instanceSingleTonDemo.hashCode());
		return instanceSingleTonDemo;
	}
	
	
	
	public static void main(String[] args) {
		
		SingleTonDemo x=SingleTonDemo.getInstance();
		SingleTonDemo y=SingleTonDemo.getInstance();
		SingleTonDemo z=SingleTonDemo.getInstance();
		
		System.out.println(x==y);
		System.out.println(y==z);
		System.out.println(z==x);
		
		
//		705927765
//		705927765
//		705927765
//		true
//		true
//		true


		NonSingleTon non1=new NonSingleTon();
		NonSingleTon non2=new NonSingleTon();
		NonSingleTon non3=new NonSingleTon();
		
		System.out.println(non1.hashCode());
		System.out.println(non2.hashCode());
		System.out.println(non3.hashCode());
		
		
		System.out.println(non1==non2);
		System.out.println(non2==non3);
		System.out.println(non3==non1);
		
////	Object Created
//		Object Created
//		Object Created
//		366712642
//		1829164700
//		2018699554
//		false
//		false
//		false
		
	}

}
