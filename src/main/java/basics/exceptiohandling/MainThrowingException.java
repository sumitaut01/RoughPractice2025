package basics.exceptiohandling;
//Interview-Level Explanation
//
//If interviewer asks:
//
//What happens if we write throws Exception in main?
//
//You say:
//
//The main method is called by the JVM. When we declare throws Exception, we are informing the compiler that any checked exception occurring inside main will be propagated to the JVM. If an exception occurs and is not handled, the JVM will terminate the program and print the stack trace. If no exception occurs, the program runs normally.
//
//🔹 One More Deep Concept
//
//Since Exception is the parent of all checked exceptions:
//
//throws Exception
//
//
//means:
//
//This method may throw ANY checked exception.
//
//It's a broad declaration.
//
//Better practice:
//
//throws IOException
//
//
//instead of
//
//throws Exception
//
//🔥 Quick Summary
//Scenario	Result
//No exception occurs	Program runs normally
//Checked exception occurs	JVM prints stack trace and terminates
//Unchecked exception occurs	Same behavior
//
//If you want, next we can go deeper:
//
//What if we remove static from main?
//
//What if main returns int?
//
//What if we overload main?
//
//Why main must be public?
//
//These are very common Java interview traps 😉
public class MainThrowingException {

    public static void main(String[] args) throws Exception {
        System.out.println("hi");
    }



}
