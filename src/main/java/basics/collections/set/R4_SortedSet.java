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



        Stux s2=new Stux("Zebra",10);
        Stux s1=new Stux("Alpha",20);
        SortedSet<Stux> strX=new TreeSet<>();

        strX.add(s2);
        strX.add(s1);

        System.out.println(strX);

    }
}



class Stux implements Comparable<Stux>{

String name;
int age;

    public Stux(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Stux o) {
      return this.name.compareTo(o.name);
    }
}
