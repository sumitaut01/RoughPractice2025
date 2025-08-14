package basics.javapgms;

public class R19_FactorialRecursion {

    public static void main(String[] args) {

        System.out.println(recurssion(5));
    }

    public static int recurssion(int n){
        if(n==1) return 1;
        return n* recurssion(n-1);
    }
}
