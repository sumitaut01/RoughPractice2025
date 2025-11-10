package basics;

import java.util.StringJoiner;
import java.util.concurrent.ConcurrentHashMap;

public class R_XConcurrentHashMap {
    public static void main(String[] args) {
        //thread safe hashmap
        // different locking mechanism

        ConcurrentHashMap<String, String> chm=new ConcurrentHashMap<>();

        chm.put("Name", "Sumit");
        chm.put("LastName", "Raut");

        System.out.println(chm);//{LastName=Raut, Name=Sumit}

        ConcurrentHashMap<String, String> chm2=new ConcurrentHashMap<>();

        chm2.put("New", "Neha");

        chm.putAll(chm2);
        System.out.println(chm);//{New=Neha, LastName=Raut, Name=Sumit}


        //Notice one thing, unlike hashmap, one null key is NOT allowed in concurrent hashmap
      //  chm.put(null,null);
       // System.out.println(chm);//Exception in thread "main" java.lang.NullPointerException







    }
}
