package basics.collections.list;


//What Does “Backed by Dynamic Array” Mean?
//        🔹 A "backed by" structure means:Internally, the data structure uses another structure to store and manage its elements.
//        So when we say:ArrayList is backed by a dynamic array
//        We mean:
//        Internally, ArrayList uses a resizable array (Object[] elementData) to hold its elements.
//Summary
//        Concept	Meaning
//        "Backed by array"	Internally uses an array (Object[]) to store data
//        "Dynamic"	Grows automatically as needed
//        Advantage	Easy indexed access, fast reads
//        Trade-off	Resize involves copying elements (can be costly for large lists)

//What is ArrayList?
//        A resizable array-based collection.
//        Maintains insertion order.
//        Allows duplicate elements.
//        Provides random access using index.
//        Not thread-safe (use Collections.synchronizedList() for safety


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Behind the Scenes
//        Operation	Time Complexity
//        get(index)	O(1) – direct access
//        add(value)	Amortized O(1)
//        add(index, val)	O(n) – may shift elements
//        remove(index)	O(n) – shift elements
//        contains(val)	O(n) – linear scan
public class ArrayListDemo {

    public static void main(String[] args) {

        List<String> lStr=new ArrayList<>();
        lStr.add("Sumit");  //returns boolean : true in this case
        lStr.add("Amit");
        lStr.add("Neha");

        System.out.println(lStr.remove("Neha"));// true if removal was success
        System.out.println(lStr.remove("does not exist"));// false as value does not exists

        System.out.println(lStr);//[Sumit, Amit]



        System.out.println(lStr.indexOf("Sumit"));//0
        System.out.println(lStr.indexOf("kkk"));//-1 as kkk does not exist


        System.out.println(lStr.set(0,"first"));// give element which got replaced-- sumit is this case

        System.out.println(lStr.size());//2
        lStr.clear();//removes element
        System.out.println(lStr.size());//0

        System.out.println(lStr.isEmpty());//true

        //addAll

        List<String> lStr2=new ArrayList<>();
        lStr2.add("Jason");  //returns boolean
        lStr2.add("Jmes");
        lStr2.add("Chase");

        System.out.println(lStr);// empty becase of clear
        lStr.addAll(lStr2);//added list 2
        System.out.println(lStr);//[Jason, Jmes, Chase]

        //sublist
        System.out.println(lStr.subList(0,1));//Jason


        //Sorting
        List<String> names=List.of("D","A","B","C");
        System.out.println(names);////[D, A, B, C]
        //Collections.sort(names);// will error our
        //Exception in thread "main" java.lang.UnsupportedOperationException
        //	at java.base/java.util.ImmutableCollections.uoe(ImmutableCollections.java:142)

        //Below Will work
        List<String> names2=new ArrayList<>();
        names2.add("D");
        names2.add("A");
        names2.add("B");
        System.out.println(names2);

        Collections.sort(names2);
        System.out.println(names2);//[A, B, D]




    }
}
