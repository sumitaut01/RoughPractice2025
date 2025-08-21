package basics.streams;

import java.util.ArrayList;
import java.util.List;

public class R6_TakeWhileDropWhile {

    public static void main(String[] args) {

        List<Integer> lst=List.of(12,5,4,11,6,88);
       lst.stream().takeWhile(x->x>10).forEach(System.out::println);//12
        //notice that its stops at first faiure
    }
}
