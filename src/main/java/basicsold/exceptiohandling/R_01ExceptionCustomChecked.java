package basicsold.exceptiohandling;

//Because checked exceptions must be either:
//        Declared with throws in the method signature
//        Or handled using try-catch
//        If you remove throws MyCustomException and don’t catch it, the code will NOT compile.


//Summary
//        Exception Type	Needs throws?	Needs try-catch?	Compiler Enforces?
//        Checked (extends Exception)	✅ Yes	✅ Yes	✅ Yes
//        Unchecked (extends RuntimeException)	❌ No	❌ No	❌ No

public class R_01ExceptionCustomChecked {
    public static void main(String[] args) throws MyNewException {
        throw new MyNewException("checked ex");// will ask to add exception to method signaturre .Else compile error

//        Exception in thread "main" basics.exceptiohandling.MyNewException: checked ex
//        at basics.exceptiohandling.R_01ExceptionCustomChecked.main(R_01ExceptionCustomChecked.java:5)
//        Process finished with exit code 1
    }
}



 class MyNewException extends Exception{
    public MyNewException(String exceptionMsg){
        super(exceptionMsg);
    }


}
