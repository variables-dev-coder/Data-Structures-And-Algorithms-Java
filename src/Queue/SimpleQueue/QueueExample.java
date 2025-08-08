package Queue.SimpleQueue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {

    public static void main(String[] args) {
        // Create queue
        Queue<String> queue = new LinkedList<>();

        // Enqueue element
        queue.offer("A");
        queue.offer("B");
        queue.offer("C");
        queue.offer("D");

        System.out.println("Queue: " + queue);  // Queue: [A, B, C, D]

        // peek
        System.out.println("Front element: " + queue.peek());  // Front element: A

        // Dequeue element
        System.out.println("Remove: " + queue.poll());  // Remove: A
        System.out.println("Queue after removal: " + queue);  // Queue after removal: [B, C, D]

        // Check empty
        System.out.println("Is queue empty: " + queue.isEmpty());  // Is queue empty: false
    }
}

/*

Queue: [A, B, C]
Front element: A
Removed: A
Queue after removal: [B, C]
Is queue empty? false

 */