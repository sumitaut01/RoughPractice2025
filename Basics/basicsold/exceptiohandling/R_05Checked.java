package basicsold.exceptiohandling;

import java.io.IOException;

//Summary
//        methodOne() throws	What methodTwo() must do
//        Checked exception	✅ Either catch it OR declare it with throws
//        Unchecked exception	❌ Nothing required (handling is optional)

public class R_05Checked {

    // Method 1: Throws a checked exception
    public void methodOne() throws IOException {
        // some risky file operation
        throw new IOException("File problem");
    }

    public void methodTwo() {
        //handled in try catch
        try {
            methodOne();
        } catch (IOException e) {
            System.out.println("Handled: " + e.getMessage());
        }
    }

    public void methodThree() throws IOException {
            methodOne();// added throws in method signature
    }

    public static void main(String[] args) {

    }


}
