package basics.functionalinterface;

public class R1_functionalInterface {

    public static void main(String[] args) {
        run r1=()-> System.out.println("I am running");
        r1.demo();//I am running


        runAgain.staticMethod(); //static method is accessible directly
        //static allowed



    }

    //functional interface can only have one abstract methods
    interface run{
        void demo();
    }


    @FunctionalInterface
    interface runAgain{
        void demo1();
        //void demo2();// cant have second abstract method inside @FunctionalInterface

        public static void staticMethod(){
            System.out.println("static allowed");
        }

        //default method
        public default void defaultMethod(){
            System.out.println("default allowed");
        }
    }

}
