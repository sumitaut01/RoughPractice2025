package basics.javapgms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ListToMap {

    public static void main(String[] args) {

        List<String> names=new ArrayList<>();

        names.add("Sumit");
        names.add("Neha");
        names.add("Pooja");
        names.add("Raghav");


        System.out.println(names.stream().collect(Collectors.toMap( s->s,s->s.length())));
        //{Raghav=6, Neha=4, Pooja=5, Sumit=5}




    }
}
