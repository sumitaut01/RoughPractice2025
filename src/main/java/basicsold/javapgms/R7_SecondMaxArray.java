package basicsold.javapgms;
import java.util.Arrays;

public class R7_SecondMaxArray {
    public static void main(String[] args) {

        int a[]={15,3,12,7};
        int max = Integer.MIN_VALUE;
        int sMax = Integer.MIN_VALUE;
        for(int i=0;i<a.length;i++){
            if(max<a[i]){
                sMax=max;
                max=a[i];
            }
            else if(max>a[i] &&sMax<a[i]){
                sMax=a[i];
            }
        }
        System.out.println(Arrays.toString(a));
        System.out.println(max +" "+sMax);
    }
}
