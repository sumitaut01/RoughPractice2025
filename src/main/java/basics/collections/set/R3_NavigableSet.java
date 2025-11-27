package basics.collections.set;

import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.TreeSet;

public class R3_NavigableSet {

    public static void main(String[] args) {

        NavigableSet<String> str=new TreeSet<>();
        str.add("Sumit");
        str.add("Neha");
        str.add("Amit");
        System.out.println(str);//[Amit, Neha, Sumit]

        //Lower	method	finds	the	highest	element	lower	than	specified	element.	Floor	method	finds	the	highest
        //element	lower	than	or	equal	to	specified	element.		Corresponding	methods	for	finding	lowest	number
        //higher	than	specified	element	are	higher	and	ceiling.	A	few	examples	using	the	Set	created	earlier
        //below.
        ////

        System.out.println(str.lower("Sumit"));//Neha
        System.out.println(str.lower("Neha"));//Amit
        System.out.println(str.lower("Amit"));//null

        System.out.println(str.higher("Amit"));//Neha

        System.out.println(str.reversed());//[Sumit, Neha, Amit]

    }
}
