package basics.collections.list;

import java.sql.SQLOutput;
import java.util.HashSet;
import java.util.Set;

//A Set is a collection that does not allow duplicate elements.
//
//        It models the mathematical set abstraction — no repeated elements, and element order may not matter.
//
//        ✅ Key Set Implementations
//        Type	Maintains Order?	Allows Duplicates?	Backed By
//        HashSet	❌ No	❌ No	Hash table
//        LinkedHashSet	✅ Insertion Order	❌ No	Hash table + linked list
//        TreeSet	✅ Sorted (natural/comparator)	❌ No	Red-black tree (BST)


//Let’s Focus on HashSet
//        🔧 Internal Working
//        Uses a hash table
//        Elements are hashed to a bucket
//        No ordering is guaranteed
//        Duplicates are silently ignored


//Common Operations
//        Method	Return Type	Description
//        add(E e)	boolean	Adds an element (if not already present)
//        remove(Object o)	boolean	Removes the element if it exists
//        contains(Object o)	boolean	Checks if element exists
//        isEmpty()	boolean	True if set is empty
//        size()	int	Number of elements in set
//        clear()	void	Removes all elements


//Behind the Scenes
//        When you do:
//
//        set.add("Apple");
//        Computes the hash code of "Apple"
//        Finds a bucket in the internal array
//        Stores the element if not already present in that bucket
//        ⚠️ Therefore:
//        Performance is O(1) average case for add, remove, contains
//        But no ordering is preserved

//Summary
//        Feature	HashSet
//        Duplicate allowed?	❌ No
//        Order maintained?	❌ No
//        Null allowed?	✅ One null element allowed
//        Thread-safe?	❌ No
//        Performance	✅ Fast (O(1) operations)


public class SetDemo {

    public static void main(String[] args) {

        Set<String> hs=new HashSet<>();
        System.out.println(hs.add("First"));//true
        System.out.println(hs.add("Second"));//true
        System.out.println(hs.add("Second"));//false

        for(String s:hs){
            System.out.println(s);
            //Second
            //First
        }


        hs.forEach(s-> System.out.println(s));
        //Second
        //First

        //
       hs.forEach(System.out::println);


        hs.stream().forEach(s-> System.out.println(s));
        //Second
        //First

    }
}
