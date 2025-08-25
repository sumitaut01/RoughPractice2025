package basics.collections.set;

import java.util.HashSet;
import java.util.Iterator;

public class R1_HashSet {

    public static void main(String[] args) {

        HashSet<String> str=new HashSet<>();
        str.add("Sumit");
        str.add("Neha");
        str.add("Amit");
        str.add(null);
        System.out.println(str);
        //[null, Neha, Amit, Sumit]

        //2 Via Iterator
        Iterator<String> iStr=str.iterator();
        while(iStr.hasNext()){
            System.out.println(iStr.next());
        }
        //null
        //Neha
        //Amit
        //Sumit

        //3 For each
       str.forEach(s-> System.out.println(s));
        //null
        //Neha
        //Amit
        //Sumit

   // 4 For each
        System.out.println("via for loop");
        for(String s:str){
            System.out.println(s);
        }
        //via for loop
        //null
        //Neha
        //Amit
        //Sumit






    }
}
