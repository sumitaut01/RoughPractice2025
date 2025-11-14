package basics.map;

import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {

    public static void main(String[] args) {

        Map<String,String> hm=new HashMap<>();

        System.out.println(hm.put("name", "sumit"));//null
        System.out.println(hm.put("name", "sumit"));//Sumit
        System.out.println(hm.put("name", "sumitNew"));//sumit

        System.out.println(hm.containsValue("xx"));//false
        System.out.println(hm.containsValue("sumit"));//false
        System.out.println(hm.containsValue("sumitNew"));//true


        System.out.println(hm.containsKey("xx"));//false
        System.out.println(hm.containsKey("name"));//true

        System.out.println(hm.get("nonExiting"));//null




    }
}
