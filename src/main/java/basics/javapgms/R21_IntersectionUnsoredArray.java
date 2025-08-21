package basics.javapgms;

import java.util.HashSet;

public class R21_IntersectionUnsoredArray {
    public static void main(String[] args) {


        Integer []arr1 ={10,20,30,40};
        Integer []arr2={10,50,40};

        HashSet<Integer> hs=new HashSet<>();

        for(Integer i:arr2){
            hs.add(i);
        }

        for(Integer i:arr1){
            if(hs.contains(i)) {
                System.out.println(i);
            }
        }





    }
}
