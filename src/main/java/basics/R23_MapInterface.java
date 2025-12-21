package basics;

import java.util.HashMap;
import java.util.Map;

public class R23_MapInterface {

    public static void main(String[] args) {
        Map<String,Integer> hm=new HashMap<>();
        System.out.println(hm.put("Sumit",35));//null if value added first time for the key
        System.out.println(hm.put("Sumit",36));//35 old value
        hm.put("Amit",40);
        hm.put("neha",31);


        System.out.println(hm.get("Sumit"));//35
        System.out.println(hm.containsKey("Sumit"));//true
        System.out.println(hm.getOrDefault("NewKey", 99));// adds 99 and returns
        System.out.println(hm.getOrDefault("NewKey", 98));//98

        System.out.println(hm.containsValue("nonexisting"));//false
        System.out.println(hm.containsValue(36));//true



    }
}
