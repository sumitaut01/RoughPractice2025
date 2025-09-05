package basics.javapgms;
/*
Write a function to find the longest common prefix string amongst an array of strings.
If there is no common prefix, return an empty string "".
Example 1:
Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:
Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
 */

public class R32_LongestCommonPrefix {
    public static void main(String[] args) {

        longest(new String[]{"flower", "flow", "flight"});

    }


    public static String longest(String[] str) {
        String prefix=str[0];
        for(int i=1;i<str.length;i++){
            while(!str[i].startsWith(prefix)){
                prefix=prefix.substring(0,prefix.length()-1);
                if(prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }
}
