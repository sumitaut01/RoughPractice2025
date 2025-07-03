package basics.multithreading;

public class R1_1thread {

    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.run();//Thread is running...
    }
}

class MyThread implements Runnable{
    @Override
    public void run() {
        System.out.println("Thread is running..."+Thread.currentThread().getName());
    }
}
