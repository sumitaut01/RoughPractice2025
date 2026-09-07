package basics.style_object_creation;

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
