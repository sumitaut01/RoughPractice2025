package basics.autoboxingunboxing;

import java.util.ArrayList;

//primitive to non primitive conversion
//int getting converted to Integer

//Autoboxing and Unboxing
//Autoboxing is the automatic conversion that the Java compiler makes between the primitive types and their corresponding object wrapper classes. For example, converting an int to an Integer, a double to a Double, and so on. If the conversion goes the other way, this is called unboxing.
//
//Here is the simplest example of autoboxing:
//
//Character ch = 'a';
//The rest of the examples in this section use generics. If you are not yet familiar with the syntax of generics, see the Generics (Updated) lesson.
//
//Consider the following code:
//
//List<Integer> li = new ArrayList<>();
//for (int i = 1; i < 50; i += 2)
//    li.add(i);


/*
Converting an object of a wrapper type (Integer) to its corresponding primitive (int) value is called unboxing. The Java compiler applies unboxing when an object of a wrapper class is:

        Passed as a parameter to a method that expects a value of the corresponding primitive type.
        Assigned to a variable of the corresponding primitive type.
        The Unboxing example shows how this works:

        import java.util.ArrayList;
        import java.util.List;

public class Unboxing {

    public static void main(String[] args) {
        Integer i = new Integer(-8);

        // 1. Unboxing through method invocation
        int absVal = absoluteValue(i);
        System.out.println("absolute value of " + i + " = " + absVal);

        List<Double> ld = new ArrayList<>();
        ld.add(3.1416);    // Π is autoboxed through method invocation.

        // 2. Unboxing through assignment
        double pi = ld.get(0);
        System.out.println("pi = " + pi);
    }

    public static int absoluteValue(int i) {
        return (i < 0) ? -i : i;
    }
}


 */
public class R1_ {

    public static void main(String[] args) {
        int x=3;
        ArrayList<Integer> al=new ArrayList<>();
        al.add(3);// behind the scenes, autoboxing happening


        Integer i1=Integer.valueOf(1);
        Integer i2=Integer.valueOf("3");
        Integer i3=Integer.valueOf("01",2);

        System.out.println(i1);//1
        System.out.println(i2);//3
        System.out.println(i3);//1

    }
}
