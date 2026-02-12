package basics;

import net.javacrumbs.jsonunit.core.internal.JsonUtils;
import org.testng.annotations.Test;

import java.util.Arrays;

public class R_Array {
    public static void main(String[] args) {

        int arr[] = new int[5];//array of 5 elements 0 to 4
        System.out.println(Arrays.toString(arr));//[0, 0, 0, 0, 0] default values
        System.out.println(arr.length);//5 size
        System.out.println(Arrays.stream(arr).count());//5

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        System.out.println(Arrays.binarySearch(arr, 5));//-6
        System.out.println(Arrays.binarySearch(arr, 4));//4


        // 2 d Array
        int[][] dblArray = {{1, 2}, {1, 2, 3}};
        for (int i = 0; i < dblArray.length; i++) {
            for (int j = 0; j < dblArray[i].length; j++) {
                System.out.print(dblArray[i][j] + " ");
            }
            System.out.println("");
        }
        //1 2
        //1 2 3

        // Via For each

        for (int[] a : dblArray) {
            for (int i : a) {
                System.out.print(i + " ");
            }
            System.out.println("");

        }
/*
1 2
1 2 3
 */
    }


    @Test
    public void Rough() {

        //1 d array
        int[] arr = new int[5];
        for (int i=0;i<arr.length;i++) {
            arr[i]=i+1;
        }
        System.out.println(Arrays.toString(arr));//[1, 2, 3, 4, 5]

        //2d array

        int [] [] myarr=new int[2][3];

        for(int i=0;i<myarr.length;i++){
            for (int j=0;j<myarr[i].length;j++){
                myarr[i][j]=Integer.parseInt(i+""+j);
            }
        }


        System.out.println(Arrays.toString(myarr));
    }



    @Test
    public void Rough09(){

        int arr[]={1,2,3,4,5};
        System.out.println(Arrays.toString(arr));


        //xx
        for(int i: arr){
            System.out.println("---separator---");
            System.out.println(i);
        }


        //double arr
        int [][] arr2d={{1,2,3},{4,5},{6,7,8,9}};
        for( int[] a:arr2d){
         for(int i:a){
             System.out.print(i);
         }
            System.out.println("row end");
        }

        //
        System.out.println("via looping");
        for(int r=0;r<arr2d.length;r++){
            for(int c=0;c<arr2d[r].length;c++){
                System.out.print(arr2d[r][c]);
            }
            System.out.println(" row end loop");
        }
    }
}
