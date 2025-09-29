package zzRough;

import org.apache.http.io.SessionOutputBuffer;



class RoughOOO {
    public static void main(String[] args) {

        RoughImpl rough=new RoughImpl();
        rough.checkBal();
        System.out.println("from intercae "+myInterface.mix_bal);
    }
}


//    bal from  class500
//        implemented
//    from intercae 500

 class RoughImpl implements myInterface {
    @Override
    public void checkBal() {
        System.out.println( "bal from  class" +mix_bal);
        System.out.println("implemented");

    }
}



interface  myInterface{
    int mix_bal=500;

     void checkBal();

}
