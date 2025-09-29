package basics.javapgms;

import java.util.Arrays;

public class R_37ProductofArrayExceptITself {
    //Input:  nums = [1,2,3,4]
    //Output: [24,12,8,6]
    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4};
        int aux[] = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int sum = 1;
            for (int j = 0; j < nums.length;j++) {

                if (i == j) continue;
                sum = sum * nums[j];
            }
            aux[i] = sum;
        }

        System.out.println(Arrays.toString(aux));
        //[24, 12, 8, 6]
    }

}

