package basics.javapgms;

public class R16_MaximumSumofSubarray {




    public static void main(String[] args) {



        //Given an array of integers and a number k, find the maximum sum of a subarray of size k.
        //arr = [2, 1, 5, 1, 3, 2], k = 3
        //Explanation: Subarray [5, 1, 3] has the maximum sum = 9

        int[] arr = {2, 1, 5, 1, 3, 2};
        int k = 3;
        int windSum = 0;
        int maxSum = 0;


        for(int i=0;i<k;i++){
            windSum+=arr[i];//8

        }

        //8
        for(int j=k;j<arr.length;j++){
            windSum+=arr[j]-arr[j-k];
            maxSum=Math.max(windSum,maxSum);
        }

        System.out.println(maxSum);


    }




    public class MaxSubarrayBruteForce {

        public static void bruteForce(int[] arr) {
            int part = 3; // size of the subarray
            int maxsum = Integer.MIN_VALUE;
            int currSum;

            for (int i = 0; i <= arr.length - part; i++) {
                currSum = 0;
                for (int j = i; j < i + part; j++) {
                    currSum += arr[j];
                }
                System.out.println("Subarray starting at index " + i + ": Sum = " + currSum);
                if (currSum > maxsum) {
                    maxsum = currSum;
                }
            }

            System.out.println("Max Sum of subarray of size " + part + " = " + maxsum);
        }

        public static void main(String[] args) {
            int[] arr = {2, 1, 5, 1, 3, 2};
            bruteForce(arr);
        }
    }

}
