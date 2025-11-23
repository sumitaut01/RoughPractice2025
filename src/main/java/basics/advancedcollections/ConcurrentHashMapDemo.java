package basics.advancedcollections;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapDemo {

    public static void main(String[] args) {


        ConcurrentHashMap<String,String> cm=new ConcurrentHashMap<>();
        cm.put("name", "sumit");
        cm.put("degree", "be");
        //cm.put(null,null);//Exception in thread "main" java.lang.NullPointerException


       // cm.entrySet();
       // cm.keys();




    }
}
