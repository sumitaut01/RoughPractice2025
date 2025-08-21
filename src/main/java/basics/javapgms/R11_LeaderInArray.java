package basics.javapgms;

public class R11_LeaderInArray {

    public static void main(String[] args) {


        int []arr= new int[]{16, 17, 5, 4, 3, 2};

        int max=arr[arr.length-1];
        for(int i=arr.length-2;i>=0;i--){
         if(arr[i]>max){
             System.out.println(arr[i]);
             max=arr[i];
         }
        }
    }
}
//3
//4
//5
//17