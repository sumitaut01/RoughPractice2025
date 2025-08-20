package basics.javapgms;

import java.util.Arrays;

public class R31_PrefixSum {

    //Input: arr[] = [10, 20, 10, 5, 15]
    //Output: [10, 30, 40, 45, 60]
    public static void main(String[] args) {

        int arr[]={10, 20, 10, 5, 15};
        int preSum[]=new int[arr.length];

        preSum[0]=arr[0];
        for (int i=1;i<arr.length;i++){
            preSum[i]=arr[i]+preSum[i-1];
            System.out.println(i+" "+preSum[i]);

            System.out.println(Arrays.toString(preSum));
        }
        //1 30
        //[10, 30, 0, 0, 0]
        //2 40
        //[10, 30, 40, 0, 0]
        //3 45
        //[10, 30, 40, 45, 0]
        //4 60
        //[10, 30, 40, 45, 60]
    }
}
