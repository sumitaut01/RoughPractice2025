package basics;

import java.util.concurrent.atomic.AtomicInteger;

public class R_XAtomicInteger {

    public static void main(String[] args) {


        AtomicInteger atomicInteger=new AtomicInteger(0);//0
        System.out.println(atomicInteger.get());//0
        System.out.println(atomicInteger.getAndIncrement());
        atomicInteger.set(12);
        System.out.println(atomicInteger.get());//12
        System.out.println(atomicInteger.getAndIncrement());//12
    }
}
