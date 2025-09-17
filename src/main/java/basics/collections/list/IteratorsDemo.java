package basics.collections.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class IteratorsDemo {

    public static void main(String[] args) {


        List<String> lst=new ArrayList<>();
        lst.add("Sumit");
        lst.add("Test");
        lst.add("Neha");
        System.out.println(lst);//[Sumit, Test, Neha]

        //1
        Iterator<String> itr=lst.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }
        //Sumit
        //Test
        //Neha

        while(itr.hasNext()){
            itr.next();
            itr.remove();
        }
        System.out.println("Printing"+lst);//this will still print the list as itr.hasnext has already moved in previous loop

        Iterator<String> itr2=lst.iterator();
        while(itr2.hasNext()){
            itr2.next();
            itr2.remove();
        }
        System.out.println("Printing"+lst);//Printing[]



        //2
        //

     ListIterator<String> litr=lst.listIterator();

     litr.hasPrevious();
     litr.hasNext();
     litr.add("C");
     litr.remove();


     //
        lst.forEach(System.out::println);




    }
}
