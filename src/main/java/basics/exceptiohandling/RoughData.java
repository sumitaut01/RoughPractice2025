package basics.exceptiohandling;

public class RoughData {


    public static void main(String[] args) throws MyException_checked_040526 {

        int num1 = 2;
        if (num1 > 3) {
            throw new MyException_Unchecked_040526(num1 +" greater thna 3");
        }

        if (num1 < 3) {
            throw new MyException_checked_040526(num1 +" less thna 3");// will force method signature change .. extends
        }


    }

}


class MyException_Unchecked_040526 extends RuntimeException {

    public MyException_Unchecked_040526(String message) {
        super(message);
    }
}

class MyException_checked_040526 extends Exception {

    public MyException_checked_040526(String message) {
        super(message);
    }
}


class MyException_checked_040526_2 extends Exception {

    public MyException_checked_040526_2(String message, Exception exception) {
        super(message);
        throw new RuntimeException(exception);
    }
}



