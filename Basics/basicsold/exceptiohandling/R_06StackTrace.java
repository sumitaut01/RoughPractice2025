package basicsold.exceptiohandling;
//Exception in thread "main" java.lang.ArithmeticException: / by zero
//        at basics.exceptiohandling.R_06StackTrace.third(R_06StackTrace.java:17)
//        at basics.exceptiohandling.R_06StackTrace.second(R_06StackTrace.java:13)
//        at basics.exceptiohandling.R_06StackTrace.first(R_06StackTrace.java:9)
//        at basics.exceptiohandling.R_06StackTrace.main(R_06StackTrace.java:5)

//Stack Memory (at moment of crash):
//        third()  // ← top of stack (crashed here)
//        second()
//        first()
//        main()
//        This is exactly what you see in the stack trace — JVM prints the method call history from top of the stack down.

//        Exception Object is on Heap
//        try {
//        int a = 10 / 0;
//        } catch (ArithmeticException e) {
//        // 'e' is a reference to an exception object on heap
//        e.printStackTrace();
//        }
//        The object e (the exception itself) is stored in the heap
//        The variable e is a reference, stored in the stack

//Visual Mapping
//        Stack                                 Heap
//        -----------------------------         -------------------------------
//        main()                                new ArithmeticException()
//        └── calls first()
//        └── calls second()
//        └── calls third() → 💥 error
//        ↑ Object of exception lives here

//✅ So to Summarize:
//        Concept	Memory Area	Notes
//        Method calls	Stack	Stack trace = sequence of calls
//        Exception object (e)	Heap	All objects live in heap
//        Local variable e	Stack	Just a reference to the heap object
//        Stack trace	Stack	Printed by JVM walking the call stack


public class R_06StackTrace {
    public static void main(String[] args) {
        first(); // stack frame 1
    }

    public static void first() {
        second(); // stack frame 2
    }

    public static void second() {
        third(); // stack frame 3
    }

    public static void third() {
        int x = 1 / 0; // ArithmeticException
    }
}