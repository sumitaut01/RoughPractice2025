package basics.multithreading;




class Counter3 {
    int count = 0;

    void increment() {
        synchronized (this) {  // 👈 Locking on the current instance
            count++;
        }
    }
}

public class R_SyncBlock {
    public static void main(String[] args) throws InterruptedException {
        Counter3 counter = new Counter3();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) counter.increment();
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) counter.increment();
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final Count: " + counter.count); // ✅ Always 2000
    }

    //Why Use a Block Instead of Method?
    //Method	Behavior
    //synchronized void increment()	Locks entire method
    //synchronized (this) block	Locks only critical section (can improve performance)
    //
    //Use block-level sync when:
    //
    //Only a part of the method accesses shared data
    //
    //Other parts of the method don’t need locking
}

