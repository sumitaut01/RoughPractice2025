package basics.designpattern.factory.car;

public class CarFactory {

   Car getCar(String carType){
       if(carType.equalsIgnoreCase("SUV")){
             return  new Suv();
       } else if (carType.equalsIgnoreCase("Truck")) {
           return  new Truck();
       } else if (carType.equalsIgnoreCase("Sedan")) {
           return  new Sedan();
       }
       return null;
   }
}
