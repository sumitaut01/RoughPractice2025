package basics.javapgms;

import org.testng.annotations.Test;

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



    @Test
    public void twosumwithindexes(){

        int []a={0,9,2,3,4,5,6,7,8,1};
        int eSum=9;

        HashMap<Integer,Integer> hm=new HashMap<>();

        for(int i=0;i<a.length;i++){
             int desired=eSum-a[i];
             boolean bfound=false;
            if(hm.containsKey(desired)){
                bfound=true;

            }
            hm.put(a[i],i);
            if(bfound){
                System.out.println("found pair "+ a[i] +" "+desired +"at indices "+i +" & "+ hm.get(desired));
            }
        }

//        found pair 9 0at indices 1 & 0
//        found pair 5 4at indices 5 & 4
//        found pair 6 3at indices 6 & 3
//        found pair 7 2at indices 7 & 2
//        found pair 1 8at indices 9 & 8
    }




    @Test
    public void Rough(){


        int []a={0,9,2,3,4,5,6,7,8,1};
        int eSum=9;

        HashMap<Integer,Integer> hm=new HashMap<>();

        for(int i=0;i<a.length;i++){
            int desired=eSum-a[i];

            if(hm.containsKey(desired)){
                System.out.println(desired +" "+a[i]);
            }
            else{
                hm.put(a[i],i);
            }


        }


    }
}
