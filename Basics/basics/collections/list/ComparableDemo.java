package basics.collections.list;
import java.util.ArrayList;
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
    }
}





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
