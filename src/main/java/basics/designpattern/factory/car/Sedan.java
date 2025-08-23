package basics.designpattern.factory.car;

public class Sedan implements Car {
    @Override
    public void assemble() {
        System.out.println("From Sedan");
    }
}
