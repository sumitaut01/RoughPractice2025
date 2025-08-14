package basicsold.exceptiohandling;


//throw vs throws — Side-by-Side Comparison
//        Feature	throw	throws
//        Used for	To manually throw an exception	To declare that a method might throw an exception
//        Position	Inside the method body	In the method signature
//        Follows by	A single instance of Throwable	One or more exception classes (comma-separated)
//        Example	throw new IOException("file error");	void readFile() throws IOException
//        Who handles it?	Must be caught or declared	Caller must handle it

//throw — Manually Throwing an Exception
//public void validateAge(int age) {
//        if (age < 18) {
//        throw new IllegalArgumentException("Age must be 18+");
//        }
//        }
//        This throws an actual object of IllegalArgumentException
//        Can be checked or unchecked
//        You must new the exception


//throws — Declaring That a Method Might Throw
//public void readFile() throws IOException {
//        FileInputStream fis = new FileInputStream("data.txt");
//        }
//        throws just tells the compiler: “This method might throw IOException”
//
//        You don’t throw anything yourself here (unless inside body)
//
//        Caller must handle it with try-catch or re-declare

public class R_03ThrowThrows {
    public static void main(String[] args) {

    }
}
