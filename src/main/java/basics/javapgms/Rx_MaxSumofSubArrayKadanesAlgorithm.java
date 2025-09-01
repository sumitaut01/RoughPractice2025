package basics.javapgms;

public class Rx_MaxSumofSubArrayKadanesAlgorithm {

    public static int maxSubArraySum(int[] arr) {
        // 'maxSoFar' stores the overall maximum sum found.
        int maxSoFar = arr[0];

        // 'maxEndingHere' stores the maximum sum ending at the current position.
        int maxEndingHere = arr[0];

        // Iterate through the array starting from the second element.
        for (int i = 1; i < arr.length; i++) {
            // Calculate the maximum sum ending at the current position.
            // It's either the current element itself, or the current element plus the maximum sum of the previous subarray.
            maxEndingHere = Math.max(arr[i], maxEndingHere + arr[i]);

            // Update the overall maximum sum if the current one is greater.
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }

        return maxSoFar;
    }

    public static void main(String[] args) {
        int[] arr1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Maximum subarray sum for array 1 is: " + maxSubArraySum(arr1)); // Expected output: 6 (from subarray [4, -1, 2, 1])

        int[] arr2 = {1, 2, 3, -2, 5};
        System.out.println("Maximum subarray sum for array 2 is: " + maxSubArraySum(arr2)); // Expected output: 9 (from subarray [1, 2, 3, -2, 5])

        int[] arr3 = {-1, -2, -3, -4};
        System.out.println("Maximum subarray sum for array 3 is: " + maxSubArraySum(arr3)); // Expected output: -1 (from subarray [-1])
    }
}