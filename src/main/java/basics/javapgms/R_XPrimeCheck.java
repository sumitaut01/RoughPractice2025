package basics.javapgms;

public class R_XPrimeCheck {


    public static void main(String[] args) {


        int number = 17;
        // Assume the number is prime initially
        boolean bPrime = true;

        // Handle edge cases for numbers <= 1
        if (number <= 1) {
            bPrime = false;
        } else {
            // Check for divisibility from 2 up to the number - 1
            for(int i = 2; i < number; i++) {

                if ((number % i) == 0) {
                    // Found a divisor, so it's NOT prime
                    bPrime = false;
                    break; // No need to check further
                }
                // No 'else' needed here, bPrime remains true until a divisor is found
            }
        }

        System.out.println(bPrime);
    }
}