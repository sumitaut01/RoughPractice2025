package basics.streams;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Rough {

    @Test
    public void Rough1(){


        List<Integer> lstint=new ArrayList<>();

        lstint.add(12);
        lstint.add(11);
        lstint.add(0);
        lstint.add(9);




        List<String> lst=new ArrayList<>();

        lst.add("Neha");
        lst.add("Sumit");
        lst.add("Raj");
        lst.add("Rashmi");

        System.out.println(lst.stream().filter(s->s.startsWith("R")).map(s->s.toUpperCase()).collect(Collectors.toList()));






    }
}
