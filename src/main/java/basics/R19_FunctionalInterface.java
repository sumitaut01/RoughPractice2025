package basics;

public class R19_FunctionalInterface {

    public static void main(String[] args) {
        TestInterface test=new TestInterface() {
            @Override
            public void run() {
                System.out.println("Method implemented");
            }
        };
        test.run();;//Method implemented
        test.test();//default method
        TestInterface.staticMethod();//static method


        //with lambda
        TestInterface testx= () -> System.out.println("Method implemented");
        test.run();;//Method implemented
        test.test();//default method
        TestInterface.staticMethod();//static method


    }
}



@FunctionalInterface//interface with Single Abstract Method
interface TestInterface{
    public void run();

    //public void run2();// them moment we add one more, we get message about removing @FunctionalInterface
    default void test(){
        System.out.println("Default MEthod");
    }
    static void staticMethod(){
        System.out.println("staticMethod method");
    }
}