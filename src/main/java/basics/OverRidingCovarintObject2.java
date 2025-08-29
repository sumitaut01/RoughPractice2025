package basics;
/*

Why It's Covariant Overriding
The code demonstrates that a method in a subclass can override a method in its superclass and return a more specific or "narrower" type. In this example, the getObject() method is overridden across three classes in a clear parent-child relationship:

class A: The base class. Its getObject() method returns an object of type A.

class B extends A: The subclass B overrides getObject(). Its method returns an object of type B. This is valid because B is a subtype of A.

class C extends B: The subclass C overrides getObject(). Its method returns an object of type C. This is valid because C is a subtype of B.

This is the essence of covariance: the return type of the overriding method varies in the same direction (from general to specific) as the class hierarchy itself. This feature was introduced in Java 5 to improve code readability and remove the need for explicit type casting.
 */
public class OverRidingCovarintObject2 {
    public static void main(String[] args) {

         A obj=new B();
         obj.getObject();//Object of B Created


        B obj2=new C();
        obj2.getObject();//Object of C Created


        A obj3=new C();
        obj3.getObject();//Object of C Created

    }
}


class A{
  A getObject(){
      System.out.println("Object of A Created");
    return new A();
  }
}


class B extends A{

    @Override
    B getObject(){
        System.out.println("Object of B Created");
        return new B();
    }
}

class C extends B{
    @Override
    C getObject(){
        System.out.println("Object of C Created");
        return new C();
    }

}