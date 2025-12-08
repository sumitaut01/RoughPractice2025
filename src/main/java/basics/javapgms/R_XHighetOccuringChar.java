package basics.javapgms;

import java.util.Map;
import java.util.TreeMap;

public class R_XHighetOccuringChar {

    public static void main(String[] args) {

        String str="aaaaxxxxccdddvvvvvvvv";
        TreeMap<Character,Integer> tm=new TreeMap<Character,Integer>();

        for(Character ch:str.toCharArray()){
            tm.put(ch,tm.getOrDefault(ch,0)+1 );
        }
        int count=0;
        Character ch=null;
        for(Map.Entry<Character,Integer> en:tm.entrySet()){

            if(en.getValue()>count){
                count=en.getValue();
                ch=en.getKey();
            }
        }

        System.out.println(ch+"  "+ count);//v 8








    }
}
