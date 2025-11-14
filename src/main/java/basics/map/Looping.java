package basics.map;

import java.util.Map;

public class Looping {

    public static void main(String[] args) {

        Map.of("name", "sumit", "college", "kits", "location", "bhandara")
                .forEach((k, v) -> System.out.println(k + " " + v));
        //location bhandara
        //name sumit
        //college kits
    }
}
