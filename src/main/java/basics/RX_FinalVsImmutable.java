package basics;

import java.util.ArrayList;

public class RX_FinalVsImmutable {

//8. Final vs immutable
//Final and immutable may look similar, but they mean very different things in Java.
//final is a Java keyword. It places restrictions on variables, methods, and classes. final doesn’t
//freeze the object itself. If we make a List final, we can’t assign a new List to that variable, but we
//can still add or remove items from the same List.
//Immutability is about the design of the object itself. An immutable object does not allow its
//state to change after it is created.
// The classic example is String. Once you create "Hello", we can’t change its characters. Any
//modification creates a new object.
    public static void main(String[] args) {

       final ArrayList<Integer> al=new ArrayList<>();
        al.add(1);
        al.add(2);
        al.add(3);
        al.add(4);
        System.out.println(al); //[1, 2, 3, 4]

        final ArrayList<Integer> al2=new ArrayList<>()  ;

       // al=al2; //Cannot assign a value to final variable 'al'
        //we cant assign new list


        //we can crud as usual
        al.remove(0);
        System.out.println(al); //[2, 3, 4]


        final int x=10;
        //x=11; //Cannot assign a value to final variable 'x'





    }
}
