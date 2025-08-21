package zzRough;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class R1_MapPractice {

    public static void main(String[] args) {

        HashMap<String,String> hm=new HashMap<>();
        hm.put("Name", "Sumit");
        hm.put("College", "KITS");
        hm.put("Branch", "IT");

       //1
        Set<Map.Entry<String,String>> es=hm.entrySet();
        for (Map.Entry<String,String> e: es){
            System.out.println(e.getKey()+ " "+e.getValue());
        }

        //Branch IT
        //College KITS
        //Name Sumit

        System.out.println("----Separator--------");
        //2
        for (Map.Entry<String, String> es2:hm.entrySet()){
            System.out.println(es2.getKey()+ " "+es2.getValue());
        }
        //Branch IT
        //College KITS
        //Name Sumit
        System.out.println("----Separator--------");
        //3
        for(String s:hm.keySet()){
            System.out.println(s+="===>>"+hm.get(s));
            //Branch===>>IT
            //College===>>KITS
            //Name===>>Sumit
        }
        System.out.println("----Separator--------");
        //4 iterate values
        hm.values().forEach(v-> System.out.println(v));
        //IT
        //KITS
        //Sumit

        System.out.println("----Separator--------");
        System.out.println(hm);
        //{Branch=IT, College=KITS, Name=Sumit}
        System.out.println(hm.get("newkey"));//null as we havent added
        System.out.println(hm.getOrDefault("new key","new value"));//new value
        System.out.println(hm);
       // {Branch=IT, College=KITS, Name=Sumit}


        System.out.println("----Separator--------");

        hm.putIfAbsent("demonewkey","demonewvalue");
        System.out.println(hm);

        //{Branch=IT, College=KITS, demonewkey=demonewvalue, Name=Sumit}

        System.out.println("----Separator--------");
        hm.putIfAbsent("demonewkey","demonewvalueupdated");//it wont update the value as key was already there
        System.out.println(hm);





    }








}
