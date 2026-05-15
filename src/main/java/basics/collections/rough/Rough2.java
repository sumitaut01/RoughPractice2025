package basics.collections.rough;

import org.testng.annotations.Test;

import java.util.*;

public class Rough2 {



    @Test
    public void Template(){




    }



    @Test
    public void ListWork(){

        List<String> lst=new ArrayList<>();
        lst.add("Sumit");
        lst.add("Neha");
        System.out.println(lst);//[Sumit, Neha]
        lst.addFirst("Amit");
        System.out.println(lst);//[Amit, Sumit, Neha]


        System.out.println(lst.indexOf("Neha"));//2
        System.out.println(lst.indexOf("nivi"));//-1
        System.out.println(lst.contains("Neha"));//true




        //ArrayList





    }


    @Test
    public void SetDemo(){

        Set<String> names=new HashSet<>();

        names.add("sumit");
        names.add("sumit");
        names.add("neha");

        System.out.println(names);//[neha, sumit]


        for(String s:names){
            System.out.println(s);
        }


        //

        names.clear();
        System.out.println("Printing after clearing");
        System.out.println(names);//Printing after clearing
        //[]
    }


    @Test
    public void Map(){


        TreeMap<String,String> tm=new TreeMap<>();

        tm.put("name", "sneha");
        tm.put("city", "nagpur");

        System.out.println(tm);//{city=nagpur, name=sneha}
   //notice c key came first


        TreeMap<String,String> tm2=new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
              return  o1.length()- o2.length();
            }
        });

        tm2.putAll(tm);

        System.out.println("printing 2");
        System.out.println(tm2);//{city=sneha}




    }
}
