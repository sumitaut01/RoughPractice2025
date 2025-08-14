package basicsold.comparablecomparator;

import java.util.*;

public class ComparableDemo {
    public static void main(String[] args) {

        //Example 1 will fail
//        var x = List.of(new Student(12, "Sumit"), new Student(4, "Aastha"), new Student(15, "Neha"));
//        Collections.sort(x);  // Uses compareTo()
//        x.forEach(stu -> System.out.println(stu.toString()));

        // above one will fail because collection.sort expects mutable list and list.of creates immutable list
        //Exception in thread "main" java.lang.UnsupportedOperationException
        //	at java.base/java.util.ImmutableCollections.uoe(ImmutableCollections.java:142)
        //	at java.base/java.util.ImmutableCollections$AbstractImmutableList.sort(ImmutableCollections.java:263)
        //	at java.base/java.util.Collections.sort(Collections.java:145)
        //	at basics.comparablecomparator.ComparableDemo.main(ComparableDemo.java:10)


        //Example 2
        List<Student> stu=new ArrayList<>(List.of(new Student(12, "Sumit"), new Student(4, "Aastha"), new Student(15, "Neha")));

        System.out.println(stu.toString());// no change [Student{age=12, name='Sumit'}, Student{age=4, name='Aastha'}, Student{age=15, name='Neha'}]
        //After using Collections.sort
        Collections.sort(stu);   //or stu.sort(null); this also use same
      //  stu.sort(null);//[Student{age=4, name='Aastha'}, Student{age=12, name='Sumit'}, Student{age=15, name='Neha'}]
        System.out.println(stu.toString());//[Student{age=4, name='Aastha'}, Student{age=12, name='Sumit'}, Student{age=15, name='Neha'}]

    }
}



 class Student implements Comparable<Student>{
    int age;
    String name;



    Student(int age,String name){
        this.age=age;
        this.name=name;
    }

     @Override
     public int compareTo(Student o) {
         return this.age-o.age;// Natural Order Sorting
     }

     @Override
     public String toString() {
         return "Student{" +
                 "age=" + age +
                 ", name='" + name + '\'' +
                 '}';
     }


//     @Override
//     public int compareTo(Student o) {
//         return o.age-this.age;// Reverse Order Sorting
//     }


 }
