package zzRough;

public class R2_StringWork {

    public static void main(String[] args) {

        String s1="sumit";
        String s2="sumit";


        System.out.println(s1==s2);//true
        System.out.println(s1.equals(s2));//true

        String s3=new String("sumit");// just heap object. Sumit already in scp

        System.out.println(s1==s3);//false
        System.out.println(s1.equals(s3));//true

        String s4=s1.concat("Raut");//sends Raut to SCP and created new heap object with "sumitRaut"
        //please note scp won't have sumitRaut

    }
}
