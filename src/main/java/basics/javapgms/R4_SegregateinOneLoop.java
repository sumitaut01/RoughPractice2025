package basics.javapgms;

import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

public class R4_SegregateinOneLoop {

    public static void main(String[] args) {


        int[] arr = {0,1,0,1,1,0};//[1, 0, 0, 1, 0]
        int j = 0; // Pointer for the position of the last 0 found
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                // Swap the 0 with the element at position j
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++; // Increment j to the next position for a 0
            }
        }
        System.out.println(Arrays.toString(arr));//[0, 0, 0, 1, 1]
    }



    @Test
    public void rough(){
        int[] arr = {0,1,0,1,1,0};//[1, 0, 0, 1, 0]
        int j = 0; // Pointer for the position of the last 0 found

        System.out.println(Arrays.toString(arr));
        for(int i=0;i<arr.length;i++){
            if(arr[i]==0){
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                j++;
            }
        }

        System.out.println(Arrays.toString(arr));
    }
}
