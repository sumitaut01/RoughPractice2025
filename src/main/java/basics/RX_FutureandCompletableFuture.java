package basics;

public class RX_FutureandCompletableFuture {
}

//What Is CompletableFuture?
//
//CompletableFuture is a class in Java used for asynchronous and concurrent programming.
//
//It allows you to run tasks in the background, combine tasks, handle timeouts, run parallel operations, etc.
//
//Think of it like:
//
//“Do this task in another thread”
//
//“When it's done, do something else”
//
//“If it fails, handle the exception”
//
//“Combine results from 2 futures”
//
//“Wait for all to finish”
//
//It simplifies complex thread handling.
//
//🚀 Step 1: Run Async Task
//runAsync() → when no return value
//CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
//    System.out.println("Running in background: " + Thread.currentThread().getName());
//});
//
//🚀 Step 2: Supply Async (Return Value)
//supplyAsync() → when returning data
//CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
//    return "Hello from async!";
//});
//
//
//Get the result:
//
//String result = future.get();  // Blocking
//
//🎯 Step 3: thenApply → Transform the value
//CompletableFuture<Integer> future =
//        CompletableFuture.supplyAsync(() -> 10)
//                         .thenApply(n -> n * 2);  // transform
//
//System.out.println(future.get()); // 20
//
//🎯 Step 4: thenAccept → consume value (no return)
//CompletableFuture.supplyAsync(() -> "Sumit")
//        .thenAccept(name -> System.out.println("Hello " + name));
//
//🎯 Step 5: thenRun → run task after previous task (no input)
//CompletableFuture.supplyAsync(() -> "Data loaded")
//        .thenRun(() -> System.out.println("Logging complete"));
//
//🌟 Step 6: Combine Two Futures
//thenCombine → combine results of two async tasks
//CompletableFuture<Integer> f1 = CompletableFuture.supplyAsync(() -> 10);
//CompletableFuture<Integer> f2 = CompletableFuture.supplyAsync(() -> 20);
//
//CompletableFuture<Integer> result = f1.thenCombine(f2, (a, b) -> a + b);
//
//System.out.println(result.get()); // 30
//
//🌟 Step 7: Run Futures in Parallel and Wait for All
//allOf()
//CompletableFuture<Void> all = CompletableFuture.allOf(f1, f2);
//all.get();  // waits for all
//
//
//If you want results from each:
//
//List<Integer> results = List.of(f1, f2)
//        .stream()
//        .map(CompletableFuture::join)
//        .toList();
//
//🌟 Step 8: anyOf() — return whichever finishes first
//CompletableFuture<String> fast = CompletableFuture.supplyAsync(() -> "Fast");
//CompletableFuture<String> slow = CompletableFuture.supplyAsync(() -> {
//    Thread.sleep(2000);
//    return "Slow";
//});
//
//CompletableFuture<Object> first = CompletableFuture.anyOf(fast, slow);
//System.out.println(first.get());  // returns "Fast"
//
//⭐ Step 9: Exception Handling with exceptionally()
//CompletableFuture<Integer> f = CompletableFuture.supplyAsync(() -> {
//    if (true) throw new RuntimeException("Oops!");
//    return 10;
//}).exceptionally(ex -> {
//    System.out.println("Error: " + ex.getMessage());
//    return 0;
//});
//
//⭐ Step 10: handle() — whether success or failure
//CompletableFuture<Integer> future =
//        CompletableFuture.supplyAsync(() -> 10 / 0)
//                .handle((result, ex) -> {
//                    if (ex != null) return -1;
//                    return result;
//                });
//
//System.out.println(future.get()); // -1
//
//⭐ Step 11: Timeout Support
//CompletableFuture<String> future =
//        CompletableFuture.supplyAsync(() -> {
//            Thread.sleep(5000);
//            return "Done";
//        }).orTimeout(2, TimeUnit.SECONDS)
//          .exceptionally(ex -> "Timeout!");
//
//System.out.println(future.get()); // Timeout!
//
//⭐ Step 12: Custom Executor (ThreadPool)
//ExecutorService executor = Executors.newFixedThreadPool(5);
//
//CompletableFuture<String> future =
//    CompletableFuture.supplyAsync(() -> "Task", executor);
//
//
//Better control over threads.
//
//🌟 Best Practical Example: Parallel API Calls
//CompletableFuture<String> f1 = CompletableFuture.supplyAsync(() -> callAPI1());
//CompletableFuture<String> f2 = CompletableFuture.supplyAsync(() -> callAPI2());
//CompletableFuture<String> f3 = CompletableFuture.supplyAsync(() -> callAPI3());
//
//CompletableFuture<Void> all = CompletableFuture.allOf(f1, f2, f3);
//
//all.join(); // wait for all
//
//System.out.println(f1.join());
//System.out.println(f2.join());
//System.out.println(f3.join());
//
//🎯 When Should You Use CompletableFuture?
//
//✔ Parallel API calls
//✔ Parallel DB queries
//✔ Heavy data processing
//✔ Pipeline of transformations
//✔ Async workflows in microservices
//✔ Replacing Thread / ExecutorService complexity
//✔ UI / Background operations
//
//⭐ If you want, I can also teach you:
//🔹 CompletableFuture vs Future
//🔹 Chaining workflows
//🔹 Exception propagation
//🔹 Performance tricks
//🔹 Real project examples (REST API calls)
//🔹 CompletableFuture + Streams parallel
//
//Just tell me and we’ll go deeper.
