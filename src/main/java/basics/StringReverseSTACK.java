package basics;

import org.testng.annotations.Test;

import java.util.Stack;

public class StringReverseSTACK {
	public static void main(String[] args) {


		// Given string to reverse 
		String stringToReverse = "MakeSeleniumEasy";

		// Convert string to char array
		char charArray[] = stringToReverse.toCharArray();

		// Creating an empty Stack 
		Stack<Character> charConatiner = new Stack<>();

		// Add characters of char array to Stack
		for (Character c : charArray) {
			charConatiner.push(c);
		}

		// Creating an empty string
		String reverseString = "";

		// Iterating Stack and creating string
		while (!charConatiner.isEmpty()) {
			reverseString = reverseString + String.valueOf(charConatiner.pop());
		}

		System.out.println("Given String : " + reverseString);
		System.out.println("Reversed String : " + reverseString);
	}


	@Test
	public void rough() {


		String str = "sumit raut";
		String sb = "";
		for (int i = str.length() - 1; i >= 0; i--) {
			sb = sb + str.charAt(i);
		}

		System.out.println(sb);//tuar timus

	}


	@Test
	public void Rough2() {
		String str = "sumit raut";
		System.out.println(str);

		Stack<String> sstack = new Stack<>();

		for (String s : str.split("")) {

			System.out.println(s);
			sstack.push(s);
		}

		System.out.println(sstack);

		System.out.println(sstack.peek());//t
		System.out.println("--separator---");
		while (!sstack.isEmpty()) {
			System.out.println(sstack.pop());
		}
	}



	@Test
	public void Test(){

   String str="sumit raut";
   for(int i=str.length()-1;i>=0;i--){
	   System.out.print(str.charAt(i));//tuar timus
   }




	}
}


