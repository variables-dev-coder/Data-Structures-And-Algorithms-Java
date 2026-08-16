package queue_Deque;

import java.util.*;

public class QueueExample {

    public static void main(String[] args) {

        Queue<Integer> queue = new LinkedList<>();

        // Enqueue
        queue.offer(10);
        queue.offer(20);
        queue.offer(30);
        queue.offer(40);

        System.out.println(queue);

        // Peek
        System.out.println("Front: " + queue.peek());

        // Dequeue
        System.out.println("Removed: " + queue.poll());

        System.out.println(queue);

        // Size
        System.out.println("Size: " + queue.size());

        // Empty?
        System.out.println("Is empty: " + queue.isEmpty());
    }
}
