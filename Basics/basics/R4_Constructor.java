package basics;

public class R4_Constructor {

//    A static field belongs to the class, not to any specific object.
//    A constructor is used to initialize instance variables (i.e., those tied to each object).
//    static fields are not tied to object creation, so constructors don’t usually initialize them — although they can

    //***When you use a static field inside a constructor, many IDEs (like IntelliJ IDEA or Eclipse) may show a warning, such as:

    int age;
    static String name;


    public R4_Constructor(int age,String name) {
        this.age = age;
        this.name=name;
    }


    public static void main(String[] args) {

        R4_Constructor obj1=new R4_Constructor(30,"sumit");
        System.out.println(obj1);


    }

    //Overloading toString() from  object to print some object state
    @Override
    public String toString() {
        return "R4_Constructor{" +
                "age=" + age + "name="+name+
                '}';
    }
}
