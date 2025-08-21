package basics.javapgms;

public class R6_ReverseNumber {

    public static void main(String[] args) {
        int num = 5432;
        int rev = 0;

        while (num > 0) {
            rev = rev * 10 + num % 10; // extract last digit and build reverse
            num = num / 10; // remove last digit
        }

        System.out.println(rev); // Output: 2345
    }
}
