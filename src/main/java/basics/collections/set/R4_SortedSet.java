package basics.collections.set;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class R4_SortedSet {


    public static void main(String[] args) {



        SortedSet<String> str=new TreeSet<>();
        str.add("Sumit");
        str.add("Neha");
        str.add("Amit");
        //str.add(null);//Exception in thread "main" java.lang.NullPointerException
        System.out.println(str);//[Amit, Neha, Sumit]


        System.out.println(str.first());//Amit
        System.out.println(str.last());//Sumit


        System.out.println(str.getFirst());
    }
}
