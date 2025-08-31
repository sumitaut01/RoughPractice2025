package basics;

public class R25_ExceptionHandling {
    /*
    //Checked
    -compiler warns you to handle it.
    -extends Exception
    - caller has to handle it in case of multi calls (a->b-<ce)
    - in case caller don't want to handle, caller itself should add in method signature

    //Unchecked
    // happens only during runtime
    // extends run time exception
    //
    */

    public static void main(String[] args) {

        m1();//Exception in thread "main" basics.TestUncheckedException: unchecked exception thrown

        try {
            m2();// either add throws in main signature or surround in try chatc
        } catch (TestCheckedException e) {
            throw new RuntimeException(e);
        }


    }



    public static void m1(){
      throw new  TestUncheckedException("unchecked exception thrown");
    }

    public static void m2() throws TestCheckedException {// won't compile if we don't add throws TestCheckedException
        throw new  TestCheckedException("unchecked exception thrown");
    }
}



//Checked Exception
class TestCheckedException extends  Exception{

    TestCheckedException (String msgFromException){
        super(msgFromException);
    }
}


class TestUncheckedException extends  RuntimeException{
    TestUncheckedException(String msgFromException){
        super(msgFromException);
    }
}
