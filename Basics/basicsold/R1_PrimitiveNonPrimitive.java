package basics;

import java.util.Arrays;

public class R1_PrimitiveNonPrimitive {

    public static void main(String[] args) {

        int a=10;
        int b=a;
        b=20;

        System.out.println(a);//10
        System.out.println(b);//20
///Changing b doesn’t affect a, because they are two independent values in memory.

        int arr1[]={1,2,3};
        int arr2[]=arr1;

        arr2[0]=0;

        System.out.println(Arrays.toString(arr1));//[0, 2, 3]
        System.out.println(Arrays.toString(arr1));//[0, 2, 3]
        //



    }
}
