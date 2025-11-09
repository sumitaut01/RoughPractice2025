package basics.streams;

import org.apache.http.io.SessionOutputBuffer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;

//1. What Is a Parallel Stream?
//
//A parallel stream in Java is a special type of Stream that divides its elements into multiple chunks and processes them in parallel using multiple threads from the ForkJoinPool (by default, ForkJoinPool.commonPool()).
//
//Essentially:
//
//A parallel stream is a stream that runs operations concurrently using multiple CPU cores.
//
//🧩 2. How to Create a Parallel Stream
//
//There are two main ways to create it:
//
//✅ Way 1: Convert an existing stream
//List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
//numbers.stream()
//       .parallel()                // convert sequential stream to parallel
//       .forEach(System.out::println);
//
//✅ Way 2: Use parallelStream() directly
//List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
//numbers.parallelStream()
//       .forEach(System.out::println);
//
//
//💡 Note: forEach on a parallel stream does not preserve order.
//If you want order, use forEachOrdered().
//
//⚙️ 3. Example: Sequential vs Parallel Performance
//import java.util.*;
//import java.util.stream.*;
//
//public class ParallelExample {
//    public static void main(String[] args) {
//        List<Integer> numbers = IntStream.rangeClosed(1, 10)
//                                         .boxed()
//                                         .collect(Collectors.toList());
//
//        long start1 = System.currentTimeMillis();
//        numbers.stream()
//               .map(ParallelExample::slowSquare)
//               .collect(Collectors.toList());
//        System.out.println("Sequential: " + (System.currentTimeMillis() - start1) + " ms");
//
//        long start2 = System.currentTimeMillis();
//        numbers.parallelStream()
//               .map(ParallelExample::slowSquare)
//               .collect(Collectors.toList());
//        System.out.println("Parallel: " + (System.currentTimeMillis() - start2) + " ms");
//    }
//
//    private static int slowSquare(int n) {
//        try { Thread.sleep(100); } catch (InterruptedException e) {}
//        return n * n;
//    }
//}
//
//
//🧩 Output (example):
//
//Sequential: 1007 ms
//Parallel: 203 ms
//
//
//Parallel streams used multiple threads, reducing total processing time.
//
//⚖️ 4. When to Use Parallel Streams
//
//✅ Good use cases:
//
//CPU-intensive operations (e.g., mathematical computations, image processing)
//
//Independent elements (no shared mutable state)
//
//Large datasets
//
//Multi-core environments
//
//❌ Avoid when:
//
//Tasks are I/O-bound (e.g., DB calls, file reads)
//
//Tasks modify shared data (risk of race conditions)
//
//Small datasets (thread overhead > benefit)
//
//You need strict ordering or predictable performance
//
//🧵 5. Internal Threading
//
//Parallel streams use the ForkJoin framework behind the scenes:
//
//Each task is split (“forked”) into smaller subtasks.
//
//Results are combined (“joined”) at the end.
//
//Uses a pool: ForkJoinPool.commonPool()
//
//You can check the parallelism level:
//
//System.out.println(ForkJoinPool.commonPool().getParallelism());
//
//
//(Default: usually equal to the number of available CPU cores.)
//
//You can also customize it:
//
//ForkJoinPool customPool = new ForkJoinPool(4);
//customPool.submit(() -> {
//    IntStream.range(1, 100).parallel().forEach(System.out::println);
//}).join();
//
//🧮 6. Common Pitfalls
//Mistake	Explanation
//Using shared mutable state	Leads to race conditions.
//Expecting ordered output	forEach() doesn’t preserve order.
//Small datasets	Overhead of threads > speed gain.
//I/O operations	Parallelism doesn’t help much with blocking I/O.
//🔍 7. Sequential vs Parallel Summary
//Aspect	Sequential Stream	Parallel Stream
//Threads	Single	Multiple
//Performance	Slower on large data	Faster (CPU-bound)
//Order	Preserved	Not guaranteed
//Overhead	Low	Higher
//Use case	Small data, simple ops	Big data, CPU-heavy ops
//🧑‍💻 Quick Example: Counting Words in Parallel
//List<String> words = Arrays.asList("apple", "banana", "cherry", "date", "fig", "grape");
//
//long count = words.parallelStream()
//                  .filter(w -> w.length() > 4)
//                  .count();
//
//System.out.println(count);
public class R7_ParallelStream {

    public static void main(String[] args) {


        Arrays.asList(1,2,3,4).stream().parallel().forEach(v-> System.out.println(v));

        //3
        //4
        //1
        //2





    }
}
