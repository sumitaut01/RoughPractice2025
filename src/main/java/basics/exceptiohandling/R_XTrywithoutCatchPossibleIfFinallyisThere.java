package basics.exceptiohandling;

public class R_XTrywithoutCatchPossibleIfFinallyisThere {


    public static void main(String[] args) {

        int a=10;
        int b=0;

        try{
            System.out.println(a/b);
        }
       finally {
            System.out.println("finally printed");
        }

        //finally printed
        //Exception in thread "main" java.lang.ArithmeticException: / by zero
        //	at basics.exceptiohandling.R_XTrywithoutCatchPossibleIfFinallyisThere.main(R_XTrywithoutCatchPossibleIfFinallyisThere.java:12)
    }
}
