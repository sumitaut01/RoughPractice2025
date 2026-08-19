package basics.collections.rough;

import org.testng.annotations.Test;

import java.util.*;

public class Rough1 {

    public static void main(String[] args) {
        Set<String> hs=new HashSet<>();
        System.out.println(hs.add("sumit"));//true
        System.out.println(hs.add("sumit"));//false
        System.out.println(hs.add("neha"));//true

        System.out.println(hs.remove("neha"));//true
        System.out.println(hs.remove("neha"));//false
    }


    @Test
    public void StringTest(){
     String name="sumit Raut";
     for(int i=name.length()-1;i>=0;i--){
         System.out.print(name.charAt(i));//tuaR timus
     }


        System.out.println(name.indexOf("S"));//-1
        System.out.println(name.indexOf("z"));//-1

        System.out.println(name.indexOf("s"));//0

        System.out.println(name.substring(0,1));//s


        System.out.println(name.replace("s", "S"));//Sumit Raut


        System.out.println("-----separator-----");

        System.out.println(name);

        System.out.println(name.replaceAll("[a-z]", ""));//R

    }



    @Test
    public void TreeMapDemo(){

        Map<String,Integer> hm=new TreeMap<>();
        hm.put("B", 22);
        hm.put("A", 23);
        hm.put("C", 21);
        System.out.println(hm);//{A=23, B=22, C=21}  sorted automatically





    }


    @Test
    public void TreeSetDemo(){



    }


}
