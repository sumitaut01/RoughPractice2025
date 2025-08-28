package basics;

public class R12_Stack {

//    Each thread gets its own stack.
//    Stores:
//    Primitive variables (e.g., int x = 5)
//    References to objects (but not the object itself)
//    Method call frames
//Considered faster


    void test() {
        int a = 10; // stored in stack
        Student s = new Student(); // 's' stored in stack, object in heap
    }


}

class Student{}