package basics.collections.rough;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Rough4 {

    @Test
    public void HashMap(){
        Map<String,String> hm=new HashMap<>();
        hm.put("name","Sumit");//null
        hm.put("name","Sumit");//sumit
        hm.put("college","Kits");
        hm.put("name","sumit");//Sumit   -- old value
        for(Map.Entry<String,String> es:hm.entrySet()){
            System.out.println(es.getKey() +"  "+es.getValue());
        }
        //
        for(String s:hm.keySet()){
            System.out.println(hm.get(s));
        }
    }


    @Test
    public void Hashset() {

     Set<String> hs=new HashSet<>();

        System.out.println(hs.add("sumit"));//true
        System.out.println(hs.add("sumit"));//false
        System.out.println(hs.remove("neha"));//false
        System.out.println(hs.add("neha"));//true

        System.out.println("via loop");
        for(String s:hs){
            System.out.println(s);
        }

        //
        System.out.println("via for each ");
        hs.forEach(s-> System.out.println(s));

        //
        System.out.println("via stream");
        hs.stream().forEach(s-> System.out.println(s));
    }
    }

