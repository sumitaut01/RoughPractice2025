package basics;

import java.util.Arrays;
import java.util.Collections;

public class arraysParallelSort {

	public static void main(String[] args) {
			int []a= {12,34,2,12,14};	
		System.out.println("Array BEFORE sorting:"+Arrays.toString(a));
		
	    //#1	Arrays.parallelSort(a);
		Arrays.parallelSort(a);
		System.out.println("Array AFTER sorting:"+Arrays.toString(a));	
//		Array BEFORE sorting:[12, 34, 2, 12, 14]
//	    Array AFTER sorting:[2, 12, 12, 14, 34]
			
		 //#2 Arrays.sort(b)
		int []b= {2,4,2,1,0};
		
		System.out.println("Array BEFORE sorting:"+Arrays.toString(a));
		Arrays.sort(b);
		System.out.println("Array AFTER sorting:"+Arrays.toString(b));	
//		Array BEFORE sorting:[2, 12, 12, 14, 34]
//		Array AFTER sorting:[0, 1, 2, 2, 4]

		//#3 using Collections class.  Note only works with Object type
		
		Integer []c= {42,34,332,1,0};
		System.out.println("Array BEFORE sorting:"+Arrays.toString(c));
		Arrays.sort(c,Collections.reverseOrder());

		System.out.println("Array AFTER reverse sorting:"+Arrays.toString(c));
		
//		Array BEFORE sorting:[42, 34, 332, 1, 0]
//		Array AFTER reverse sorting:[332, 42, 34, 1, 0]

	}
	
	

}
