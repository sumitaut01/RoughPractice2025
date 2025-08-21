package basics;

public class R15_PolyMorphism {
    //runtitme polymorphism //also know as overriding

    public static void main(String[] args) {

        Animal a=new Animal();
        a.walk();//parent walk
        a.nonOverride();//parent specific
//
//        this is from parent:walk
//        this is from parent:nonOverride

        Dog c=new Dog();
        c.walk();// overriden child
        c.childOnlyMethod();//child specific
//        this is from child:walk
//        this is child only method


        Animal a1=new Dog();
        a1.walk();// overriden child
        a1.nonOverride();
//        this is from child:walk
//        this is from parent:nonOverride


    }
}



class Animal{

    public void walk(){

        System.out.println("this is from parent:walk");

    }

    public void nonOverride(){
        System.out.println("this is from parent:nonOverride");
    }
}

class Dog extends Animal{
    public void walk(){
        System.out.println("this is from child:walk");
    }

    public void childOnlyMethod(){
        System.out.println("this is child only method");
    }

}
