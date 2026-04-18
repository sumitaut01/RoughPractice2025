package basics.javapgms;

import org.testng.annotations.Test;

import java.io.CharConversionException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeatingChar {

    public static void main(String[] args) {

        String str="aabbcdefcac";  // o/p d1

        LinkedHashMap<Character,Integer> hm=new LinkedHashMap<>();
        for(Character ch: str.toCharArray()){
           hm.put(ch,hm.getOrDefault(ch,0)+1);
        }

        System.out.println(hm);//{a=3, b=2, c=3, d=1, e=1, f=1}

        for(Character c: hm.keySet()){
           if(hm.get(c)==1){
               System.out.println(c+" "+hm.get(c));//d 1
               break;
           }
        }
    }




    @Test
    public void Rough(){
        String str="aabbcdefcac";  // o/p d1

        LinkedHashMap<Character,Integer> lhm=new LinkedHashMap<>();
        for ( Character c:str.toCharArray()){
            lhm.put(c, lhm.getOrDefault(c,0)+1);
        }

        for(Map.Entry<Character,Integer> e: lhm.entrySet()){

            if(e.getValue()==1){
                System.out.println(e);
                break;
            }
            }
        }
    }

