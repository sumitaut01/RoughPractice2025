package basics.collections.Deque;

import com.google.common.collect.ForwardingDeque;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class R1_ {

    public static void main(String[] args) {

        Deque<String> deque=new ArrayDeque<>();



        Deque<String> deque2=new ConcurrentLinkedDeque<>();



        Deque<String> deque3=new LinkedBlockingDeque<>();


        Deque<String> deque4=new LinkedList<>();



    }
}
