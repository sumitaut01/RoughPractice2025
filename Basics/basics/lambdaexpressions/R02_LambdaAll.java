package basics.lambdaexpressions;
import java.util.*;
import java.util.function.*;

public class R02_LambdaAll {
    public static void main(String[] args) {

        // Supplier<T> – generates a list of names
        Supplier<List<String>> nameSupplier = () -> Arrays.asList("Alice", "Bob", "Charlie", "David", "Eve");

        // Predicate<T> – filter names starting with 'C'
        Predicate<String> startsWithC = name -> name.startsWith("C");

        // Function<T, R> – convert name to uppercase
        Function<String, String> toUpper = name -> name.toUpperCase();

        // Consumer<T> – print the name
        Consumer<String> printer = name -> System.out.println("Name: " + name);

        // Workflow: Get → Filter → Transform → Use
        nameSupplier.get() // get list
                .stream()
                .filter(startsWithC) // filter
                .map(toUpper) // transform
                .forEach(printer); // consume
        //Name: CHARLIE
    }
}

