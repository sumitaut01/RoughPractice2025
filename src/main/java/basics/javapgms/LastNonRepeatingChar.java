package basics.javapgms;

import java.util.LinkedHashMap;
import java.util.Map;

public class LastNonRepeatingChar {

    public static Character findLastNonRepeatingChar(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }

        // Step 1: Count character frequencies
        Map<Character, Integer> freqMap = new LinkedHashMap<>();
        for (char ch : str.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }


        System.out.println(freqMap);

        // Step 2: Traverse in reverse to find last non-repeating
        for (int i = str.length() - 1; i >= 0; i--) {
            char ch = str.charAt(i);
            if (freqMap.get(ch) == 1) {
                return ch;
            }
        }

        // Step 3: Return null if not found
        return null;
    }

    public static void main(String[] args) {
        System.out.println(findLastNonRepeatingChar("swiss"));      // Output: w
        System.out.println(findLastNonRepeatingChar("aabbccdee"));  // Output: d
        System.out.println(findLastNonRepeatingChar("aabbcc"));     // Output: null
    }
}