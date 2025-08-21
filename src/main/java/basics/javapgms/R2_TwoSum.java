package basics.javapgms;

import java.util.HashMap;

public class R2_TwoSum {

    //print sum of pairs who add upto 9
    public static void main(String[] args) {

        int []a={0,9,2,3,4,5,6,7,8,1};
        int eSum=9;

        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<a.length;i++){
                int expected=eSum-a[i];

                if(hm.containsKey(a[expected])) {
                    System.out.println(a[i] + " " + expected);
                }
                    hm.put(a[i],i);

        }
    }
}
