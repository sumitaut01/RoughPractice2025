package basics.exceptiohandling;

//What Are Checked and Unchecked Exceptions?
//        Type	Defined by
//        Checked	Subclasses of Exception (but not RuntimeException)
//        Unchecked	Subclasses of RuntimeException

//Throwable
//        ├── Error                   (JVM errors like OutOfMemoryError)
//        └── Exception
//        ├── RuntimeException    ← Unchecked
//        │     ├── NullPointerException
//        │     ├── ArithmeticException
//        └── IOException, SQLException, etc.  ← Checked


//1. Checked Exceptions
//        These are checked at compile time — the compiler forces you to either catch them or declare them.
//
//        🔹 Examples:
//        IOException
//        SQLException
//        FileNotFoundException
//        ParseException
//
//public void readFile(String path) throws IOException {
//        FileInputStream fis = new FileInputStream(path);  // Checked exception
//        }
//        If you don’t:
//        Catch it with try-catch
//        Or declare with throws
//        🚫 Compile-time error!
public class R04_ChckedUnchecked {
}
