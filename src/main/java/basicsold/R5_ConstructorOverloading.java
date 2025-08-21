package basics;

public class R5_ConstructorOverloading {


    int age;
    String college;

    public R5_ConstructorOverloading() {
        System.out.println("This is default Constructor");
    }


    @Override
    public String toString() {
        return "R5_ConstructorOverloading{" +
                "age=" + age +
                ", college='" + college + '\'' +
                '}';
    }

    public R5_ConstructorOverloading(int age, String college) {
        this.age = age;
        this.college = college;
        System.out.println("using parametrized constructor");
    }

    public static void main(String[] args) {

        R5_ConstructorOverloading obj=new R5_ConstructorOverloading();
        System.out.println(obj);
//        This is default Constructor
//        R5_ConstructorOverloading{age=0, college='null'}

        R5_ConstructorOverloading obj2=new R5_ConstructorOverloading(30,"Kits");//using overloaded constructor
        System.out.println(obj2);
//        using overloaded constructor
//        R5_ConstructorOverloading{age=30, college='Kits'}

    }


}
