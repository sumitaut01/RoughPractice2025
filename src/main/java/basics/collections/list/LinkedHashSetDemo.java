package basics.collections.list;

import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSetDemo {
//    A LinkedHashSet is a hash table + linked list implementation of the Set interface.
//
//    It maintains the insertion order of elements.
//
//            Internally, it works like a HashSet, but also keeps a linked list of the entries.


    public static void main(String[] args) {

        Set<String> str=new LinkedHashSet<String>();

        str.add("sumit");
        str.add("neha");
        str.add("amit");
        str.add("juhi");
        str.add(null);//one null aloowed

        System.out.println(str);//[sumit, neha, amit, juhi]






        LinkedHashSet<String> lst=new LinkedHashSet<>();

        System.out.println(lst.size());
        System.out.println(lst.isEmpty());

        lst.addFirst("A");
        lst.addLast("Z");

        System.out.println(lst);//[A, Z]

        lst.removeLast();
        System.out.println(lst);//[A]

        System.out.println(lst.removeLast());
        System.out.println(lst.removeLast());//Exception in thread "main" java.util.NoSuchElementException




    }
}
