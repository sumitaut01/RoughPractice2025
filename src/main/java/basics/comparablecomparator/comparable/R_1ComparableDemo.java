package basics.comparablecomparator.comparable;

import com.github.tomakehurst.wiremock.junit.Stubbing;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class R_1ComparableDemo {

    public static void main(String[] args) {

        Emp emp1=new Emp(10, "Sumit");
        Emp emp2=new Emp(20, "Neha");
        Emp emp3=new Emp(10, "Amit");

        List<Emp> eList=new ArrayList<>();

        eList.add(emp1);
        eList.add(emp2);
        eList.add(emp3);

        System.out.println(eList);//[Emp{sal=10, name='Sumit'}, Emp{sal=20, name='Neha'}, Emp{sal=10, name='Amit'}]
        Collections.sort(eList);
        System.out.println(eList);//[Emp{sal=10, name='Amit'}, Emp{sal=20, name='Neha'}, Emp{sal=10, name='Sumit'}]


    }

}



class Emp implements Comparable<Emp> {
 int sal;
 String name;

    public Emp(int sal, String name) {
        this.sal = sal;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "sal=" + sal +
                ", name='" + name + '\'' +
                '}';
    }
    @Override
    public int compareTo(Emp o) {
        return this.name.compareTo(o.name);
    }
}

