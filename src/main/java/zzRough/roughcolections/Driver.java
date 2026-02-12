package zzRough.roughcolections;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Driver {

    public static void main(String[] args) {

        M1 m12=new M1("Sumit", 39);
        M1 m13=new M1("Neha", 36);
        M1 m11=new M1("Amit", 42);


        List<M1> lm1=new ArrayList<>();
        lm1.add(m11);
        lm1.add(m12);
        System.out.println(lm1);//[M1{name='Amit', age=42}, M1{name='Sumit', age=39}]







    }





}



