package basics.collections.map;

import java.util.TreeMap;

public class TreeMapDemo {

    public static void main(String[] args) {
        //null wont be allowed

        TreeMap<String, String> tm = new TreeMap<>();
       // tm.put(null, null);//Exception in thread "main" java.lang.NullPointerException: Cannot invoke "java.lang.Comparable.compareTo(Object)" because "k1" is null

        tm.put("name","sumit");
        tm.put("age","35");
        System.out.println(tm);//{age=35, name=sumit}//alphabtical order of key



    }
}
