package basics.streams;



import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class R2_intermediateOptions {
    public static void main(String[] args) {


        //Filter
        Stream<String> s= Stream.of("Sumit","Sagar","neha");
        System.out.println(s.filter(str->str.startsWith("S")).collect(Collectors.toList()));
        //[Sumit, Sagar]

        //Map
       Stream<String >stm= Arrays.stream(new String[]{"Magic","in","the","air"});

        System.out.println(stm.map(s1->s1.toUpperCase()).collect(Collectors.toList()));
        //[MAGIC, IN, THE, AIR]


        //Sorted
        Stream<String >stm2= Arrays.stream(new String[]{"Magic","in","the","air"});
        System.out.println(stm2.sorted().collect(Collectors.toList()));
        //[Magic, air, in, the] //this is correct as M comes before in ASCII  //Important Fact: Java sorts lexicographically (Unicode order)

        Stream<String >stm3= Arrays.stream(new String[]{"Magic","in","the","air"});


        //*** below will result in error
//        Java Streams can only be used once.
//                Once you call a terminal operation like collect(), forEach(), count() on a stream, it becomes consumed/closed — you cannot use it again.
//        System.out.println(stm3.sorted(String.CASE_INSENSITIVE_ORDER).collect(Collectors.toList()));
        System.out.println(stm3.sorted(String.CASE_INSENSITIVE_ORDER).collect(Collectors.toList()));
        //[air, in, Magic, the]



//        You can store in list and use multiple times to avoid above problem ✔ Option 2: Store data in a List and reuse it
        List<String> words = Arrays.asList("Magic", "in", "the", "air");

        System.out.println(words.stream()
            .sorted(String.CASE_INSENSITIVE_ORDER)
            .collect(Collectors.toList()));

        //[air, in, Magic, the]

        System.out.println(words.stream()
            .sorted(String.CASE_INSENSITIVE_ORDER)
            .collect(Collectors.toList()));
        //[air, in, Magic, the]


        //reverse order
//        Reverse Order with sorted(Comparator.reverseOrder())
//🔹 Strings Example
//        java
//                Copy
//        Edit
        List<String> names = List.of("Sumit", "Neha", "Amit");

        List<String> reversed = names.stream()
                .sorted(Comparator.reverseOrder())  // reverse natural order
                .collect(Collectors.toList());
        System.out.println(reversed);



        //

       Supplier<List<String>> lst=()-> List.of("Sagar","Neha","Abhi","Shashank");
        Predicate<String> pred= st->st.startsWith("S");
        Function<String,String> func=stt->stt.toUpperCase();

       lst.get().stream().filter(pred).map(func).collect(Collectors.toList()).forEach(str-> System.out.println(str));
       //SAGAR
        //SHASHANK
    }



    //Multi Work:



}
