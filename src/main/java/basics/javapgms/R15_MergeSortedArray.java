package basics.javapgms;


// Variant 1: Merge into a New Array
//🔹 Problem Statement:
//You are given two sorted arrays arr1 and arr2. Merge them into one sorted array and return the result.
//Input: arr1 = [1, 3, 5, 7], arr2 = [2, 4, 6, 8]
//Output: [1, 2, 3, 4, 5, 6, 7, 8]


import java.util.Arrays;

public class R15_MergeSortedArray {

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5, 7};
        int[] arr2 = {1, 3, 5, 7};

        int n = arr1.length, m = arr2.length;
        int[] result = new int[n + m];

        int i = 0, j = 0, k = 0;

        // Merge both arrays
        while (i < n && j < m) {
            if (arr1[i] < arr2[j]) {
                result[k++] = arr1[i++];
            } else {
                result[k++] = arr2[j++];
            }
        }

        // Copy remaining elements
        while (i < n) {
            result[k++] = arr1[i++];
        }
        while (j < m) {
            result[k++] = arr2[j++];
        }

        System.out.println(Arrays.toString(result));
    }
}
