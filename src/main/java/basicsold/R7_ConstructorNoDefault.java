package basics;

public class R7_ConstructorNoDefault {

    int age;
    String name;

    public R7_ConstructorNoDefault(int age, String name) {
        this.age = age;
        this.name = name;
    }
}

class Demo extends  R7_ConstructorNoDefault{


    public Demo(int age, String name) {
        super(age, name);// if we dont do this compiler will error out or will ask us to introduce aa deafult constor in paret
    }
}
