package basics.collections.map;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class LinkedHashMapDemo {

    public static void main(String[] args) {


       // LinkedHashMap<String,String> lhm=new LinkedHashMap<>();

        HashMap<String,String>  lhm=new LinkedHashMap<>();
        lhm.put("name","sumit");
        lhm.put("city","bhandara");
        lhm.put("course","it");
        System.out.println(lhm);//{name=sumit, city=bhandara, course=it}
    }
}
