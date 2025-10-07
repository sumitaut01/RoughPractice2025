package basics.failfastfailsafe;

import java.util.*;
//Fail-Fast iterators directly operate on the original collection and throw ConcurrentModificationException if the collection is modified during iteration (e.g., ArrayList, HashMap).
//
//Fail-Safe iterators work on a copy of the collection, so modifications don’t affect iteration (e.g., CopyOnWriteArrayList, ConcurrentHashMap).
//
//Fail-safe iterators are thread-safe but slower because of internal copying.
public class FailFastExample {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");

        Iterator<String> itr = list.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
            list.add("D"); // ❌ Structural modification
        }
    }


//    A
//    Exception in thread "main" java.util.ConcurrentModificationException
//    at java.base/java.util.ArrayList$Itr.checkForComodification(ArrayList.java:1095)
//    at java.base/java.util.ArrayList$Itr.next(ArrayList.java:1049)
//    at basics.failfastfailsafe.FailFastExample.main(FailFastExample.java:14)
}
