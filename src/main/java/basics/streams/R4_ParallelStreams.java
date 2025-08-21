package basics.streams;

import java.util.ArrayList;
import java.util.List;

public class R4_ParallelStreams {
    public static void main(String[] args) {

        //
        List<String> names = List.of("Sumit", "Neha", "Amit");
         names.stream().parallel().forEach(System.out::println);

         //
        ArrayList<String> as=new ArrayList<>();
        as.add("Sumit");
        as.add("Neha");
        as.add("Amit");

        as.parallelStream().forEach(System.out::println);


    }
}
