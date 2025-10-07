package basics.javapgms;

public class R_XSubstringForString {
    public static void main(String[] args) {

        //abc


        String txt="abc";

        for(int i=0;i<txt.length();i++){
            for (int j=i+1;j<=txt.length();j++){
                System.out.println(txt.substring(i,j));
            }
        }

//        a
//                ab
//        abc
//                b
//        bc
//                c
    }
}
