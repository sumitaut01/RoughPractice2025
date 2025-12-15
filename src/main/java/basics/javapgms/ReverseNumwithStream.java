package basics.javapgms;


import org.testng.annotations.Test;

public class ReverseNumwithStream {

    @Test
    public void Reverse() {
        int num = 12345;

        int reversed = String.valueOf(num)
                .chars()
                .map(c -> c - '0')
                .reduce(0, (rev, digit) -> rev * 10 + digit);

        System.out.println(reversed); // 54321

    }
}
