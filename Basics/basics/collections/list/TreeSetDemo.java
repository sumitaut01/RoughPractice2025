package basics.collections.list;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetDemo {
    public static void main(String[] args) {

//✅ What is it?
//                A TreeSet is a sorted set implemented using a self-balancing binary search tree (Red-Black Tree).
//
//                Maintains elements in sorted (ascending) order by default.
//
//        You can pass a custom comparator for custom sorting.
//
//        Slower than HashSet and LinkedHashSet for basic operations.
//
//        Features of TreeSet
//        Feature	Value
//        Maintains order?	✅ Yes (sorted order)
//        Allows duplicates?	❌ No
//        Performance	⏱️ Slower — O(log n) operations
//        Null values	❌ Not allowed (throws exception)

        Set<String> str=new TreeSet<>();
        str.add("sumit");
        str.add("neha");
        str.add("amit");
        str.add("juhi");
        //null not allowed.. will throw exception
       // str.add(null);//xception in thread "main" java.lang.NullPointerException
        //at java.base/java.util.Objects.requireNonNull(Objects.java:233)

        System.out.println(str);//[amit, juhi, neha, sumit]
    }
}
