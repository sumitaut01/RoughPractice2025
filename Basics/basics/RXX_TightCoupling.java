package basics;

public class RXX_TightCoupling {
}

class Engine {
    void start() {
        System.out.println("Engine starting");
    }
}

class Car {
    Engine engine = new Engine(); // tight coupling

    void startCar() {
        engine.start();
    }
  //  Here:

//    Car creates and controls Engine → tightly coupled.
//
//    You cannot easily replace Engine with another type (like ElectricEngine).
}