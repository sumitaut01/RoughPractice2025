package zzRough.roughcolections;

public class M1 implements Comparable<M1>{

    String name;
    Integer age;

    @Override
    public String toString() {
        return "M1{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public  M1(String name, Integer age){
        this.name=name;
        this.age=age;
    }

    @Override
    public int compareTo(M1 o) {
        return -this.age.compareTo(o.age);
    }



}



