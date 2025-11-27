package basics.javapgms;

import java.util.*;

public class DescSort {
    public static void main(String[] args) {
        Integer[] a = {5, 1, 8, 3};

        //
        System.out.println("Before Sorting");
        System.out.println(Arrays.toString(a));


        Arrays.sort(a);
        System.out.println("After Sorting");
        System.out.println(Arrays.toString(a));


        Arrays.sort(a, Collections.reverseOrder());
        System.out.println("After Reverse Sorting");
        System.out.println(Arrays.toString(a));


        //Before Sorting
        //[5, 1, 8, 3]
        //After Sorting
        //[1, 3, 5, 8]
        //After Reverse Sorting
        //[8, 5, 3, 1]
    }
}