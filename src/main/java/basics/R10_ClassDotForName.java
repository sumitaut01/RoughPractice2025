package basics;

public class R10_ClassDotForName {

    //Class.forName() is a powerful method in Java used for dynamic class loading at runtime.
    //Class.forName("com.example.MyClass");
    //This loads the class into memory, runs its static blocks, and registers it with the JVM.



//    Load class by name at runtime	Useful when class name comes from config/file
//2. 🔹 Trigger static block	Often used in JDBC driver loading
//3. 🔹 Register drivers / services	Class.forName("com.mysql.cj.jdbc.Driver");
//4. 🔹 Reflection / Framework usage	Many frameworks use it to load classes dynamically (Spring, Hibernate)

    public static void main(String[] args) throws Exception {
        Class.forName("basics.MyClass");//needs  fully qualified else class not found exception
    }

//Static block executed
}

class MyClass {
    static {
        System.out.println("Static block executed");
    }

    public MyClass(){
        System.out.println("Default Constructor");
    }
}