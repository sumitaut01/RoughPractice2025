package basics.javapgms;

import java.util.HashMap;

public class R_XRamakant {

    public static void main(String[] args) {


        //Eg Input - Ramakant
//output - R1a1m1a1k1a2n1t1
// R1a1m1a2k1a3n1t1
        String str="Ramakant";
        HashMap<Character,Integer> hm=new HashMap<>();

        for(int i=0;i<str.length();i++){
            if(hm.containsKey(str.charAt(i))){
                hm.put(str.charAt(i),(hm.get(str.charAt(i))+1));
            }
            else{
                hm.put(str.charAt(i),1);
            }

            System.out.print(str.charAt(i));
            System.out.print(hm.get(str.charAt(i)));
        }


    }
}

//R1a1m1a2k1a3n1t1
