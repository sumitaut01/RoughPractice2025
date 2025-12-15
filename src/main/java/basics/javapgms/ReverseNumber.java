package basics.javapgms;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReverseNumber {
    public static void main(String[] args) {
        int num = 12345;

        String s = String.valueOf(num);
        List<String> list = Arrays.asList(s.split(""));

        Collections.reverse(list);

        String result = String.join("", list);
        System.out.println(result); // 54321
    }
}
