package basics;

public class R13_HeapMemory {
//    Shared across all threads.
//
//    Stores:
//
//    Objects (created via new)
//
//    Instance variables
//
//    Static variables
//
//    Managed by the Garbage Collector


//    Memory	Stores	Lifetime	Access
//    Stack	Local variables, references	Short (method scope)	Fast
//    Heap	Actual objects	Long (GC decides)	Slower

    public static void main(String[] args) {
        int x = 5;                  // Stack
        Student1 s1 = new Student1(); // Stack + Heap
        s1.age = 25;               // Heap
    }
}

class Student1 {
    int age;
}

