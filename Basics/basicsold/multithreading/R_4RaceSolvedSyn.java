package basicsold.multithreading;



class Counter2 {
    int count = 0;

    synchronized void  increment() {
        count++;
    }
}

public class R_4RaceSolvedSyn {
    public static void main(String[] args) throws InterruptedException {
        Counter2 c = new Counter2();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) c.increment();
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) c.increment();
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final Count: " + c.count); // always 2000 because we used synchronized
    }
}

//Types of Synchronization
//Type	Usage
//Method-level	synchronized void method()
//Block-level	synchronized(this) { ... }
//Static synchronization	synchronized(ClassName.class)


//Would you like to:
//🔁 Try an example with synchronized block?
//🧪 Explore volatile vs synchronized?
//⚙️ Move to Executors & ThreadPools for modern threading?
