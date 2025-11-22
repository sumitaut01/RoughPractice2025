package basics;

public class R16_Overloading_1 {

    public static void main(String[] args) {

        R16_Overloading_1 ol=new R16_Overloading_1();
        ol.sum(12,23);
        ol.sum(12.5,23.5);

    }
    public void sum(int a,int b){
        System.out.println("Integer based method called");


    }

    public void sum(double a,double b){
        System.out.println("Double based method called");
    }
}
