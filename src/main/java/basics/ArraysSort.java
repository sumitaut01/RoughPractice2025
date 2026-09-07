package basics;

import org.testng.annotations.Test;

import java.lang.reflect.Array;
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



	@Test
	public void linearSort(){

		int [] arr= {4,5,6,3,5};
		System.out.println("Before Sorting=>"+ Arrays.toString(arr));//Before Sorting=>[4, 5, 6, 3, 5]
		for(int i=0;i<arr.length-1;i++){

			for (int j=i+1;j<arr.length;j++){

				if(arr[i]<arr[j]){
					int temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
		}
		System.out.println("After Sorting=>"+ Arrays.toString(arr));//After Sorting=>[6, 5, 5, 4, 3]
	}

}

