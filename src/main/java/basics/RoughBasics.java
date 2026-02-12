package basics;

public class RoughBasics extends  MyAbstract  {
    int age;
    RoughBasics(int age,String name){
     super(name);
        System.out.println("Constructor in child called with age: "+age  +" name:"+name);
    }

    @Override
    void myAbsMethod() {
        System.out.println("Abstract implemented");
    }


    public static void main(String[] args) {
        RoughBasics r1=new RoughBasics(40,"sumit");
    }
}


abstract class MyAbstract {
    String name;
    abstract void myAbsMethod();
     void myNonAbsMethod(){
         System.out.println("this is no abstract method");
     }
    MyAbstract(String name){
        this.name=name;
        System.out.println("constructor from parentcalled.. value field initialized with "+name);
    }
}
