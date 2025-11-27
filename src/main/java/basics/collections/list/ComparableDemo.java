package basics.collections.list;
import lombok.ToString;
import org.apache.http.io.SessionOutputBuffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ComparableDemo {
    public static void main(String[] args) {
        Dummy d1=new Dummy(10);
        Dummy d2=new Dummy(20);
        Dummy d3=new Dummy(5);

        ArrayList<Dummy> ad=new ArrayList<>();
        ad.add(d1);
        ad.add(d2);
        ad.add(d3);
        ad.forEach(a-> System.out.println(a.age));
        //10
        //20
        //5
        Collections.sort(ad);
       ad.forEach(a-> System.out.println(a.age));
       //5
        //10
        //20


        //Arrays
        Dummy [] dArr={d1,d2,d3};
        System.out.println(Arrays.toString(dArr));//[Dummy(age=10), Dummy(age=20), Dummy(age=5)]
        Arrays.sort(dArr);

        System.out.println(Arrays.toString(dArr));//[Dummy(age=5), Dummy(age=10), Dummy(age=20)]







    }
}



//This ordering is referred to as the class's natural ordering,
// and the class's compareTo method is referred to as its natural comparison method.

//Lists (and arrays) of objects that implement this interface can be sorted automatically by
// Collections.sort (and Arrays.sort). Objects that implement this interface can be used as keys in
// a sorted map or as elements in a sorted set, without the need to specify a comparator.

@ToString
class Dummy implements Comparable<Dummy>{
    int age;

    public Dummy(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Dummy o) {
        return this.age-o.age;
    }
}
