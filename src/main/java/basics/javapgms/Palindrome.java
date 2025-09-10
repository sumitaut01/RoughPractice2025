package basics.javapgms;
/*

A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.
Example 1:

Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.
Example 2:

Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.
Example 3:

Input: s = " "
Output: true
Explanation: s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.
 */
public class Palindrome {

    public static void main(String[] args) {
      String orig="A man, a plan, a canal: Panama".replaceAll("[^A-Za-z]", "");
      StringBuffer rev=new StringBuffer();
      for(int i=orig.length()-1;i>=0;i--){
          rev=rev.append(orig.charAt(i));
      }
        System.out.println(orig);
        System.out.println(rev);
        System.out.println(rev.equals(orig));//it gives false always as equals not written for content comparison in buffer
        //1) You're comparing different types (and StringBuffer.equals is not content-based)
        //
        //rev is a StringBuffer, orig is a String. StringBuffer does not override equals() to compare contents, so rev.equals(orig) just uses Object.equals (reference equality) and will always be false when comparing different objects/types.
        //
        //So even if their textual content matched, rev.equals(orig) would still be false.


        //Right Reason:
        System.out.println(rev.toString().equalsIgnoreCase(orig));//true
    }
}
