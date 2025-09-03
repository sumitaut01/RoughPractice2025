package basics.javapgms;

//abcabcbb
import basics.characters.CharacterDemo;

import java.util.HashMap;
import java.util.Map;

public class R31_LongestSubString {

    public static int lengthOfLongestSubString(String str) {
        int start = 0;
        int maxLength = 0;
        Map<Character, Integer> charMap = new HashMap<>();

        // The 'end' pointer moves to expand the window.
        for (int end = 0; end < str.length(); end++) {
            char currentChar = str.charAt(end);

            // If the character is already in the map and its last seen index
            // is within the current window (i.e., >= start).
            if (charMap.containsKey(currentChar) && charMap.get(currentChar) >= start) {
                // The 'start' pointer moves to the right, to the position after the last
                // occurrence of the repeating character.
                start = charMap.get(currentChar) + 1;
            }

            // Update the map with the current character's index.
            charMap.put(currentChar, end);

            // Calculate the length of the current window and update maxLength.
            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String input = "abcagcd";
        int ml = lengthOfLongestSubString(input);
        System.out.println("The length of the longest substring without repeating characters is: " + ml);


        int s=0,e=0,max=0,curr=0;

        HashMap< Character,Integer> hm=new HashMap<>();
        while(s<input.length() && e<input.length()){
            if(!hm.containsKey(input.charAt(e))){
                hm.put(input.charAt(e),1);
            }
            curr=hm.size();
            max=Math.max(curr, max);
            s++;
            e=s;
            hm.clear();
        }
    }








}