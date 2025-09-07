package basics;
/*
1. PriorityQueue (Java)
Based on: Binary Heap (usually a min-heap).
Ordering: Elements ordered by natural ordering or custom Comparator.
Operations:
Insert = O(log n) (heapify-up).
Remove min/max = O(log n) (heapify-down).
Peek = O(1).

Use cases:
Task schedulers (e.g., CPU job queue).
Dijkstra’s shortest path.
Event-driven simulations.
Example:
PriorityQueue<Integer> pq = new PriorityQueue<>();
pq.add(10);
pq.add(5);
pq.add(20);
System.out.println(pq.poll()); // 5 (min element)
 */

import java.util.PriorityQueue;

public class RX_PriorityQueUe {

    public static void main(String[] args) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        System.out.println(pq.add(1));//true
        pq.add(0);
        pq.add(7);
        System.out.println(pq);//[0, 1, 7]
        System.out.println(pq.add(1));//true

        System.out.println(pq);//[0, 1, 7, 1]


        System.out.println(pq.peek());//0
        System.out.println(pq);//[0, 1, 7, 1]

        System.out.println(pq.poll());//0
        System.out.println(pq);//[1, 1, 7]



    }


}
