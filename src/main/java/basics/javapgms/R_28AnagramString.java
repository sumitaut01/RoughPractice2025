package basics.javapgms;


// add in hashmap
//add string int
//then deduct ahsmap


//listen,silent

import java.util.HashMap;

public class R_28AnagramString {


    public static void main(String[] args) {

        String s1 = "listen";
        String s2 = "silent";

        HashMap<Character, Integer> hm = new HashMap<>();
        for (Character c : s1.toCharArray()) {
            if (hm.containsKey(c)) {
                hm.put(c, hm.get(c) + 1);
            } else {
                hm.put(c,1);//{s=1, t=1, e=1, i=1, l=1, n=1}
            }
        }
        System.out.println(hm);
        for (Character c : s2.toCharArray()) {
            if (hm.containsKey(c)) {
                hm.put(c, hm.get(c) - 1);
            }
        }

        System.out.println(hm); //
        //{s=0, t=0, e=0, i=0, l=0, n=0}

    }
}
