package basics;

import java.util.Arrays;

public class ArraysSort {
	
	public static void main(String[] args) {
		
		
		int [] arr= {4,5,6,3,5};
		
		System.out.println(arr.length);
		
		Arrays.sort(arr);
		
		
		//1 Method 1 of Printing
		for(int x:arr) {
			System.out.println(x);	
			//O/P
			//3
			//4
			//5
			//5
			//6
			
		}
		
		//2 Method 2 of Printing
		
		System.out.println(Arrays.toString(arr));
		//[3, 4, 5, 5, 6]
		
	}

}

