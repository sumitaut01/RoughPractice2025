package basics.javapgms.citi_preparation.pgms.whatsapp;

import org.testng.annotations.Test;

import java.util.LinkedHashMap;

public class Whatsapp {
    @Test
    public void demo_1(){

        //write a java program to find first non repeated character with one for loop and
        //without disturbing the space

        String str="software";
        LinkedHashMap<Character,Integer> lhm=new LinkedHashMap<>();
        for(Character c:str.toCharArray()){
            if(!lhm.containsKey(c)){
               lhm.put(c,1);
            }
            else{
                lhm.put(c, lhm.get(c)+1);
            }
        }
        System.out.println(lhm.entrySet().stream().filter(entry->entry.getValue()==1).findFirst().orElse(null));
    }

}
