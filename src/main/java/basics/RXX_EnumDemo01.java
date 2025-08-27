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



        Env env=Env.valueOf("QA");
        Env[] envs=Env.values();


    }
}
enum Day {MONDAY, TUESDAY, WEDNESDAY};

enum Env{
    QA("QA Env"),
    UAT("Uat Env");
    String s;

    Env(String s) {
        this.s=s;
    }

    public String getS() {
        return s;
    }

}


//In the Env enum, the line Env(String s) is the constructor. It's used to initialize the s instance variable for each enum constant (QA and UAT).
// The value passed to the constructor ("QA Env" or "Uat Env") is assigned to the s variable when the enum constants are created.
//Unlike regular classes, an enum's constructor is always implicitly private.
// This is because you can't create new enum instances with new outside of the enum itself;
// the constants are the only instances that can exist.

