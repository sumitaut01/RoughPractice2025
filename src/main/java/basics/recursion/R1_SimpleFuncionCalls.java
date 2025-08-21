package basics.recursion;

public class R1_SimpleFuncionCalls {

    public static void main(String[] args) {

        System.out.println("Inside main");
        print1();
    }
    static void print1(){
        System.out.println(1);
        print2();
    }
    static void print2(){
        System.out.println(2);
        print3();
    }
    static void print3(){
        System.out.println(3);
        print4();
    }
    static void print4(){
        System.out.println(4);
    }

}
