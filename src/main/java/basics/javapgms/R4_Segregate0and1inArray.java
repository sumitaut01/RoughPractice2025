package basics.javapgms;

import java.util.Arrays;

public class R4_Segregate0and1inArray {
    public static void main(String[] args) {
        int[] arr = {1, 0, 1, 1, 0, 0, 0};
        int left = 0;
        int right = arr.length - 1;

        System.out.println("Before: => " + Arrays.toString(arr));

        while (left < right) {
            // Move left forward if already 0
            while (arr[left] == 0 && left < right) {
                left++;
            }

            // Move right backward if already 1
            while (arr[right] == 1 && left < right) {
                right--;
            }

            // Now left points to 1 and right points to 0, so swap
            if (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;

                left++;
                right--;
            }
        }

        System.out.println("After: => " + Arrays.toString(arr));
    }
}
