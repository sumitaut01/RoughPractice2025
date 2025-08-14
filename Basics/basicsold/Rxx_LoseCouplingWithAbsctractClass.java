package basics;

public class Rxx_LoseCouplingWithAbsctractClass {
    public static void main(String[] args) {

        EngineTwo engineTwo = new ElectricEngine();
        CarTwo two = new CarTwo(engineTwo);
        two.startCar();
        two.stopCar();
//starte electricengine
//Stopping Engine

    }
}


abstract class EngineTwo {
    public abstract void start();

    public void stop() {
        System.out.println("Stopping Engine");
    }
}

class ElectricEngine extends EngineTwo {
    @Override
    public void start() {
        System.out.println("starte electricengine");
    }
}


class CarTwo {
    EngineTwo engineNew;

    //constructor injection
    CarTwo(EngineTwo engineNew) {
        this.engineNew = engineNew;
    }

    void startCar() {
        engineNew.start();
    }

    void stopCar() {
        engineNew.stop();
    }

}

