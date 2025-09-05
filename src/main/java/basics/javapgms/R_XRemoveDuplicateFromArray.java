package basics.javapgms;

import java.util.Arrays;

public class R_XRemoveDuplicateFromArray {

    //- is like dont care what you have.. no need to nullify
    //Input: nums = [0,0,1,1,1,2,2,3,3,4]
    //Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int i = 0;

        for (int j = 1; j < nums.length; j++) {
            // If the current element is not a duplicate,
            // move it to the unique section of the array
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
            System.out.println(j);
            System.out.println(Arrays.toString(nums));
        }

        System.out.println(Arrays.toString(nums));
        System.out.println(i + 1); // A bit more readable
    }
}
