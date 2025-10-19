package basics.failfastfailsafe;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
//Fail-Fast iterators directly operate on the original collection and throw ConcurrentModificationException if the collection is modified during iteration (e.g., ArrayList, HashMap).
//
//Fail-Safe iterators work on a copy of the collection, so modifications don’t affect iteration (e.g., CopyOnWriteArrayList, ConcurrentHashMap).
//
//Fail-safe iterators are thread-safe but slower because of internal copying.


//Fail-Safe Iterators
//📌 Definition:
//
//A fail-safe iterator works on a clone (copy) of the collection,
//so structural modifications in the original collection don’t affect iteration.
//
//✅ Found in concurrent collections:
//CopyOnWriteArrayList, ConcurrentHashMap, etc
public class FailSafeExample {
    public static void main(String[] args) {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");

        Iterator<String> itr = list.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
            list.add("D"); // ✅ Allowed (iterates old snapshot)
        }

        System.out.println("Final List: " + list);


    //Notice:
    //
    //It didn’t throw an exception.
    //
    //The iterator used an internal copy (snapshot), so modifications happened on the actual list separately.

//    A
//            B
//    C
//    Final List: [A, B, C, D, D, D]


        //using ConcurrentHashMap
    Map<Integer, String> cmap = new ConcurrentHashMap<>();
        cmap.put(1, "A");
        cmap.put(2, "B");
        cmap.put(3, "C");

    Iterator<Integer> itr2 = cmap.keySet().iterator();

        while (itr.hasNext()) {
        Integer key = itr2.next();
        System.out.println("Key: " + key + ", Value: " + cmap.get(key));

        // Safe to modify while iterating
        cmap.put(4, "D");
    }

        System.out.println("Final Map: " + cmap);
}
}
