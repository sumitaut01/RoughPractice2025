package basics;
//Keyword	Purpose	Used With
//final	Prevent change (immutable)	Variables, methods, classes
//        finally	Always run after try-catch	try-catch blocks
//        finalize()	Cleanup before GC (deprecated)	Classes (by overriding)

//1. final — Constant / Can't be Modified
//        Used to prevent modification (of variables, methods, or classes)
//final int x = 10;
//        x = 20;  // ❌ Error: can't assign a new value

//final method

//class A {
//    final void show() {
//        System.out.println("Hello");
//    }
//}

//        🔹 final class
//final class Animal {
//    void sound() {}
//}

//class Dog extends Animal {}  // ❌ Error: can't extend a final class
//
//class B extends A {
//    // void show() {} ❌ Error: cannot override final method
//}


//        2. finally — Always Executes (Exception Handling)
//        The finally block is used with try-catch to ensure that important code always runs, even if an exception occurs.

//        try {
//        System.out.println(10 / 0);
//        } catch (Exception e) {
//        System.out.println("Caught an error");
//        } finally {
//        System.out.println("Cleanup runs here");
//        }

//        Even if you:
//
//        throw an exception,
//
//        return from a method,
//
//        or break from a loop…
//
//        …the finally block will still execute.



//        ✅ 3. finalize() — Called by Garbage Collector (Deprecated)
//        finalize() was a method in Object class, used to run cleanup code before an object is garbage collected.

//class MyClass {
//    @Override
//    protected void finalize() {
//        System.out.println("Finalize called");
//    }
//}
//🔴 Deprecated
//        As of Java 9+, finalize() is deprecated because:
//        It introduces unpredictability
//        Slows down GC
//        Not reliable for resource cleanup
//        ✅ Use try-with-resources or manual close instead.





//        Real-World Tips
//        Scenario	Use
//        Make a constant value	final int MAX = 100;
//        Ensure resource cleanup (files/db)	try-finally or try-with-resources
//        Prevent method override	final void method() {}
//        Prevent class extension	final class Utility {}
//    Avoid finalize()	Use AutoCloseable / manual close
public class R_finalFinllyfinalize {
}
