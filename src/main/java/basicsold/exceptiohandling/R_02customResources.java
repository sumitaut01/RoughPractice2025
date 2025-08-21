package basicsold.exceptiohandling;

public class R_02customResources {
    public static void main(String[] args) {


        try (MyResource r = new MyResource()) {
            r.use();
        }

//        Using resource
//        Closed resource


    }
}

//AutoCloseable responsible
class MyResource implements AutoCloseable {
    public void use() {
        System.out.println("Using resource");
    }
    //below method
    public void close() {
        System.out.println("Closed resource");
    }
}