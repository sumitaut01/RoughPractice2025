package basics.javapgms;

public class removeSpacesDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		String text=" this   is  sparta   ";
		
		
		System.out.println(text.replaceAll("\\s", "")); //thisissparta
	}

}
