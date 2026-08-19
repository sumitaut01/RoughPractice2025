package basics.collections.rough;

import org.testng.annotations.Test;

import java.util.*;
import java.util.stream.Collectors;

public class Rough3 {



    @Test
    public void MapWork_01(){

        HashMap<String,String> hm=new HashMap<>();

        hm.put("Name","Sumit");
        hm.put("Branch","IT");
        System.out.println(hm);//{Branch=IT, Name=Sumit}

        //1
        for (String key:hm.keySet()){
            System.out.println(key+" : "+hm.get(key));
        }

        //2
        for (String value:hm.values()){
            System.out.println(value);
        }

        //3
        for (Map.Entry<String,String> entry:hm.entrySet()){
            System.out.println(entry.getKey()+" : "+entry.getValue());
        }

        //4
        hm.forEach((k,v)->System.out.println(k+ " "+v));

        //5

    }



    @Test
    public void SetWork_01() {

        Set<String> hs=new HashSet<>();

        System.out.println(hs.add("A"));//true
        System.out.println(hs.add("B"));//true
        System.out.println(hs.add("A"));//false

        System.out.println(hs.contains("A"));//true

        System.out.println(hs.remove("A"));//true
        System.out.println(hs.remove("A"));//false


        System.out.println(hs);//[B]
        System.out.println(hs.add("A"));//true
        System.out.println(hs.add("C"));//
        System.out.println(hs);//[A, B, C]


        hs.stream().forEach(s-> System.out.println(s));
        //A
        //B
        //C


        System.out.println(hs.stream().filter(s->s.startsWith("A")).collect(Collectors.toList()));






    }
    }

