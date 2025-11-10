package basics.Generics;

public class R2_SubClasssSuperClass {

    public static void main(String[] args) {


        Test<P> t= new Test<>();

        t.print(new P());//from parent



        Test<C> tc= new Test<>();
        tc.print(new C());//from child




        Test<C> tcc= new Test<>();


    }
}


class Test<C extends P>{


    public void print(C c){
        c.msg();
    }



}

class P{

    public void msg(){
        System.out.println("From parent");
    }

}

class C extends P{
    public void msg(){
        System.out.println("From child");
    }

}

class X{

    public void msg(){
        System.out.println("From X");
    }

}


//Context
//In Java Generics, the syntax <T extends Something> defines an upper bound.
//It means:
//
//“The type parameter T must be either Something itself or a subclass of it.”
//
//This applies to classes, interfaces, or even multiple bounds.
//
//🔍 Line-by-line explanation
//🧩 class P { }
//
//
//This is a base class (like a parent).
//
//
//🧩 class Test<C extends P> { }
//
//
//This is a generic class with type parameter C.
//
//
//The keyword extends means:
//
//Whatever class you use to replace C must be of type P or subclass of P.
//
//
//
//So you can write:
//class Child extends P {}
//
//Test<P> t1 = new Test<>();        // ✅ OK
//Test<Child> t2 = new Test<>();    // ✅ OK
//Test<String> t3 = new Test<>();   // ❌ ERROR — String is not a subclass of P
//
//
//💡 Think of it this way
//The declaration:
//class Test<C extends P> { }
//
//means that C is bounded — it’s not any arbitrary class,
//it’s restricted to P or subclasses of P.
//So this gives type safety to your generics.
//
//🧠 Why this is useful
//If you want to make sure that your generic type has certain methods (defined in class P),
//then you can safely call them inside Test.
//Example:
//class P {
//    void show() {
//        System.out.println("From P");
//    }
//}
//
//class Test<C extends P> {
//    void display(C obj) {
//        obj.show(); // ✅ Allowed because C must be a subtype of P
//    }
//}
//
//Now, you can safely pass any C that extends P:
//class Child extends P {
//    void childMethod() {}
//}
//
//public class Main {
//    public static void main(String[] args) {
//        Test<P> t1 = new Test<>();
//        t1.display(new P()); // works
//
//        Test<Child> t2 = new Test<>();
//        t2.display(new Child()); // works
//    }
//}
//
//If you didn’t use <C extends P>,
//Java wouldn’t know that C has a show() method, and obj.show() would not compile.
//
//⚡ Analogy
//Think of <C extends P> as saying:
//
//“I will only accept people who are at least type P —
//you can be P or any subclass, but not unrelated types.”
//
//
//🧩 Variants
//DeclarationMeaning<T>Any type (unbounded)<T extends P>Only P and its subclasses<T super P>Only P and its superclasses (used in wildcards, not class definition)<T extends InterfaceName>Type must implement the given interface<T extends Class & Interface>Type must extend the class and implement the interface
//
//✅ Summary
//ConceptExampleDescriptionUpper bound<T extends P>Type must be P or subclassLower bound? super PType must be P or superclassUnbounded<T>Any typeUse caseRestrict generics to certain behavior (methods/fields)
//
//Would you like me to add a visual diagram showing how P, Child, and Test<C extends P> relate in memory (like a UML arrow diagram)? It’s great for interview recall.