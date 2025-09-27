package basics.collections.list;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ComparatorDemo {

    public static void main(String[] args) {
        List<D> dl = new ArrayList<>();
        dl.add(new D(12, "Sumit"));
        dl.add(new D(2, "Amit"));
        dl.add(new D(20, "Neha"));
        System.out.println(dl);
        //[D{age=12, name='Sumit'}, D{age=2, name='Amit'}, D{age=20, name='Neha'}]
        dl.sort(new AgeComparator());
        System.out.println(dl);
        //[D{age=2, name='Amit'}, D{age=12, name='Sumit'}, D{age=20, name='Neha'}]



    }
}


class AgeComparator implements Comparator<D> {
    @Override
    public int compare(D o1, D o2) {
        return o1.age - o2.age;
    }
}


class D {
    int age;
    String name;

    public D(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "D{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}