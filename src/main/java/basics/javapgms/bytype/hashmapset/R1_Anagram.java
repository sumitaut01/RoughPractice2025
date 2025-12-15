package basics.javapgms.bytype.hashmapset;


import org.testng.annotations.Test;

import java.util.HashMap;

//admirer
//married
// put it in hashmap and give some count
public class R1_Anagram {
    public static void main(String[] args) {

        String str1 = "admirer";
        String str2 = "married";

        // A quick and early check for different string lengths.
        if (str1.length() != str2.length()) {
            System.out.println("Not anagrams");
            return;
        }

        HashMap<Character, Integer> hm = new HashMap<>();

        // Loop 1: Count character frequencies in the first string.
        for (int i = 0; i < str1.length(); i++) {
            char currentChar = str1.charAt(i);
            hm.put(currentChar, hm.getOrDefault(currentChar, 0) + 1);
        }

        System.out.println("After filling str1 " + hm);

        // Loop 2: Decrement counts for characters in the second string.
        for (int j = 0; j < str2.length(); j++) {
            char currentChar = str2.charAt(j);

            // If character isn't found or its count is already zero, it's not an anagram.
            if (!hm.containsKey(currentChar) || hm.get(currentChar) == 0) {
                System.out.println("Not anagrams");
                return;
            }
            // Decrement the count.
            hm.put(currentChar, hm.get(currentChar) - 1);
        }

        System.out.println("After filling str2 " + hm);

        // Final check: All counts in the map must be zero.
        for (int count : hm.values()) {
            if (count != 0) {
                System.out.println("Not anagrams");
                return;
            }
        }

        // If the code reaches here, it means all checks passed.
        System.out.println("Anagrams!");
    }





    @Test
    public void Rough(){

        String str1 = "admirer";
        String str2 = "married";

        HashMap<Character,Integer> hm=new HashMap<>();
        for(Character c:str1.toCharArray()){
          hm.put(c,hm.getOrDefault(c,0)+1);
        }

        System.out.println(hm);//{a=1, r=2, d=1, e=1, i=1, m=1}

        for(Character c2:str2.toCharArray()){

           if(!hm.containsKey(c2) || (hm.get(c2)==0)){
               System.out.println(c2+ " not present in ");
               return;
           }

           else{
               hm.put(c2,hm.get(c2)-1 );
           }
        }

        for(Integer i:hm.values()){
            if(i!=0){
                System.out.println("not an anagram");
            }
        }


       //it will be 0 if anagram
        System.out.println(hm);//{a=0, r=0, d=0, e=0, i=0, m=0}




    }
}
