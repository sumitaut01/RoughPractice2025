package zzRough;

import java.util.HashMap;

public class RoughTCS {

    public static void main(String[] args) {

        HashMap<String,String> hm=new HashMap<>();
        hm.put("Name", "Neha");
        hm.put("Status", "Single");
        System.out.println(hm);//{Status=Single, Name=Neha}

        String name="Sumit Raut";
        HashMap<Character,Integer> hm1=new HashMap<>();
        for(Character c: name.toCharArray()){
          hm1.put(c,hm1.getOrDefault(c, 0)+1);
        }


        System.out.println(hm1);



    }

}


class ExtentReport implements  IReport{
    @Override
    public void print() {
        System.out.println("print implemented in extent report");
    }
}

interface IReport{
 void print();
 static void dummy(){
     System.out.println("This is dummy");
 }










}

