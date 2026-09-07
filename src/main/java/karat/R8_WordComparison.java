package karat;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class R8_WordComparison {


    public static List<List<String>> findDocChanges(String original, String edited) {
        //List of differences
        List<List<String>> diff = new ArrayList<>();
        // what if the string are null
        if (Objects.isNull(original)) original = "";
        if (Objects.isNull(edited)) edited = "";


        String[] arrOriginal = original.isEmpty() ? new String[0] : original.trim().split("\\s+");
        String[] arrEdited = edited.isEmpty() ? new String[0] : edited.trim().split("\\s+");

        //what if the one string longer than other
        int looping_length = Math.max(arrOriginal.length, arrEdited.length);

        for (int i = 0; i < looping_length; i++) {

            String oWord = i < arrOriginal.length ? arrOriginal[i] : "";
            String oEdited = i < arrEdited.length ? arrEdited[i] : "";
            if (!String.valueOf(oWord).equals(oEdited)) {
                diff.add(List.of(oWord, oEdited));
            }
        }
        return diff;
    }


    @Test
    public void testHappy() {
        String original = " this has ";
        String edited = "this has";
        System.out.println(findDocChanges(original, edited));//[]
    }
    @Test
    public void testLengthMismatch() {
        String original = " this has to end now";
        String edited = "this wont to end";
        System.out.println(findDocChanges(original, edited));
    }

    @Test
    public void testnull() {
        String original = null;
        String edited = "this has";
        System.out.println(findDocChanges(original, edited));//[[, this], [, has]]
    }


    @Test
    public void testnullboth() {
        String original = null;
        String edited = null;
        System.out.println(findDocChanges(original, edited));//
    }
}
