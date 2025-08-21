package basics.recursion;

//Find the position (index) of a target element in a sorted array.
//If element not found → return -1.
public class R3_BinarySearchRegular {
    public static void main(String[] args) {

        int arr[]={1,2,3,4,66,70,90};
        int find=70;

        int s=0;
        int e=arr.length-1;

        while(s<=e){
           int mid=(s+e)/2;

           if(arr[mid]==find){
               System.out.println(arr[mid]);
               return;
           }
           if(arr[mid]>find){
               e=mid-1;
           }
           else{
               s=mid+1;
           }
        }




    }
}
