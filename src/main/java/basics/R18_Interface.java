package basics;

public class R18_Interface implements I1, I2 {

//    All methods
//    are public abstract by default
//
//    Fields are
//    public static final by default
//
//    From Java 8+,
//    interfaces can
//    have default and static methods
//
//    From Java 9+,
//    private methods are
//    also allowed
//    in interfaces

    public static void main(String[] args) {

        I1 i1 = new R18_Interface();


        System.out.println(i1 instanceof I1);//true
        System.out.println(i1 instanceof R18_Interface);//true
        i1.sum(2, 3);//implemented sum from I1

        System.out.println(I1.min_bal);//cant be changed
        //I1.min_bal=300;// cant assign value to final variable


        I2 i2 = new R18_Interface();
        i2.mul(3, 4);//implemented mul from I2

        //500 all
        System.out.println(I1.min_bal);
        System.out.println(min_bal);
        System.out.println(R18_Interface.min_bal);


        //Accessing Private Method:




        R18_Interface ii=new R18_Interface();
        ii.mul(2,3);
        ii.sum(2,4);









    }

    @Override
    public void sum(int a, int b) {

        System.out.println("implemented sum from I1");
    }

    @Override
    public void mul(int a, int b) {
        System.out.println("implemented mul from I2");
    }
}


interface I1 {
 int min_bal=500;// its public static by default
    public void sum(int a, int b);


    //private Method in interface I1. It more of helper method inside interface
    private void showMsg(){
        System.out.println("-------from interface-----");
    }

}

interface I2 {


    public void mul(int a, int b);
}


