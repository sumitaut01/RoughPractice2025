package basics.comparablecomparable.comparator;
import java.util.*;

public class R2_ComparableDemo {

    public static void main(String[] args) {

        Comparator<Dem> aName=(a,b)->  a.name.compareTo(b.name);

        Dem d1=new Dem("Sumit",12);
        Dem d2=new Dem("Amit",2);
        Dem d3=new Dem("Neha",23);

        List<Dem> lDem=new ArrayList<>();

        lDem.add(d1);
        lDem.add(d2);
        lDem.add(d3);
        System.out.println(lDem);//[Dem{name='Sumit', age=12}, Dem{name='Amit', age=2}, Dem{name='Neha', age=23}]


        Collections.sort(lDem,aName);
        System.out.println(lDem);//[Dem{name='Amit', age=2}, Dem{name='Neha', age=23}, Dem{name='Sumit', age=12}]





    }


}



class Dem{

  String name;
  int age;

    public Dem(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dem{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
