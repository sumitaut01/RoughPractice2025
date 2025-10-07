package basics;

//26 What is Shadowing in java and its types?
//        Shadowing happens when a variable or method in a subclass hides (shadows) a variable or
//        method with the same name in the parent class.
//        1. Variable Shadowing
//         If a subclass declares a variable with the same name as a variable in the superclass, the subclass
//        variable shadows the parent one.
//         The type of the variable can be different.
//         Shadowing is different from overriding because it works on variables, not methods.
public class R_XVariableShadowingSuper {
    public static void main(String[] args) {
        Parentx parent = new Parentx();
        System.out.println(parent.name); //Parent

        Childx child = new Childx();
        child.printNames();

    }
}



class Parentx {
    String name = "Parent";
}
class Childx extends Parentx {
    int name = 10; // Shadows Parent's 'name' (different data type)

    void printNames() {
        System.out.println(name); // 10 (Child's name)
        System.out.println(super.name); // "Parent" (Parent's name)
    }
}

