package basics;

public class R9_InstanceBlock {
//    An instance block is a block of code without any name or keyword like static, that runs:
//    Every time an object is created.
//    Just before the constructor is called.


//    🔹 Why Use Instance Block?
//    Purpose	Example
//    Common code for all constructors	Avoid duplication
//    Object-level setup logic	Logging, validation, init routines

    {
        // instance block
        System.out.println("first Instance block executed");
    }

    {
        // instance block
        System.out.println("second Instance block executed");
    }

public R9_InstanceBlock(){

    System.out.println("Default Constructor");
}

    public static void main(String[] args) {

        R9_InstanceBlock obj1=new R9_InstanceBlock();
        R9_InstanceBlock obj2=new R9_InstanceBlock();
    }


//    first Instance block executed
//    second Instance block executed
//    Default Constructor

//    first Instance block executed
//    second Instance block executed
//    Default Constructor
}
