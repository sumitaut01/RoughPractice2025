package basics;

public class R8_StaticBlock {

//    A static block in Java is a block of code that:
//
//    Runs once when the class is loaded into memory (before main() runs).
    //Is used to initialize static variables or perform setup tasks.

//    Purpose	Example
//    Initialize static variables	static int x = loadFromDB();
//    Load native libraries	System.loadLibrary("xyz");
//    Perform one-time setup	Logging setup, config, etc.
//    Run code when the class is loaded	Used in frameworks, JDBC drivers

    // A class can have multiple static blocks, and they run in order of appearance.

//    Static block is run only once per class, regardless of how many objects you create.
//
//    It cannot access non-static (instance) members.
//
//            No return, no parameters.


    static int age = 30;

    static {
        System.out.println("Executing first static block");
        age++;
    }

    static {
        System.out.println("Executing second static block");
        age++;
    }

    public static void main(String[] args) {
        System.out.println("Executing main method");
        System.out.println(age);//31
        System.out.println(age);//31
    }
}

//    Executing first static block
//        Executing second static block
//        Executing main method
//        32
//        32