package basics.multithreading;

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
