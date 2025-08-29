package basics.multithreading;
/*
The code demonstrates the use of the join() method to control the execution order of threads. The main thread will pause and wait for t1 to finish before starting t2.
Notes on the Code
Thread Creation: Two Thread objects, t1 and t2, are created. Each is given a new instance of the Test class (which presumably implements Runnable) and a specific name ("first object" and "second object").
t1.start(): This starts the first thread, t1, which begins to execute its run() method concurrently with the main thread.
Thread.sleep(2000): The main thread pauses for 2000 milliseconds (2 seconds). This allows t1 to run for a bit before the main thread proceeds. This is not strictly necessary for the logic but is a good way to see concurrency in action.
t1.join(): This is the key line. When the main thread calls t1.join(), it blocks and waits for t1 to complete its execution. The main thread will not proceed to the next line of code until t1's run() method has finished.
t2.start() and t2.join(): Only after t1 is finished and the main thread has resumed will t2 be started. The main thread then immediately calls t2.join(), blocking again until t2 completes.

Guaranteed Order: This use of join() ensures a specific, sequential order of execution:
t1 starts and runs.
main thread waits for t1 to finish.
t2 starts and runs.
main thread waits for t2 to finish.
Finally, the line "all done" is printed.
Without join(), the main thread would start both t1 and t2 and immediately print "all done" before either of the other threads had necessarily completed
 */
public class R2_JoinSleep {

    public static void main(String[] args) throws InterruptedException {

        Thread t1=new Thread(new Test(),"first object");
        Thread t2=new Thread(new Test(),"second object");
        t1.start();
        Thread.sleep(2000);
        t1.join();
        t2.start();
        t2.join();
        System.out.println("all done");
    }
}

class Test implements  Runnable{
    @Override
    public void run() {
        System.out.println("Executing run method");
    }
}
