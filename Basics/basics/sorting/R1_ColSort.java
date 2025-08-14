package basics.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class R1_ColSort {

    public static void main(String[] args) {

        List<Integer> al=Arrays.asList(12,3,0,5);
        System.out.println("######################");
        System.out.println(al);
        Collections.sort(al);
        System.out.println(al);
        System.out.println("######################");
        System.out.println("---------------");
        Collections.reverse(al);
        System.out.println(al);
        System.out.println("---------------");


    }
}
