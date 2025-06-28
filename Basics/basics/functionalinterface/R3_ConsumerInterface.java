package basics.functionalinterface;

import java.util.function.Consumer;

public class R3_ConsumerInterface {
    public static void main(String[] args) {

        Consumer<String> con=s-> System.out.println(s.toUpperCase());
        con.accept("this in lowercase");//THIS IN LOWERCASE
    }
}
