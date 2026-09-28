package basics.javapgms.citi_preparation.pgms;

import org.testng.annotations.Test;

import java.util.*;

public class R_1 {

    public static String printDuplicateChar(String str) {
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            int count = 0;
            if (str.charAt(i) != ' ') {
                for (int j = i + 1; j < str.length(); j++) {
                    if (str.charAt(i) == str.charAt(j) && (i != j)) {
                        count++;
                    }
                }
                if (count == 1) {
                    result += str.charAt(i) + " ";
                }
            }
        }
        return result;
    }

    public static String printDuplicateCharAndCount(String str) {
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            int count = 1;
            if (str.charAt(i) != ' ') {
                for (int j = i + 1; j < str.length(); j++) {
                    if (str.charAt(i) == str.charAt(j) && (i != j)) {
                        count++;
                    }
                }
                if (count > 1) {
                    result += str.charAt(i) + " : " + count + "\n";
                }
            }
        }
        return result;
    }

    @Test
    public void Reverse1() {
//        1. Write a program to print the reverse of the String?
//        Ex: Nacre Output: ercaN

        String str = "Nacre";
        StringBuffer sb = new StringBuffer(str).reverse();
        System.out.println(sb);//ercaN

    }

    @Test
    public void Reverse2() {
//        1. Write a program to print the reverse of the String?
//        Ex: Nacre Output: ercaN
        String str = "Nacre";
        for (int i = str.length() - 1; i >= 0; i--) {
            System.out.print(str.charAt(i));//ercaN
        }
    }

    @Test
    public void FirstNonRepeated() {
        /*2. Write a program to print First non-repeated character from given String?
        Ex: Software Services
         Output: o
        */
        String str = "Software Services";
        for (int i = 0; i < str.length(); i++) {
            int count = 0;
            for (int j = 0; j < str.length(); j++) {
                if (String.valueOf(str.charAt(i)).equalsIgnoreCase(String.valueOf(str.charAt(j)))) {
                    count++;
                }
            }
            if (count == 1) {
                System.out.println(str.charAt(i));//0
                break;
            }
        }
    }

    @Test
    public void LastNonRepeating() {
/*
        3. Write a program to print last non-repeated character from given String?
        Ex: Software Services Output: c


 */
        String str = "Software Services";

        for (int i = str.length() - 1; i >= 0; i--) {
            int count = 0;
            for (int j = str.length() - 1; j >= 0; j--) {
                if (String.valueOf(str.charAt(i)).equalsIgnoreCase(String.valueOf(str.charAt(j)))) {
                    count++;
                }

            }
            if (count == 1) {
                System.out.println(str.charAt(i));//c
                break;
            }

        }

    }

    @Test
    public void removeDuplicateChar() {
        /*
        4. Write a program to remove the duplicate characters from the given String?
Ex: banaans Output: bans
         */
        String str = "banaans";
        String res = "";
        for (int i = 0; i < str.length(); i++) {
            if (res.indexOf(str.charAt(i)) == -1) {
                res = res + str.charAt(i);
            }
        }
        System.out.println(res);//bans
    }

    @Test
    public void occurences() {

        /*
        5. Write a program to count the number of occurrences of each character in a string?
Ex: apple
Output: a-1 p-2 l-1 e-1
         */

        String s = "apple";
        HashMap<Character, Integer> hm = new HashMap<>();

        for (Character c : s.toCharArray()) {
            hm.put(c, hm.getOrDefault(c, 0) + 1);
        }
        System.out.println(hm);//{p=2, a=1, e=1, l=1}
    }

    //Revisit
    @Test
    public void Duplicates() {

        /*
        Write a program to print duplicate characters from the given String?
Ex: Programming Output: r, g, m
         */

        String str = "Programmingr";
        //System.out.println(printDuplicateChar(str));

        for (int i = 0; i < str.length(); i++) {

            int count = 0;
            for (int j = i + 1; j < str.length(); j++) {

                if (str.charAt(i) == str.charAt(j)) {
                    count++;
                }
            }

            if (count == 1) {
                System.out.println(str.charAt(i));
            }
        }


    }

    //there is flaw in double loop
    //r : 3
    //g : 2
    //r : 2
    //m : 2
    @Test
    public void Dupllicatewithcount() {

        /*
        7. write a program to print all duplicate character and their count form the given String?
Ex: Programming Output: g: 2
r: 2
m: 2
CODE:
import java.util.Scanner;
public class
         */

        String str = "programmingr";

        System.out.println(printDuplicateCharAndCount(str));
    }

    @Test
    public void maxOccuring() {
/*
        8. Write a program to print Highest occurred character from given String?

                Ex: aaaaabbcddddd Output: a


 */

        String str = "aaaaabbcddddd";

        LinkedHashMap<Character, Integer> lhm = new LinkedHashMap<>();

        for (int i = 0; i < str.length(); i++) {
            if (!lhm.containsKey(str.charAt(i))) {
                lhm.put(str.charAt(i), 1);
            } else {
                lhm.put(str.charAt(i), lhm.get(str.charAt(i)) + 1);
            }
        }
        int max = 0;
        String out = "";
        for (Character c : lhm.keySet()) {

            if (lhm.get(c) > max) {
                max = lhm.get(c);
                out = c + " " + lhm.get(c);
            }
        }
        System.out.println(out);//a5

    }


    //easy
    @Test
    public void removeChar() {

        /*
        9. Write a program to remove the given Character from the given String?
Ex: nacre Software
Remove character: a
Output: ncre Softwre
         */
    }


    @Test
    public void containsDigit() {
      /*
    10. Write a program to whether check given string contains digits or not?
     */

        //Character.isDigit("");

//        10. Write a program to whether check given string contains digits or not?
//        Ex: nacre123

        String str = "nacre123";
        System.out.println(str.matches(".*\\d.*"));//true

        String str2 = "nas$";
        System.out.println(str2.matches(".*\\d.*"));//false


        for (int i = 0; i < str.length(); i++) {

            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {

                System.out.println("Number found");
                System.out.println(str.charAt(i));
                /*
                Number found
1
Number found
2
Number found
3
                 */
            }
        }

    }


    @Test
    public void containsSpacialChar() {


        //'0'  '9'
        //'a'  'z'
        //'A' 'Z'
        String str = "naz$x";
        String str2 = "naz";
        System.out.println(str.matches("[a-zA-Z0-9]"));//false
        System.out.println(str.matches(".*[^a-zA-Z0-9].*"));//true
        System.out.println(str2.matches(".*[^a-zA-Z0-9].*"));//false


    }


    @Test
    public void isVowelsPResent() {

        /*
        12. Write a program to whether check given string contains vowels or not?
Ex: nacre123
Output: Given String Contains vowels
         */


        String str = "nacre123";

        String ref = "aeiouAEIOU";

        for (int i = 0; i < str.length(); i++) {
            if (ref.indexOf(str.charAt(i)) > -1) {
                System.out.println(str.charAt(i));// a e
            }
        }
    }


    @Test
    public void countAllTypes() {

        /*
        13. Write a program to count the characters, digits and Special Characters from the given String?
Ex: Nacre@123%
Output: Characters are 5
Special Characters are 2
Digits are 3
         */

        int numberCOunt = 0;
        int spclCharCount = 0;
        int alphacount = 0;


        //'a'  'z'
        //'0'  '


        //Character.isDigit()
        //Character.isLetter()


    }


    @Test
    public void CapitalSmall() {

        /*
        14. Write a program to count the Capital letters and Small letters from the given String?
Ex: Nacre Software
same loigc
         */
    }


    @Test
    public void consonants() {
//        15. Write a program to count the consonants and vowels from the given String?
//                Ex: Nacre
//        Output: Vowels are 2
//        Consonants are 3

    }


    @Test
    public void percentagechars() {
        //16. Write a program to find the percentages of characters, Digits and Special characters from the given String?

    }


    //Revisit
    @Test
    public void sortString() {
      /*

      19. Write a program to sort the given String?
Ex: nacre
Output: acenr

//avinash
//aahinsv
       */

        String str = "avinash";

        char[] arrCh = str.toCharArray();
        System.out.println(Arrays.toString(arrCh));
        for (int i = 0; i < arrCh.length - 1; i++) {
            for (int j = i + 1; j < arrCh.length; j++) {
                if ((int) arrCh[i] > (int) arrCh[j]) {
                    char temp = arrCh[j];
                    arrCh[j] = arrCh[i];
                    arrCh[i] = temp;
                }
            }
        }
        System.out.println("After Sorting");
        System.out.println(Arrays.toString(arrCh));

        /*
        [a, v, i, n, a, s, h]
After Sorting
[a, a, h, i, n, s, v]
         */


    }


    @Test
    public void anagramCheck() {

        /*
        20. Write a program to Check whether two given Strings are anagram or not?
Ex: Str1= reaction Str2: creation
Output: Two Strings are anagrams
         */
        String str1 = "reaction";
        String str2 = "creationy";

        if (str1.length() != str2.length()) {
            System.out.println("not equal");
            return;
        }

        int[] arr1 = new int[256];
        int[] arr2 = new int[256];

        for (int i = 0; i < str1.length(); i++) {
            arr1[(int) str1.charAt(i)]++;
            arr2[(int) str2.charAt(i)]++;
        }

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != 0) {
                System.out.println((char) arr1[i]);
                System.out.println((char) arr2[i]);
            }
        }

        System.out.println(Arrays.equals(arr1, arr2));//true

    }


    @Test
    public void CountParticular() {
    /*
   Ex: Today is Monday
Given Character a
Output: given character a occurrence is 2 times
     */
        String str1 = " Today is Monday";
        //simple loop +count


    }


    @Test
    public void replacepaerticular() {

        /*
        Write a program to replace given character to other given Character in the string?
        Enter String:
This is giil
Enter char to replace:
i
Enter string to replace with:
#
Th#s #s g##l
         */
    }


    @Test
    public void palindromeCheck() {

        /*
        23. Write a program to Whether Given String is palindrome String or not?
        Enter string to check:
madam
It's Palindrome!
         */


        String str = "madam";

        String rev = "";

        for (int i = str.length() - 1; i >= 0; i--) {
            rev += str.charAt(i);
        }

        if (str.equalsIgnoreCase(rev)) {
            System.out.println("palindrome");
            return;
        }
        System.out.println("not palindrome");
    }

    @Test
    public void reveser() {
        /*
        24. Write a Program to reverse words in a given String?
Ex: "Java is best programming language"
Output "language programming best is Java".
         */


        String str1 = "Java is best programming language";

        for (int i = str1.split(" ").length - 1; i >= 0; i--) {
            System.out.print(str1.split(" ")[i] + " ");
            //language programming best is Java
        }

    }


    @Test
    public void reverseonplace() {
        /*
        25. Write a program to reverse Words of the Given String?
Ex: "Today is Monday"
Output: yadoT si yadnoM
         */


        String str = "Today is Monday";
        String[] arrStr = str.split(" ");
        for (String s : arrStr) {
            for (int i = s.length() - 1; i >= 0; i--) {
                System.out.print(s.charAt(i));
            }
            System.out.print(" ");
        }
        //yadoT si yadnoM
    }


    @Test
    public void swapFL() {

        /*
        29. Swap first and last charecter of a given String
input:- NacrE Output:-EacrN
         */

        String str = "NacrE";

        String ans = "";
        for (int i = 0; i < str.length(); i++) {

            if (i == 0) {
                ans += str.charAt(str.length() - 1);
            } else if (i == str.length() - 1) {
                ans += str.charAt(0);
            } else {
                ans += str.charAt(i);
            }

        }

        System.out.println(ans);//EacrN


    }


    @Test
    public void removeDuplicates() {
        /*
        Enter String:
Aabccdeeef
Aabcdef
         */
        String str = "Aabccdeeef";
        String fin = "";
        for (int i = 0; i < str.length(); i++) {
            if (fin.indexOf(str.charAt(i)) == -1) {
                fin += str.charAt(i);
            }
        }
        System.out.println(fin);//Aabcdef
    }


    @Test
    public void array2nd() {
/*
31. Display 2nd highest number from array.
 */

    }

    //revisit
    @Test
    public void permutation() {


        /*
        write a program of permutation.
        input:- "abc"
output:-abc,acb,bac,bca,cab,cba
         */


        String str="abc";
        String ans="";
        permute(str,ans);

        /*
        abc
acb
bac
bca
cab
cba
         */


    }

    static void permute(String str,String ans){
        if(str.length()==0){
            System.out.println(ans);
            return;
        }
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            String rem=  str.substring(0,i) + str.substring(i+1);
            permute(rem,ans+ch);
        }

    }


    @Test
    public void clockwise() {
       /*
       33. program of clockwise and anticlockwise
Input clockwise Output:
        1 2 3 7 4 1
        4 5 6 8 5 2
        7 8 9 9 6 3
        */


    }


    @Test
    public void antiClickwise() {

//        34. program of anticlockwise
//        Input anticlockwise Output:
//        1 2 3 3 6 9
//        4 5 6 2 5 8
//        7 8 9 1 4 7
    }


    @Test
    public void sortArray() {
     /*
     35. write a program to sort array like
input :- int array [] = {1,2,3,4,5,6,7,8,9,10}
output:- 1, 10, 2, 9, 3, 8, 4, 7, 5, 6

len 10
arr[9]= arr[2]
arr[0] arr [0]

10/9  =1

10/8 2
      */

    }


    //SDet SET

    @Test
    public void palindrome() {
        String str = "madam";
        StringBuffer sb = new StringBuffer(str).reverse();

        if (str.equalsIgnoreCase(str)) {
            System.out.println("palindrome");
            return;
        }
        System.out.println("not palindrome");

    }


    @Test
    public void Fibonacci() {


    }


    @Test
    public void fact() {
        System.out.println(Factorial(5));//120
    }

    public static int Factorial(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n * Factorial(n - 1);
        }
    }


    @Test
    public void PrimeCheck() {

        int n = 17;

        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                System.out.println("not a prime number");
            } else {
                System.out.println("prime number as" + n + "can be divided by " + i);
            }
        }
    }


    @Test
    public void ArraysSort() {

        Integer arr[] = {1, 5, 6, 0};
        System.out.println(Arrays.toString(arr));//[1, 5, 6, 0]

        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));//[0, 1, 5, 6]

        Arrays.sort(arr, Comparator.reverseOrder());
        System.out.println(Arrays.toString(arr));//[6, 5, 1, 0]


        Arrays.sort(arr, (a, b) -> a.compareTo(b));
        System.out.println(Arrays.toString(arr));//[0, 1, 5, 6]

        Arrays.sort(arr, (a, b) -> -a.compareTo(b));
        System.out.println(Arrays.toString(arr));//[6, 5, 1, 0]


    }


    @Test
    public void MergeArrays() {

        //System.arraycopy(source, sourcePos,
        //                 destination, destPos,
        //                 length);
        int[] arr1 = {1, 3, 5};
        int[] arr2 = {2, 4, 6};
        int[] merged = new int[arr1.length + arr2.length];
        System.arraycopy(arr1, 0, merged, 0, arr1.length);
        System.arraycopy(arr2, 0, merged, arr1.length, arr2.length);

    }

    @Test
    public void LargestInArray() {
        int[] arr = {1, 3, 5, 7, 9};
        int largest = arr[0];
        for (int num : arr) {
            if (num > largest) {
                largest = num;
            }
        }
        System.out.println(largest);
    }

    @Test
    public void RemoveDuplicates() {
        //hashset


    }


    @Test
    public void ArmStrong() {
//  math.pow(digit,3)

        int num = 153;
        int sum = 0;

        while (num > 0) {
            int rem = num % 10;
            sum += rem * rem * rem;
            num = num / 10;
        }
        System.out.println(sum);//153

    }

    @Test
    public void NumReverse() {


    }

    //revist
    @Test
    public void GCD() {


    }


    @Test
    public void PrimeNumbersinRange() {

        int n = 17;

        System.out.println(Math.sqrt(n));
        // we check upto sqrt and if result found then exit
        //no need to check till

        for (int i = 2; i < Math.sqrt(n); i++) {

            if (n % i == 0) {
                System.out.println("prime");
                return;
            }
        }
        System.out.println("not a prime");

    }

    @Test
    public void SwapNumbers() {
        int a = 10;
        int b = 30;
        a = a + b;//40
        b = a - b; //4-/30=10
        a = a - b;  // 40-10;
    }


    //Revisit
    /*
             1
           1   1
         1   2   1
       1   3   3   1
     1   4   6   4   1
     */
    @Test
    public void pascalTriangle() {

        int rows = 5;
        for (int i = 0; i < rows; i++) {
            int num = 1;
            System.out.format("%" + (rows - i) * 2 + "s", "");
            for (int j = 0; j <= i; j++) {
                System.out.format("%4d", num);
                num = num * (i - j) / (j + 1);
            }
            System.out.println();
        }
    }


    //DecimalToBinary
    @Test
    public void DecimalToBinary() {
        int num = 10;
        String binary = Integer.toBinaryString(num);
        System.out.println(binary);//1010

    }

    @Test
    public void firstNonRepeatedChar(){

        //First Non-Repeated Character in a String
        //swiss  w

        String str="swiss";
        LinkedHashMap<Character,Integer> lhm=new LinkedHashMap<>();

        for(Character c:str.toCharArray()){

            if(lhm.containsKey(c)){
                lhm.put(c, lhm.get(c)+1);
            }
            else{
                lhm.put(c, 1);
            }
        }

        for(Character c: lhm.keySet()){
            if(lhm.get(c)==1){

                System.out.println(c + " "+lhm.get(c));//w1
                return;
            }
            else{
                System.out.println("no singles");
            }
        }
    }


    @Test
    public void removeAllWhiteSpaces(){
        String str = " A u t o m a t i o n ";
        String result = str.replaceAll("\\s+", "");
        System.out.println(result);//Automation
    }

    @Test
    public void CommonInArrays(){
        int[] arr1 = {1, 2, 3, 4};
        int[] arr2 = {3, 4, 5, 6};
    }

    @Test
    public void bubbleSort(){


    }


    @Test
    public void LinerSort(){


    }


    @Test
    public void missingNumber(){
        int[] arr = {1, 2, 4, 5, 6};
        int n=arr.length+1;//6
        int expectedSum=n*(n+1)/2;
        int actualSum=0;
        for (int num : arr) {
            actualSum += num;
        }
        System.out.println("Missing Number = " + (expectedSum - actualSum));//3
    }


    @Test
    public void longest_sub_withoutrepeating(){

        //Java program to find the longest without repeating characters
        String s1 = "abcabcbb"; // Expected: "abc", length 3

        //a  i    j i
        //str max  str len
        //curren

        String temp="";
        for(int i=0;i<s1.length();i++){
          int curr=0;
          int max=0;
          for(int j=i;i<s1.length();j++){

             if(temp.indexOf(s1.charAt(j)==--1))
              {
                  temp = temp + s1.charAt(j);
                  curr++;
              }
          }

        }
    }

}




