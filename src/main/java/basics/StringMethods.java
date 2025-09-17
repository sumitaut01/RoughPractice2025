package basics;

import java.util.Arrays;

public class StringMethods {

    public static void main(String[] args) {


        String s1="Sumit";//SCP
        String s2="Sumit";//no new string in SCP.  s2 just points to s1
        String s3=new String("Sumit");//heap memory has "sumit" as well
        /*

hashCode()
For String, it’s content-based.
All strings with the same sequence of characters have the same hashCode(),
regardless of whether they live in SCP or heap.
         */

        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
        System.out.println(s3.hashCode());
        //80245910
        //80245910
        //80245910

        //Notice, we have used  , which is memory based

        System.out.println(System.identityHashCode(s1));
        System.out.println(System.identityHashCode(s2));
        System.out.println(System.identityHashCode(s3));
        //2104457164
        //2104457164
        //1521118594  --- different for s3

        //Equals and ==
        System.out.println(s1==s2);//true
        System.out.println(s1==s3);//false
        System.out.println(s1.equals(s2));//true
        System.out.println(s1.equals(s3));//true





        System.out.println(s1.charAt(0));//s
        //System.out.println(s1.charAt(50));//StringIndexOutOfBoundsException

        System.out.println(s1.indexOf("t"));//4
        System.out.println(s1.indexOf("x"));//-1


        //
        for(char ch: s1.toCharArray()){
            System.out.println(ch);
        }
//        S
//                u
//        m
//                i
//        t


        System.out.println(s1.length());//5
        System.out.println(s1.replace("S","X"));//Xumit
        System.out.println(Arrays.toString((s1.split(""))));//[S, u, m, i, t]

        System.out.println(s1.substring(1));//umit

        System.out.println(s1.substring(0,1));//S

        System.out.println(s1.concat("XX"));//SumitXX

        System.out.println(s1.startsWith("S"));//true
        System.out.println(s1.endsWith("S"));//false


        System.out.println(s1.contentEquals(new StringBuffer("sagar")));//false


        String a1="Apple";
        String a2="Banana";

        //Lexographic comparison
        //A is 65 B is 66  65-66 is negative
        System.out.println(a1.compareTo(a2));//-1

        System.out.println(a2.compareTo(a1));//1

        System.out.println(a1.compareTo("Apple"));//0


        String test="raftaar";
        System.out.println(test.replace("r", "X"));//XaftaaX


        String test2="XaftaaX";
        System.out.println(test2.replaceFirst("X", "r"));//raftaaX


        String test3="#12XaftaaX66%^";
        System.out.println(test3.replaceAll("[a-z A-z]", ""));//#1266%









    }
}
