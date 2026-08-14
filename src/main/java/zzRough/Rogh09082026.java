package zzRough;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class Rogh09082026 {

    @Test
    public void Test(){

        System.out.println("hi");


        HashMap<Integer,Integer> hm=new HashMap<>();

        hm.put(1, 1);
        hm.put(2, 2);
        hm.put(3, 3);
        hm.forEach((k,v)-> System.out.println(k+" "+v));

        for(Integer i: hm.keySet()){
            System.out.println(hm.get(i));
        }

       Map<String,String> hm2= Map.of("Name","sumit","College","kits");
        System.out.println(hm2);

        for(String i: hm2.keySet()){
            System.out.println(hm2.get(i));
        }

    }
}
