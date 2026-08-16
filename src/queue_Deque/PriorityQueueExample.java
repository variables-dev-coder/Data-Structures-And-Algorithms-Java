package queue_Deque;

import java.util.*;

public class PriorityQueueExample {

    public static void main(String[] args) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.offer(30);
        pq.offer(10);
        pq.offer(20);
        pq.offer(5);

        System.out.println(pq);

        System.out.println("Top: " + pq.peek());

        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }
}
