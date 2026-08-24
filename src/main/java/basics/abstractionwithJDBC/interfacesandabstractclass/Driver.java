package basics.abstractionwithJDBC.interfacesandabstractclass;

public class Driver {
    public static void main(String[] args) {


        Abstract3 abstract3=new Abstract3();

        abstract3.display();
        abstract3.myDisplay();


        AbstractDemo abstractDemo=new Abstract3();
        abstractDemo.display();

        Abstract2 abstract2=new Abstract3();
        abstract2.myDisplay();
        abstract2.display();






    }
}
