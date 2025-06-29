package basics.exceptiohandling;

import java.io.FileReader;
import java.io.IOException;

//What is Exception Chaining?
//        Exception chaining is the practice of wrapping one exception inside another to preserve the original cause of the error.
//
//        This is useful when:
//
//        You want to abstract low-level details but still retain root cause
//
//        You’re converting checked to unchecked or throwing a custom exception



public class R7_XExceptionPropogation {

    public static void main(String[] args) throws FileReadException {
        readFile();

    }
    public static void readFile() throws FileReadException {
        try {
            FileReader reader = new FileReader("data.txt");
        } catch (IOException e) {
            throw new FileReadException("Failed to read file", e);
        }
    }
}


//    Exception in thread "main" basics.exceptiohandling.FileReadException: Failed to read file
//        at basics.exceptiohandling.R7_XExceptionPropogation.readFile(R7_XExceptionPropogation.java:16)
//        at basics.exceptiohandling.R7_XExceptionPropogation.main(R7_XExceptionPropogation.java:9)

    class FileReadException extends Exception {
        public FileReadException(String message, Throwable cause) {
            super(message, cause);
        }
    }