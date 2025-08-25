package basics.javapgms;

import java.util.*;

//MCMXCIV
public class R1_RomanToInteger {

    // Map Roman characters to their values
    private static final Map<Character, Integer> romanMap = new HashMap<>();

    static {
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);
    }
    public static int romanToInt(String s) {
        int total = 0;
        int prevValue = 0;
        // Traverse from right to left
        for (int i = s.length() - 1; i >= 0; i--) {
            int value = romanMap.get(s.charAt(i));

            if (value < prevValue) {
                // Subtract if smaller than the one on the right (IV, IX, etc.)
                total -= value;
            } else {
                // Otherwise add
                total += value;
            }

            prevValue = value;
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println("XIV = " + romanToInt("XIV"));   // 14
        System.out.println("LVIII = " + romanToInt("LVIII")); // 58
        System.out.println("MCMXCIV = " + romanToInt("MCMXCIV")); // 1994
    }
}
