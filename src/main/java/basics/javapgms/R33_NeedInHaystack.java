package basics.javapgms;

/*

28. Find the Index of the First Occurrence in a String
Solved
Easy
Topics
premium lock icon
Companies
Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.



Example 1:

Input: haystack = "sadbutsad", needle = "sad"
Output: 0
Explanation: "sad" occurs at index 0 and 6.
The first occurrence is at index 0, so we return 0.
Example 2:

Input: haystack = "leetcode", needle = "leeto"
Output: -1
Explanation: "leeto" did not occur in "leetcode", so we return -1.
 */
public class R33_NeedInHaystack {


    public static void main(String[] args) {
        String str1="aadbutsad";
        String str2="sad";

        for(int i=0;i<str1.length();i++){
            if(str1.substring(i,i+1).equals(str2.substring(0,1))){

               if(str1.substring(i,i+3).equals(str2)){
                   System.out.println(i);
                   return;
               }
               else{
                  i=i+3;
                }
            }
        }







    }
}
