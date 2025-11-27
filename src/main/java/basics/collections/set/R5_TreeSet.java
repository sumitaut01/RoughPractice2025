package basics.collections.set;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.TreeSet;

//What	is	a	TreeSet?	How	is	different	from	a	HashSet?
//TreeSet	implements	Set,	SortedSet	and	NavigableSet	interfaces.
// TreeSet	is	similar	to	HashSet	except	that
//it	stores	element’s	in	Sorted	Order.

public class R5_TreeSet {
    public static void main(String[] args) {
        TreeSet<String> treeSet=new TreeSet<>();
        treeSet.add("A");
        treeSet.add("Z");
        treeSet.add("S");
        treeSet.add("D");
        System.out.println(treeSet);//[A, D, S, Z]

        //1
        System.out.println(treeSet.descendingSet());//[Z, S, D, A]
        System.out.println(treeSet);//[A, D, S, Z]

        ArrayList<String> rev=new ArrayList<>(treeSet);
        Collections.reverse(rev);
        System.out.println(rev);//[Z, S, D, A]

    }


}
