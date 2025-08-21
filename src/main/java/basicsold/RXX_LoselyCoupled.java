package basics;


//Coupling refers to how much one class or module depends on another.
//
//        Tight Coupling: High dependency (bad for flexibility)
//
//        Loose Coupling: Low dependency (preferred)
public class RXX_LoselyCoupled {

    EngineNew engineNew=new PetrolEngine();
    CarNew carNew=new CarNew(engineNew);

}



interface EngineNew{
    public void start();
}

class PetrolEngine implements  EngineNew{
    @Override
    public void start() {
        System.out.println("Inside Petrol Engine");
    }
}

class CarNew{
private  EngineNew engineNew;
    CarNew(EngineNew engineNew){
    engineNew.start();
}
}
