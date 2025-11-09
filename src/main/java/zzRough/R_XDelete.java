package zzRough;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class R_XDelete {

    public static void main(String[] args) {
        TX x1 = new TX(12, "Sagar");
        TX x2 = new TX(21, "Neha");
        List<TX> lTx=new ArrayList<>();

        lTx.add(x1);
        lTx.add(x2);
        System.out.println(lTx);
        //[TX{sal=12, name='Sagar'}, TX{sal=21, name='Neha'}]



        //age comparator
        Comparator<TX> mycomp= new Comparator<TX>() {
            @Override
            public int compare(TX o1, TX o2) {
               return -o1.sal-o2.sal;
            }
        };

        // name comparator
        Comparator<TX> nameComp=(a,b)-> -a.name.compareTo(b.name);


        Collections.sort(lTx,mycomp);
        System.out.println(lTx);
        //[TX{sal=21, name='Neha'}, TX{sal=12, name='Sagar'}]   // notice - in compa



        Collections.sort(lTx,nameComp);
        System.out.println(lTx);//[TX{sal=12, name='Sagar'}, TX{sal=21, name='Neha'}]



    }


}



class TX{
   int sal;
   String name;

   public  TX(int salX,String nameX){
       sal=salX;
       name=nameX;

   }

    @Override
    public String toString() {
        return "TX{" +
                "sal=" + sal +
                ", name='" + name + '\'' +
                '}';
    }
}


