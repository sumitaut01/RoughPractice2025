package basics;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import static java.lang.Thread.sleep;

public class R_XThreadlocal {
    // The ThreadLocal variable should be a static field
    private static final ThreadLocal<Integer> integer = new ThreadLocal<>();

    public static ThreadLocal<Integer> getInteger() {
        return integer;
    }

    // This method needs to set the value on the 'ThreadLocal' object.
    // The parameter name should not conflict with the static variable name.
    public static void setInteger(int value) {
        integer.set(value);
    }

    public static void main(String[] args) throws InterruptedException {
        // Create an ExecutorService with two threads
        ExecutorService executor = Executors.newFixedThreadPool(2);

        // Task for the first thread
        Runnable task1 = () -> {
            // Set a value for the current thread's ThreadLocal
            setInteger(10);
            System.out.println("Thread " + Thread.currentThread().getName() + " set value: " + getInteger().get());
        };

        // Task for the second thread
        Runnable task2 = () -> {
            // Set a different value for this thread's ThreadLocal
            setInteger(20);
            System.out.println("Thread " + Thread.currentThread().getName() + " set value: " + getInteger().get());
        };

        // Submit both tasks to the executor
        executor.submit(task1);
        executor.submit(task2);

        // A small delay to ensure the threads have run
        sleep(1000);

        // Try to get the value from the main thread (which has no value set)
        System.out.println("\nMain thread value (should be null): " + getInteger().get());

        // Shutdown the executor
        executor.shutdown();
    }
}