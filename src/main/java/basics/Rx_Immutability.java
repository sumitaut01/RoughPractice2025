package basics;

//13 What is immutability, how to achieve it?
//        Immutability means: once an object is created, we cannot change its values.
//        Instead of modifying the same object, a new object is created when we try to change
//        something.
//        In Java, this concept applies to strings, which means that once a string object is created, its
//        content cannot be changed. If we try to change a string, Java does not modify the original one, it
//        creates a new string object instead.
//        String name = "Ravi";
//        name = name + " Kumar";
//        System.out.println(name); // Output: Ravi Kumar
//        Here, "Ravi" did not become "Ravi Kumar". A new String "Ravi Kumar" was created and stored in
//        name.
//        How to achieve immutability in Java?
//        To make a class immutable, follow these rules:
//        1. Make the class final
//So that no one can extend it.
//        2. Make all fields private and final
//This avoids direct access and ensures the value doesn’t change after assignment.
//        3. No setters, only getters
//        Don’t provide methods to change the field values.
//        4. If any field is an object, return a copy, not the original
//        So that internal data is not modified from outside. Refer (Output Question No : )

import groovy.transform.Immutable;

public class Rx_Immutability {

    //public final class String
    //implements java.io.Serializable,
    //           Comparable<String>,
    //           CharSequence,
    //           java.lang.constant.Constable,
    //           java.lang.constant.ConstantDesc

    public static void main(String[] args) {


        MyImmutable m = new MyImmutable(32);
        m=new MyImmutable(3373);

        MyImmutable m1 = new MyImmutable(333);

        //Step 1:
        // Stack           Heap
        //  ┌────┐         ┌──────────────────────┐
        //  │ m  │ ──────► │ MyImmutable(age=32) │
        //  └────┘         └──────────────────────┘
        //
        //Step 2:
        // Stack           Heap
        //  ┌────┐         ┌──────────────────────┐
        //  │ m  │ ──────► │ MyImmutable(age=3373)│
        //  └────┘         └──────────────────────┘
        //                 (MyImmutable(age=32)) ← Unreachable, GC soon----   so this 31 hadnt changed hence we are saying immutable


    }
}



final class MyImmutable{

    private final int age;

    MyImmutable(int age)
    {
        this.age=age;
    }

    public int getAge(){
        return age;
    }


}
