package basics.multithreading;

// To create a new thread, you must call the start() method on the Thread object.
// When start() is invoked, the JVM allocates resources
// for a new thread and then calls the run() method in that newly created thread.
public class R1_1thread {

    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        Thread thread1 = new Thread(t1);

        // Create the second runnable object
        MyThread t2 = new MyThread();
        // Create the second thread
        Thread thread2 = new Thread(t2);


        thread1.start();//Thread is running...Thread-0
        thread2.start();//Thread is running...Thread-0
    }
}

class MyThread implements Runnable{
    @Override
    public void run() {

                // Simulate some work to show threads can run at different times
        for (int i = 0; i < 4; i++) {
            System.out.println("Thread is running..."+Thread.currentThread().getName());
            System.out.println(": Counter " + i);
            try {
                // Pause the thread for a short time
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

//Thread is running...Thread-0
//Thread is running...Thread-1
//: Counter 0
//: Counter 0
//Thread is running...Thread-1
//: Counter 1
//Thread is running...Thread-0
//: Counter 1
//Thread is running...Thread-1
//: Counter 2
//Thread is running...Thread-0
//: Counter 2
//Thread is running...Thread-1
//: Counter 3
//Thread is running...Thread-0
//: Counter 3
