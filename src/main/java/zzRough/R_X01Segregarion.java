package zzRough;

import java.util.Arrays;

public class R_X01Segregarion {

    public static void main(String[] args) {

        int arr[]={1,0,0,1,0};
        int right=arr.length-1;
        int left=0;

        System.out.println(Arrays.toString(arr));//[1, 0, 0, 1, 0]
        while(left<right){
            while(arr[left]!=1 &&left<right){
                left++;
            }
            while(arr[right]!=0 && left<right){
                right--;
            }
            //now we assume that they can be changed
            int temp=arr[left];
            arr[left]=arr[right];
            arr[right]=temp;
            left++;
            right--;
        }

        System.out.println(Arrays.toString(arr));//[0, 0, 0, 1, 1]
    }


}
