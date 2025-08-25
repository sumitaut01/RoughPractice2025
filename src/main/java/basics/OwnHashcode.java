package basics;

public class OwnHashcode {

//Object class has hashCode method
//every class extends Object class and hence has access to hashCode method
//In below example we are overriding it. 
//hashcode mthod is a native method and has return type as integer
//In below example we are Overriding hashCode() method of Object class to return our own logic

	int aadharNum;
	String name;
public OwnHashcode(int aadharNum, String name) {
		this.aadharNum = aadharNum;
		this.name = name;
	}

	@Override
	public int hashCode() {
		return aadharNum;
		}

	public static void main(String[] args) {
		OwnHashcode hs = new OwnHashcode(101, "sumit");
		System.out.println(hs.hashCode());
	}
}
