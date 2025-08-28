package basics.autoboxing;

import java.util.ArrayList;

public class R1_ {

    public static void main(String[] args) {


        int x=3;
        ArrayList<Integer> al=new ArrayList<>();
        al.add(3);// behind the scenes, autoboxing happening


        Integer i1=Integer.valueOf(1);
        Integer i2=Integer.valueOf("3");
        Integer i3=Integer.valueOf("01",2);

        System.out.println(i1);//1
        System.out.println(i2);//3
        System.out.println(i3);//1

    }
}
