package basics.styleobject;

public class Driver {

    public static void main(String[] args) {

        new One() {
            {
                name = "sumit";
                age = 12;
            }
        }.toString();
    }
    

}
