package basics.javapgms;

import java.util.Stack;

public class StringReverseSTACK {
	public static void main(String[] args) {
		
		
		// Given string to reverse 
		String stringToReverse = "MakeSeleniumEasy";
		
		// Convert string to char array
		char charArray[]= stringToReverse.toCharArray();
		
		// Creating an empty Stack 
		Stack<Character> charConatiner= new Stack<>();
		
		// Add characters of char array to Stack
		for(Character c: charArray)
		{
			charConatiner.push(c);
		}
		
		// Creating an empty string
		String reverseString ="";
		
		// Iterating Stack and creating string
		while(!charConatiner.isEmpty())
		{
			reverseString = reverseString + String.valueOf(charConatiner.pop());
		}
		
		System.out.println("Given String : "+reverseString);
		System.out.println("Reversed String : "+reverseString);
	}

}