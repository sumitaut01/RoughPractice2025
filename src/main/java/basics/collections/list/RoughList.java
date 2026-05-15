package basics.collections.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RoughList {

    public static void main(String[] args) {

        List<String> lstr = new ArrayList<>();
        lstr.add("Neha");
        lstr.add("Amit");
        lstr.add("Shital");
        System.out.println(lstr);//[Neha, Amit, Shital]


        System.out.println(lstr.contains("Neha"));//true
        System.out.println(lstr.indexOf("Neha"));//0
        System.out.println(lstr.indexOf(-1));//-1


        //looping
        for (String s : lstr) {
            System.out.print(s + " "); //Neha Amit Shital
        }

        //
        Iterator<String> it = lstr.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        //looping with stream
        System.out.println("looping with stream");
        lstr.stream().forEach(s-> System.out.println(s));



    }
}
