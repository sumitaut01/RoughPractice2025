package basics.javapgms;

public class RX_ArrayCount {


    public static void main(String[] args) {


        int arr[] = {1, 2, 3, 777, 5, 666, 77, 88, 123};

        for (int num : arr) {

            int temp = num;
            int lastDigit = num % 10;

            int count = 0;
            boolean allSame = true;

            while (temp > 0) {
                int digit = temp % 10;

                if (digit != lastDigit) {
                    allSame = false;
                    break;
                }

                count++;
                temp /= 10;
            }

            // Only print if all digits are same AND more than 1 digit
            if (allSame && count > 1) {
                System.out.println(num + " -> count: " + count);
            }
        }
    }
}

