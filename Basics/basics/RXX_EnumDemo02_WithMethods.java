package basics;

//Enum constants must come first
//        Fields cannot appear before constants
//        You can have fields/methods after the enum constants.



//Enum Features Summary
//        Feature	Example
//        Type-safe constants	Day.MONDAY, Status.NEW
//        Used in switch	Clean switch-case logic
//        Can have fields	code, description, etc.
//        Can have methods	getCode(), toString()
//        Can implement interfaces	✅ Yes
//        Can override methods	e.g., toString() per constant
public class RXX_EnumDemo02_WithMethods {

    public static void main(String[] args) {

        StatusCodes sc = StatusCodes.COMPLETED;
        System.out.println(sc);
        System.out.println(sc.getCode());
//        COMPLETED
//        2
    }
}


enum StatusCodes {
    NEW(0), IN_PROGRESS(1), COMPLETED(2);
    private int code;

    StatusCodes(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
