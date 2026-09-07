package karat;

import java.util.Arrays;
import java.util.List;

public class ListtoArray {

    public static void main(String[] args) {

     List<String> ab= List.of("a","b");
        System.out.println(Arrays.toString(ab.toArray()));
        System.out.println(ab.toArray().length);//2
        System.out.println(List.of("Neha","Tia","Julie").toArray(new String[0]).length);//3
        System.out.println(List.of("Neha","Tia","Julie").toArray(new String[]{}).length);//3
    }
}
