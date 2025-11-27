package basics.javapgms;

public class OddEven {
    static int num = 1;
    static Object lock = new Object();

    public static void main(String[] args) {
        Thread odd = new Thread(() -> {
            while (num <= 10) {
                synchronized (lock) {
                    if (num % 2 != 0) {
                        System.out.println("Odd: " + num++);
                        lock.notify();
                    } else {
                        try { lock.wait(); } catch (Exception e) {}
                    }
                }
            }
        });

        Thread even = new Thread(() -> {
            while (num <= 10) {
                synchronized (lock) {
                    if (num % 2 == 0) {
                        System.out.println("Even: " + num++);
                        lock.notify();
                    } else {
                        try { lock.wait(); } catch (Exception e) {}
                    }
                }
            }
        });

        odd.start();
        even.start();
    }
}
