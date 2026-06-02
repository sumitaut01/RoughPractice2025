package basics.collections;

import java.util.ArrayList;
import java.util.List;

public class FailSafeIterators {

    public static void main(String[] args) {


        // removeif

        List<String> names=new ArrayList<>();

        names.add("Sumit");
        names.add("Amit");
        names.add("Neha");
        System.out.println(names);//[Sumit, Amit, Neha]

        names.removeIf(s->s.contains("u"));
        System.out.println(names);//[Amit, Neha]


        //2 Iterator.remove



        // stream filter


    }
}
