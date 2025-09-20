package basics.javapgms;

public class RemoveSpecialCharsfromString {
	
	
	public static void main(String[] args) {
		
		String demo="sumit%%%$$##@@&&raut";
		
		
		System.out.println(demo.replaceAll("[^a-z A-Z 0-9]",""));
		//sumitraut
		
	}

}
