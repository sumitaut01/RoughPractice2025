package basics.streams;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class R1_streamCreation {

    public static void main(String[] args) {

        // Do note .of creations are immutable
        //1 Stream.of
        System.out.println(Stream.of("Sumit", "Neha", "Raj").count());

        //2Arrays.stream
        Stream<Integer> stream2 = Arrays.stream(new Integer[]{1, 2, 3});

        //Stream<String> stream1 = list.stream();
        List.of("Sumit", "Neha").stream().count();

        //method reference
        Stream.of(1, 2, 5, 4).forEach(R1_streamCreation::print);
//        1
//        2
//        5
//        4


        // 3. From a range (IntStream)
        IntStream.range(1, 6);              // 1,2,3,4,5
        IntStream.rangeClosed(1, 5);       // 1,2,3,4,5

// 4. Infinite stream (use with limit!)
        Stream.iterate(0, n -> n + 2).limit(5);  // 0,2,4,6,8
        Stream.generate(Math::random).limit(3); // 3 random doubles

// 5. From String
        "hello".chars();             // IntStream of char values
        Pattern.compile(",").splitAsStream("a,b,c");// Stream of a,b,c


    }


    public static void print(int number) {
        System.out.println(number);
    }

}
