package basics.collections.queue;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

//public interface Queue<E>
//extends java.util.Collection<E>

//add() vs offer() → add() throws exception if full, offer() returns false.
//remove() vs poll() → remove() throws exception if empty, poll() returns null.
//element() vs peek() → element() throws exception if empty, peek() returns null.

public class R1_QueUe {
    public static void main(String[] args) {
//public interface Queue<E> extends Collection<E>


        Queue<String> qStr=new ArrayDeque<>(16);
        qStr.add("Sumit");
        qStr.offer("Amit");
        System.out.println(qStr);//[Sumit, Amit]

        for(int i=0;i<14;i++){
            qStr.add("i");
        }
        System.out.println(qStr);
        //[Sumit, Amit, i, i, i, i, i, i, i, i, i, i, i, i, i, i]
        System.out.println(qStr.add("Neha"));// this is 17 yet no exception
        //Why your queue did not throw exception
        //By default, if you use LinkedList, ArrayDeque, or PriorityQueue → they are unbounded (grow dynamically).
        //That’s why when you added 17 elements, it still worked → there is no capacity limit.
        //👉 To see exceptions when full, you need to use a bounded queue implementation → ArrayBlockingQueue.
        System.out.println(qStr);

        qStr.peek();
        qStr.poll();
        qStr.element();
        qStr.remove();



        Queue<String> qStr2=new ArrayBlockingQueue<>(3);
        qStr2.add("Sumit");
        qStr2.offer("Amit");
        qStr2.offer("Neha");

        System.out.println(  qStr2.offer("4th"));//false
       // System.out.println(  qStr2.add("4th"));//exception  Exception in thread "main" java.lang.IllegalStateException: Queue full





        //LinkedList
      //  Queue<String> qstr=new LinkedList<String>();



        //PriorityQueue
      //  Queue<String> qstr=new PriorityQueue<>();


    }
}
