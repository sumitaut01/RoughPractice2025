package basics;

//A Stream in Java represents a sequence of elements that supports various operations to process data (like filtering, mapping, sorting, reducing) in a pipeline.
//        Works with collections like List, Set
//        Does not store data, just processes it
//        Can be parallel or sequential
//
//Stream Pipeline = 3 Stages
//        Stage	Examples
//        Source	stream(), Arrays.stream(), etc.
//        Intermediate Ops	filter(), map(), sorted()
//        Terminal Op	forEach(), collect(), reduce()

//Common Intermediate Operations
//        Method	Description
//        filter()	Filters elements based on a predicate
//        map()	Transforms elements
//        sorted()	Sorts the stream
//        distinct()	Removes duplicates
//        limit(n)	Truncates the stream to n elements
//        skip(n)	Skips the first n elements
//        peek()	For debugging (like sout inside stream)


//Common Terminal Operations
//        Method	Description
//        forEach()	Consumes elements
//        collect()	Reduces stream to a collection
//        reduce()	Aggregates elements into one
//        count()	Returns number of elements
//        anyMatch()	Checks if any element matches
//        allMatch()	Checks if all elements match
//        findFirst()	Gets the first element (Optional)

import java.util.List;

public class R20_Streams {
    public static void main(String[] args) {


        List<String> names = List.of("Sumit", "Sagar", "Ram", "Shyam");
        names.stream()
                .filter(name -> name.startsWith("S"))
                .map(String::toUpperCase)
                .sorted()
                .forEach(System.out::println);
    }
//    Output:
//
//    nginx
//            Copy
//    Edit
//            SAGAR
//    SUMIT
}
