package basics.javapgms;

import org.testng.annotations.Test;

public class R6_ReverseNumber {

    public static void main(String[] args) {
        int num = 5432;
        int rev = Integer.MIN_VALUE;

        while (num > 0) {
            rev = rev * 10 + num % 10; // extract last digit and build reverse
            num = num / 10; // remove last digit
        }

        System.out.println(rev); // Output: 2345
    }


    @Test
    public void Rough(){
        int num = 5432;
        int rev = Integer.MIN_VALUE;
        while(num>0){
         rev=rev*10 +num%10;
         num=num/10;
        }

        System.out.println(rev);


    }
}
