package basics.javapgms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class R_XStreamCapitalList {

    public static void main(String[] args) {


        List<String> lst=new ArrayList<>();

        lst.add("Sumit");
        lst.add("Neha");
        lst.add("Raj");


        System.out.println(lst);//[Sumit, Neha, Raj]

        // get all names with length >3 ,make them uppercase,collect to list
        lst.stream().filter(s->s.length()>3).map(String::toUpperCase).collect(Collectors.toList()).
                forEach(x-> System.out.println(x));
        //SUMIT
        //NEHA
    }
}
