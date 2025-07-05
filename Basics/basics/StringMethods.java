package basics;

import java.util.Arrays;

public class StringMethods {

    public static void main(String[] args) {


        String s1="Sumit";//SCP
        String s2="Sumit";//SCP
        String s3=new String("Sumit");

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








    }
}
