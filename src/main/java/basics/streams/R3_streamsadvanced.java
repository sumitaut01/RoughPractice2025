package basics.streams;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class R3_streamsadvanced {


    public static void main(String[] args) {
        //1 Set to stream to array
        Set<Integer> si=new HashSet<>();
        si.add(1);
        si.add(2);
        si.add(3);
        si.add(0);
        System.out.println(si);//[0, 1, 2, 3]

        int[] uniqueArr = si.stream()
                .mapToInt(Integer::intValue)//x -> x.intValue()
                .toArray();
        System.out.println(Arrays.toString(uniqueArr));


    }




}
