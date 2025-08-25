package basics;

public class Rx_IncrementDecOperatorsXOR {

    public static void main(String[] args) {
      //  1. Post-Increment / Post-Decrement

        int a = 5;
        int b = a++;  // b = 5, a = 5
       // The original value is used first, then incremented.


//        2. Pre-Increment / Pre-Decrement
        int a1 = 5;
        int b1 = ++a;  // a = 6, b = 6
  //      The value is incremented first, then used.


    }
}
