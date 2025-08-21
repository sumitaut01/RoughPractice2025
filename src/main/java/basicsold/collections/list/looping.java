package basicsold.collections.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class looping {

    public static void main(String[] args) {

        List<String> aStr = new ArrayList<>();
        aStr.add("Sumit");
        aStr.add("Sagar");
        aStr.add("Neha");
//#1
        for (String s : aStr) {
            System.out.println(s);
        }
//        Sumit
//                Sagar
//        Neha

  //2
        aStr.forEach(s-> System.out.println(s));//same o/p

//3
        aStr.forEach(System.out::println);//same

        //4 Iterator
        Iterator<String> it = aStr.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }


    }
}
