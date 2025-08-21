package basics.javapgms;

public class R31_Fibonacci {

    public static void main(String[] args) {

        // 0 1 1 2 3 5

        int first=0;
        int second=1;

        System.out.print(first+" ");
        System.out.print(second+" ");

        for(int i=0;i<=3;i++){
            int c=first+second;
            System.out.print(c+" ");
            first=second;
            second=c;
        }
//0 1 1 2 3 5
    }
}
