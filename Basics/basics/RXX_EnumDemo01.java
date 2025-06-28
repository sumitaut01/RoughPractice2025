package basics;

//enum (short for enumeration) is a special Java type used to define a fixed set of constants.
//enum Day { MONDAY, TUESDAY, WEDNESDAY, ... }

//Why Use Enums?
//        Problem (without enums)	Solution (with enums)
//        Use of raw int/String constants	Type-safe named constants
//        Typos & invalid values are common	Compile-time safety
//        No associated behavior	Enums can have methods too
public class RXX_EnumDemo01 {

    public static void main(String[] args) {
        Day today = Day.MONDAY;
        switch (today) {
            case MONDAY -> System.out.println("oh its Monday!!");
            case TUESDAY -> System.out.println("oh its Tuesday!!");
            default -> System.out.println("default case");
        }


    }
}
enum Day {MONDAY, TUESDAY, WEDNESDAY};