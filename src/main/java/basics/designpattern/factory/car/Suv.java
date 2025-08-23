package basics.designpattern.factory.car;

public class Suv implements Car{
    @Override
    public void assemble() {
        System.out.println("From SUV");
    }
}
