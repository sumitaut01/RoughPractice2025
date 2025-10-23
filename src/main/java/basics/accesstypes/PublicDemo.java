package basics.accesstypes;

class VehicleX {
    public int speed=10; // protected member
}

class BikeX extends VehicleX {
    void setSpeed(int s)
    {
        speed = s; // accessible in subclass
    }

    int getSpeed()
    {
        return speed; // accessible in subclass
    }
}

public class PublicDemo {
    public static void main(String[] args){

        BikeX b = new BikeX();
        b.setSpeed(100);
        System.out.println("Access via subclass method: "
                           + b.getSpeed());

        VehicleX v = new VehicleX();
        System.out.println(v.speed);

//        Access via subclass method: 100
//        10

    }
}