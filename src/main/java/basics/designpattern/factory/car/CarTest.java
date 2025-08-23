package basics.designpattern.factory.car;

public class CarTest {

    public static void main(String[] args) {

        CarFactory carFactory=new CarFactory();
        carFactory.getCar("suv").assemble();//From SUV

        carFactory.getCar("truck").assemble();//  From Truck
    }
}
