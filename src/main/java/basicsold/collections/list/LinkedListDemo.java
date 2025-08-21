package basicsold.collections.list;

//What is LinkedList?
//        LinkedList is a doubly-linked list data structure that implements List, Deque, and Queue interfaces.
//        Each element is stored in a node that contains:
//        The data A reference to the next node
//A reference to the previous node


//Basic Operations
//        1. Add Elements
//
//        names.add("Sumit");             // adds to end
//        names.addFirst("Start");        // adds at the beginning
//        names.addLast("End");           // adds at the end
//        2. Remove Elements
//
//        names.remove();                 // removes from head (like queue)
//        names.removeFirst();            // removes from start
//        names.removeLast();             // removes from end
//        3. Get Elements
//
//        names.get(0);                   // access by index
//        names.getFirst();               // first element
//        names.getLast();                // last element
//        4. Search
//
//        names.contains("Sumit");        // true or false
//        5. Size and Clear
//
//        names.size();                   // number of elements
//        names.clear();                  // removes all


import java.util.LinkedList;

//Internal Working (Compared to ArrayList)
//        Feature	ArrayList	LinkedList
//        Backing structure	Dynamic array	Doubly linked list
//        Access by index	✅ Fast (O(1))	❌ Slow (O(n)) — must traverse
//        Insert/remove at end	✅ Fast (Amortized O(1))	✅ Fast (O(1))
//        Insert/remove at start	❌ Slow (shifting needed)	✅ Fast (O(1))
//        Insert in middle	❌ Costly (shifts needed)	✅ Moderate (just re-link nodes)
//        Memory usage	Compact	More (stores 2 pointers/node)
public class LinkedListDemo {
    public static void main(String[] args) {

        LinkedList<String> linkedList=new LinkedList<>();

        linkedList.add("Sumit");
        linkedList.add("Amit");
        System.out.println(linkedList);//[Sumit, Amit]

        linkedList.addFirst("First");
        linkedList.addLast("Last");
        System.out.println(linkedList);//[First, Sumit, Amit, Last]


        System.out.println(linkedList.getFirst());//First
        System.out.println(linkedList.getLast());//Last

        System.out.println(linkedList.removeFirst());//First
        System.out.println(linkedList.removeLast());//Last

        System.out.println(linkedList);//[Sumit, Amit]


    }
}
