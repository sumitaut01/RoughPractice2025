package basics.exceptiohandling;

//try-with-resources — Auto-Close Resources Safely
//        Introduced in Java 7, try-with-resources is used to automatically close resources
//        (like files, streams, sockets, DB connections) without needing a finally block.

import java.io.FileInputStream;
import java.io.IOException;

public class R_trywithresources {
    public static void main(String[] args) {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("data.txt");
            // read file
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null) fis.close();  // manual cleanup
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

//        ❌ Problems:
//        Verbose
//        Easy to forget .close()
//        Cluttered finally block

//try with resources

        try (FileInputStream fis2 = new FileInputStream("data2.txt")) {
            int data = fis2.read();
            System.out.println((char) data);
        } catch (IOException e) {
            e.printStackTrace();
        }
// No need for finally — auto-closed!

//        What Changed?
//        Any object that implements AutoCloseable (or Closeable) is auto-closed at the end of the try block.


//        Rule	Example
//        Resource must implement AutoCloseable	FileInputStream, BufferedReader, Scanner
//        Declared inside try()	try (Scanner sc = new Scanner(...))
//        Auto-close after try ends	Even if exception occurs



//        Multiple Resources
//        try (
//                FileInputStream fis = new FileInputStream("input.txt");
//                FileOutputStream fos = new FileOutputStream("output.txt")
//        ) {
//            fos.write(fis.read());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        Behind the Scenes
//        try (MyResource r = new MyResource()) {
//            // use r
//        }
//// JVM calls r.close() automatically
//        If close() throws exception, it's handled gracefully.
    }
}
