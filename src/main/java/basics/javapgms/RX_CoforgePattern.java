package basics.javapgms;

import org.testng.annotations.Test;

import java.util.HashMap;

public class RX_CoforgePattern {

    public static void main(String[] args) {

        String str = "aabbccadd";

        int count;
        for (int i = 0; i < str.length(); i = i + count) {
            count = 0;
            for (int j = i; j < str.length(); j++) {
                if (String.valueOf(str.charAt(j)).equals(String.valueOf(str.charAt(i)))) {
                    count++;
                } else {
                    break;
                }
            }
            System.out.print(String.valueOf(str.charAt(i)) + count);
        }
    }


//a2b2c2a1d2


}