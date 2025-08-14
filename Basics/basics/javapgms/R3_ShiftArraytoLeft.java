package basics.javapgms;

import java.util.Arrays;

public class R3_ShiftArraytoLeft {

    public static void main(String[] args) {

        int[] arr = {0, 1, 2, 3, 4, 5};
        System.out.println("Before: " + Arrays.toString(arr));
        int shiftLeft = 1;

        int[] temp = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            // Shift each element to the left by `shiftLeft` positions
            temp[i] = arr[(i + shiftLeft) % arr.length];
        }

        System.out.println("After : " + Arrays.toString(temp));
    }
}
