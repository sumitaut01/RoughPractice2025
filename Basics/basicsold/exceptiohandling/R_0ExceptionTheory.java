package basicsold.exceptiohandling;

// What is an Exception?
//        An exception is an unexpected event that interrupts the normal flow of a program.
//        For example:
//        int x = 5 / 0;  // ❌ ArithmeticException: / by zero



//Step 2: Exception Hierarchy
//        java.lang.Throwable
//        ├── Error            (e.g., OutOfMemoryError, StackOverflowError)
//        └── Exception
//        ├── Checked Exception  (e.g., IOException, SQLException)
//        └── Unchecked Exception
//        └── RuntimeException (e.g., NullPointerException, ArithmeticException)


//Step 3: Types of Exceptions
//        Type	Examples	Needs handling?
//        Checked	IOException, SQLException	✅ Must handle (or declare)
//        Unchecked	NullPointerException, ArithmeticException	❌ Optional to handle
//        Error	OutOfMemoryError, StackOverflowError	❌ Should not handle (JVM-level issues)


//Step 4: try-catch Basics
//        try {
//        int result = 10 / 0;
//        } catch (ArithmeticException e) {
//        System.out.println("Cannot divide by zero");
//        }

//Step 5: Catching Multiple Exceptions
//        try {
//        String str = null;
//        System.out.println(str.length());
//        } catch (ArithmeticException e) {
//        System.out.println("Arithmetic error");
//        } catch (NullPointerException e) {
//        System.out.println("Null pointer error");
//        }

//Step 6: finally Block
//        Code that always runs whether exception occurs or not.
//        try {
//        int[] arr = new int[2];
//        System.out.println(arr[3]);
//        } catch (ArrayIndexOutOfBoundsException e) {
//        System.out.println("Out of bounds");
//        } finally {
//        System.out.println("Always runs");
//        }

//Step 7: throw keyword
//        Used to manually throw an exception.
//        throw new IllegalArgumentException("Invalid input");

//Step 8: throws keyword
//        Used to declare an exception that a method might throw.
//        void readFile() throws IOException {
//        // code that might throw IOException
//        }

//Step 9: Custom Exceptions
//        You can create your own:
//class MyException extends Exception {
//    public MyException(String message) {
//        super(message);
//    }
//}


//Summary Table
//        Keyword	Purpose
//        try	Wrap risky code
//        catch	Handle the exception
//        finally	Always executes
//        throw	Manually raise an exception
//        throws	Declare that a method might throw it
//        Custom class	Create your own checked exceptions
public class R_0ExceptionTheory {
}
