package basics.collections.list;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetComparator {

    public static void main(String[] args) {

        TreeSet<String> tStr=new TreeSet<>();

        tStr.add("Sumit");
        tStr.add("Amit");
        System.out.println(tStr);
        //[Amit, Sumit]   Natural Sorting


        //If we want to add custom object, then we need compator or comparable implemeted
        TreeSet<Box> tBox=new TreeSet<>();
        //tBox.add(new Box(10,20));
        //Exception in thread "main" java.lang.ClassCastException: class basics.collections.list.Box cannot be cast to class java.lang.Comparable (basics.collections.list.Box is in unnamed module of loader 'app'; java.lang.Comparable is in module java.base of loader 'bootstrap')


        //will sort by height ascending
        Comparator<Box2> bcomp=new Comparator<Box2>() {
            @Override
            public int compare(Box2 o1, Box2 o2) {
                return Integer.compare(o1.height,o2.height);
            }
        };

        TreeSet<Box2> tBox2=new TreeSet(bcomp);
        tBox2.add(new Box2(10,20));
        tBox2.add(new Box2(20,5));
        tBox2.add(new Box2(5,1));

        System.out.println(tBox2.toString());//[Box2{height=5, width=20}, Box2{height=10, width=20}, Box2{height=20, width=20}]

        TreeSet<Box2> bWidth = new TreeSet<>(Comparator.comparingInt(b -> b.width));
        System.out.println(tBox2.toString());

    }



}


//TreeSet can work with BOTH: Comparable and Comparator
//1️⃣ If you do NOT give a Comparator → TreeSet uses Comparable
//
//Meaning:
//
//Your objects must implement Comparable<T>
//
//TreeSet will use the object’s compareTo() method to sort
//
//Example:
//
//class Person implements Comparable<Person> {
//    int age;
//    public Person(int age) { this.age = age; }
//
//    @Override
//    public int compareTo(Person o) {
//        return this.age - o.age;
//    }
//}
//
//TreeSet<Person> set = new TreeSet<>();
//
//
//Here, TreeSet sorts using compareTo().
//
//2️⃣ If you give a Comparator → TreeSet ignores Comparable
//
//Example:
//
//TreeSet<Person> set = new TreeSet<>(
//        (p1, p2) -> p1.age - p2.age
//);
//
//
//You don't need Comparable
//
//If Comparable exists, it will be ignored
//
//Comparator has higher priority
//
//⭐ Summary Table
//Scenario	Comparable needed?	Comparator used?	Who decides sorting?
//No Comparator passed	✔ Yes	❌ No	compareTo()
//Comparator passed in constructor	❌ No	✔ Yes	The Comparator
//Class has both Comparable + Comparator provided	✔ Exists but ignored	✔ Yes	Comparator
//💡 Key Rule (Interview Line):
//
//TreeSet needs some way to compare elements — either Comparable or Comparator.
//If Comparator is provided, it always overrides Comparable.


class Box{
    int height;
    int width;

    public Box(int height, int width) {
        this.height = height;
        this.width = width;
    }

}


class Box2{
    int height;
    int width;

    public Box2(int height, int width) {
        this.height = height;
        this.width = width;
    }

    @Override
    public String toString() {
        return "Box2{" +
                "height=" + height +
                ", width=" + width +
                '}';
    }
}



