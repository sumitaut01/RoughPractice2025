package basics.streams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class R5_Rough {

    public static void main(String[] args) {

        List<String> sNames=new ArrayList<>();
        System.out.println(sNames.add("Sumit"));//true
        System.out.println(sNames.remove("Sumit"));//true
        System.out.println(sNames.remove("Sumit"));//false
        System.out.println(sNames.remove("non existing"));//false
        System.out.println(sNames.add("Sumit"));//true
        System.out.println(sNames.add("Neha"));//true
        System.out.println(sNames.add("Amit"));//true
        System.out.println(sNames.add("Zikaria"));//true
        System.out.println(sNames.set(0,"Sumit Replaced"));//Sumit
       // System.out.println(sNames.set(10,"Non existing index"));//java.lang.IndexOutOfBoundsException


        sNames.stream()
                .filter(s->s.length()>5)
                .map(String::length)
                .collect(Collectors.toList())
                .forEach(System.out::println);
        //14 7



        List<HashMap<String,String>> lhm=new ArrayList<>();

        HashMap<String,String> l1=new HashMap<>();
        l1.put("name", "sumit");


        HashMap<String,String> l2=new HashMap<>();
        l2.put("name", "neha");
        lhm.add(l1);
        lhm.add(l2);



        var x=lhm.stream().filter(l->l.containsValue("sumit"))
                .collect(Collectors.toList());

        System.out.println(x);



       // lhm.stream().collect(Collectors.toMap((a,b)->a.containsValue("Sumit"),a->a));











    }
}
