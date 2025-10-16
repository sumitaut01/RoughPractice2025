package basics;

public class OverRidingCovarintObject1 {

    public static void main(String[] args) {
        Parent p=new Child();
        p.Method1(5);//From Child
        p.Method2("Name");//  //From Parent Object
    }


}



class Parent {
    public Number Method1(Number o) {
        System.out.println("From Parent char");
        return o;
    }

    public Object Method2(Object o) {
        System.out.println("From Parent Object");
        return o;
    }


}





class Child extends  Parent{
    @Override
    public Integer Method1(Number s) {  //notice that the parameter is number
        System.out.println("From Child ");
        return (Integer) s;
    }

    public String Method2(String o) {
        System.out.println("From Child String");
        return o;
    }

}



//The term "covariant override" specifically refers to Covariant Return Types in Java. This feature allows a method in a subclass to override a method in its superclass and return a type that is a subtype (or subclass) of the return type in the superclass method.
//
//This concept simplifies code by eliminating the need for client-side type casting, as the overriding method promises a more specific result.
//
//How Covariant Return Types Work
//The Rule
//When overriding a method in a child class:
//
//The method name and parameter types must be identical to the parent method (the method signature must be the same, excluding the return type).
//
//The return type of the child method must be the same as the parent method's return type OR a subtype of the parent's return type.
//
//Element	Parent Method	Child Method (Overriding)	Rule
//Name	MethodName	MethodName	Must be the same
//Parameters	(TypeA a)	(TypeA a)	Must be the same (Crucial!)
//Return Type	SuperType	SubtypeOfSuperType	Must be the same or a subtype (Covariant)
//
//Export to Sheets
//Analysis of Your Example
//Your example demonstrates both a correct covariant override and two instances of Method Overloading, which is a distinct concept from overriding.
//
//1. Method2 (Correct Covariant Override)
//Class	Method Signature	Return Type	Status
//Parent	public Object Method2(Object o)	Object	Base method
//Child	public String Method2(Object o)	String	Covariant Override
//
//Export to Sheets
//Parent Return Type: Object
//
//Child Return Type: String
//
//Relationship: String is a subtype of Object.
//
//Method Signature: The parameter list must be the same ((Object o)).
//
//If you change the parameter type in the Child class to match the parent:
//
//Java
//
//// Corrected Child class
//class Child extends Parent {
//    @Override // Annotation to confirm it's an override
//    public String Method2(Object o) { // Parameter type is still Object
//        System.out.println("From Child String");
//        return (String) o; // Assume a String is passed or cast safely
//    }
//}
//In this corrected version, Child.Method2 successfully overrides Parent.Method2 using a covariant return type (String is a subtype of Object).