package basicsold.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class R1_streamCreation {

    public static void main(String[] args) {


        //1 Stream.of

        System.out.println(Stream.of("Sumit","Neha","Raj").count());

       //2Arrays.stream

        Stream<Integer> stream2 = Arrays.stream(new Integer[]{1, 2, 3});

        //Stream<String> stream1 = list.stream();

        List.of("Sumit","Neha").stream().count();
    }

}
