package basics.collections.set;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class R2_LinkedHashSet {

    public static void main(String[] args) {

        Set<String> str=new LinkedHashSet<>();
        str.add("Sumit");
        str.add("Neha");
        str.add("Amit");
        str.add(null);
        System.out.println(str);
        //[Sumit, Neha, Amit, null]

    }
}
