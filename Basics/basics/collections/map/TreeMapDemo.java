package basics.collections.map;

import java.util.Comparator;
import java.util.TreeMap;

public class TreeMapDemo {

    public static void main(String[] args) {
        //null wont be allowed

        TreeMap<String, String> tm = new TreeMap<>();
       // tm.put(null, null);//Exception in thread "main" java.lang.NullPointerException: Cannot invoke "java.lang.Comparable.compareTo(Object)" because "k1" is null

        tm.put("name","sumit");
        tm.put("age","35");
        System.out.println(tm);//{age=35, name=sumit}//alphabtical order of key



        TreeMap<String, String> tm2 = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return -( o1.length()-o2.length());
            }
        });


        tm2.put("1234","sumit");
        tm2.put("123","35");
        tm2.put("12345","35");

        System.out.println(tm2);
       // {123=35, 1234=sumit, 12345=35}//o1.length()-o2.length()

        //{12345=35, 1234=sumit, 123=35}//return -( o1.length()-o2.length());




    }
}
