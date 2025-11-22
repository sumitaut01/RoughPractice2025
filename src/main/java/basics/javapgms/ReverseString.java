package basics.javapgms;

public class ReverseString {
	static String rev = "";

	public static void main(String[] args) {
		// 

		String reverseMe = "this is love";
		String reverseMe2 = "new logic used";

		//Without Using new variable
		for (int i = 0; i < reverseMe.length(); i++) {
			reverseMe = reverseMe.substring(1, reverseMe.length() - i) + reverseMe.substring(0, 1)
					+ reverseMe.substring(reverseMe.length() - i, reverseMe.length());
		}
		System.out.println(reverseMe);
		
		
		
		//Logic 2 .. Temp Variable used
		for (int i = reverseMe2.length() - 1; i >= 0; i--) {
            rev = rev + reverseMe2.charAt(i);
		}
		System.out.println(rev);
		
		
		//Logic 3
		//Note that no direct reverse function available in string as its immutable
		//Hence use StringBuffer
		String name="this is life";
		StringBuffer sb=new StringBuffer(name);
		System.out.println(sb.reverse()); //desu cigol wen

	}

}
