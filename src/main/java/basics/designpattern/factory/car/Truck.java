package basics.designpattern.factory.car;

public class Truck implements Car{
    @Override
    public void assemble() {
        System.out.println("From Truck");
    }
}
