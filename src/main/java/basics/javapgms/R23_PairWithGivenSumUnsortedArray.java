package basics.javapgms;

import java.util.HashSet;

public class R23_PairWithGivenSumUnsortedArray {

    public static void main(String[] args) {


    Integer [] arr={8,3,4,2,5};

        Integer sum=6;

        HashSet<Integer> hs=new HashSet<>();
        for(int i: arr) {
            if (hs.contains(6-i)){
                System.out.println( arr[i]+ " "+ (6-arr[i]));
                break;
            }
            else{
                hs.add(i);
            }
        }

        }




}
