package basics;

//Encapsulation is the process of wrapping data (fields) and
//        code (methods) together in a single unit (class), and restricting direct access to some components.
// In Simple Terms:
//         Keep fields private
//
//Expose access through public getters/setters


import org.w3c.dom.ls.LSOutput;

//Example: Without Encapsulation (❌ Bad Practice)
//class Person {
//    public String name;
//    public int age;
//}
//    Anyone can change values directly, even invalid ones:
//        Person p = new Person();
//        p.age = -100; // ❌ No control




//🧠 Why Encapsulation?
//        Benefit	Description
//        Control	Add validation logic in setters
//        Security	Hide sensitive data
//        Maintainability	Change internal code without affecting outside
//        Readability & Testing	Cleaner public API



//Rule	Why
//        Make fields private	Protect direct access
//        Use public getters/setters	Expose safe access
//        Add validation in setters	Control data integrity
//        Helps future-proof your class	Change internals without breaking usage


public class R_Encapsulation01 {
    public static void main(String[] args) {
        Person p=new Person();

        System.out.println(p.getAge());//0
        p.setAge(12);
        System.out.println(p.getAge());//12

        //seeting negative

        p.setAge(-100);//wont do change as setter will check <0 condition
        System.out.println(p.getAge());// wont

    }

}


class Person {
    private String name;  // private = hidden
    private int age;

    // Getter
    public String getName() {
        return name;
    }

    // Setter
    public void setName(String name) {
        this.name = name;
    }

    // Getter
    public int getAge() {
        return age;
    }

    // Setter with validation
    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        }
    }
}
