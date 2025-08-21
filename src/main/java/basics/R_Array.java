package basics;

import java.util.Arrays;

public class R_Array {
    public static void main(String[] args) {


        int arr[]=new int[5];//array of 5 elements 0 to 4
        System.out.println(Arrays.toString(arr));//[0, 0, 0, 0, 0] default values
        System.out.println(arr.length);//5 size
        System.out.println(Arrays.stream(arr).count());//5

        for( int i=0;i<arr.length;i++){
            arr[i]=i;
        }

        System.out.println(Arrays.binarySearch(arr, 5));//-6
        System.out.println(Arrays.binarySearch(arr, 4));//4


        // 2 d Array
        int [][] dblArray={{1,2},{1,2,3}};
        for(int i=0;i<dblArray.length;i++){
            for(int j=0;j<dblArray[i].length;j++){
                System.out.print(dblArray[i][j]+" ");
            }
            System.out.println("");
        }
        //1 2
        //1 2 3




    }
}
