package basics.collections.map;

import java.util.Hashtable;

public class HashtableDemo {
    //Legacy
    //Thread Safe hence slow.
    // Concurrent Hashmap should be used in newer implementations

    public static void main(String[] args) {

        Hashtable<String,String> ht=new Hashtable<>();
        ht.put("Sumit", "It");
        ht.put("Neha", "EC");

        System.out.println(ht.get("random"));//null

        System.out.println(ht.get("Sumit"));//It

        System.out.println(ht);//{Neha=EC, Sumit=It}

        ht.forEach((k,v)-> System.out.println(k+" =>"+v));

        //exception thrown if its null is used in key or value
        ht.put("xx",null);
        ht.put(null,"xyz");

//        Exception in thread "main" java.lang.NullPointerException
//        at java.base/java.util.Hashtable.put(Hashtable.java:476)
//        at basics.collections.map.HashtableDemo.main(HashtableDemo.java:20)

        //Maps the specified key to the specified value in this hashtable. Neither the key nor the value can be null.
        //The value can be retrieved by calling the get method with a key that is equal to the original key.
    }




}
