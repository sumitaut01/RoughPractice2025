package basics;

interface X1{
    default void show() {
        System.out.println("X1's show()");
    }
}

interface X2 {
    default void show() {
        System.out.println("X2's show()");
    }
}

// Class implements both A and B
class MyClassX implements X1, X2 {
    // Compiler error if we don't resolve the conflict!
    @Override
    public void show() {
        // Option 1: Provide your own implementation
        System.out.println("MyClass's show()");

        // Option 2: Explicitly call one of the parent interfaces
        X1.super.show(); // call X1's default method
        X2.super.show(); // call X2's default method
    }
}

public class MultipleInheritanceDiamondProblemDemo {
    public static void main(String[] args) {
        MyClassX obj = new MyClassX();
        obj.show();
    }
}
