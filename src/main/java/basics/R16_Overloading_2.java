package basics;

public class R16_Overloading_2 {
//Overloading with int, long, float, double

    public static void main(String[] args) {

        R16_Overloading_2 ol=new R16_Overloading_2();
        ol.sum(12);//Integer based method called
        ol.sum(12.5f);//Double based method called

    }
    public void sum(int a){

        System.out.println("Integer based method called");


    }

    public void sum(double a){

        System.out.println("Double based method called");

    }
}
