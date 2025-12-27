package basics.javapgms;

public class ThirdHighest {
    public static Integer getThirdHighest(int[] nums) {
        long first = Long.MIN_VALUE;
        long second = Long.MIN_VALUE;
        long third = Long.MIN_VALUE;

        for (int x : nums) {
            if (x > first) {
                third = second;
                second = first;
                first = x;
            } else if (x > second && x != first) {
                third = second;
                second = x;
            } else if (x > third && x != first && x != second) {
                third = x;
            }
        }

        return (third == Long.MIN_VALUE) ? null : (int) third;
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 30, 25};
        System.out.println("3rd Highest: " + getThirdHighest(arr)); // Output: 20
    }
}