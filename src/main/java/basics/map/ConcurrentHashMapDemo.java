package basics.map;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapDemo {

    public static void main(String[] args) {

        ConcurrentHashMap<String,String> chm=new ConcurrentHashMap<>();
       /* chm.put(null,null);
       //null not allowed
        System.out.println(chm);
        Exception in thread "main" java.lang.NullPointerException
        */


        chm.put("name", "sumit");
        chm.put("lastname", "raut");

        System.out.println(chm);


    }
}
