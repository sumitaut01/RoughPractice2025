package basicsold.collections.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapDemo {
//    A HashMap stores key-value pairs, where:
//    Keys must be unique
//    Each key maps to one value
//    Allows one null key, and multiple null values
//    Unordered by default

    //Internal Data Structure
    //At its core, HashMap uses:
    //Array of Buckets → Each Bucket is a Linked List (or Tree if too many entries)

//    Each entry is a Map.Entry<K, V> with:
//    Key Value
//    Hash of key
//    Reference to next node (for chaining)

    //How HashMap Stores Data — Step by Step
    //Let’s say you do:
    //map.put("Apple", 10);
    //1. Compute Hash Code
    //int hash = "Apple".hashCode(); // e.g. 63062875
    //2. Convert to Bucket Index
    //index = hash % table.length
    //(usually done more efficiently using bitwise operations)
    //3. Check the Bucket
    //If bucket is empty → place new Node
    //
    //If not empty → go through the chain (linked list/tree)
    //
    //Use .equals() to check for duplicate key
    //
    //If match → replace value
    //
    //Else → append at end
    //
    //4. Resize When Needed
    //If size >= loadFactor * capacity → internal array is doubled and all entries rehashed


    public static void main(String[] args) {

        Map<String,String> hm=new HashMap<>();
        hm.put("name","sumit");
        hm.put("college","kits");

        //1
        System.out.println(hm);//{college=kits, name=sumit}

        //2
        hm.forEach((k,v)-> System.out.println(k+" "+v));
        //college kits
        //name sumit

        //3

       Set<Map.Entry<String,String>> es= hm.entrySet();
        for (Map.Entry<String, String> e : es) {
            System.out.println(e.getKey()+ "=>"+e.getValue());
//            college=>kits
//            name=>sumit
        }


        //
        Set<String> ks=hm.keySet();

        ks.forEach(k-> System.out.println(k+"====>"+hm.get(k)));
        //college====>kits
        //name====>sumit







    }


}
