package basics.javapgms;

public class R24_SubArrayWithZeroSum {

    //-3 +2 +1
    public static void main(String[] args) {

        int []arr={-5,1,2,1,1};


       // 4
        for(int i=0;i<arr.length;i++){
            int sum=Integer.MIN_VALUE;
            int curr=0;
            for (int j=i;j<arr.length;j++){

                curr=curr+arr[j];
                if(curr==0){
                    System.out.println(i +" "+j);
                    break;
                }
            }
        }
    }
}
