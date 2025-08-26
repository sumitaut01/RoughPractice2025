package basics.javapgms;

public class RX_5to1Recursion {

    public static void main(String[] args) {


        System.out.println(print(5));

        printIncre(5);
    }

    static int print(int n) {

        if (n == 1) return 1;
        System.out.println(n);
        return print(n - 1);
        //5
        //4
        //3
        //2
        //1
    }


    static void printIncre(int n) {

        if (n == 0) return;
        print(n - 1);
        System.out.println(n);
//        1
//        4
//        3
//        2
//        5
//
    }
}



