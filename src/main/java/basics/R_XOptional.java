package basics;

import java.util.Optional;

//Optional is a container object in Java that may or may not contain a non-null value. It was introduced in Java 8 to
// address a common problem: NullPointerException. Instead of returning null to represent the absence of a value, a method can return an Optional. This forces the caller to explicitly handle the case where the value isn't present, making code safer and more readable.
//Where It's Used
//Optional is primarily used as a method return type to indicate that a method might not have a result. It's not intended to be used as a field in a class, a method parameter, or in a collection.
public class R_XOptional {
    public static void main(String[] args) {

        Test t = new Test("Sumit", null);

        String age=Optional.ofNullable(t.name).orElse("no");
        String college=Optional.ofNullable(t.college).orElse("no");//no


    }
}

    class Test{

        String name;
        String college;

        public Test(String name, String college) {
            this.name = name;
            this.college = college;
        }
    }




