package Queue.SimpleQueue;

import java.util.LinkedList;
import java.util.Queue;

public class SimpleQueueExample {
    public static void main(String[] args) {

        // Create Queue
        Queue<String> queue = new LinkedList<>();

        // Enqueue elements
        queue.offer("A");
        queue.offer("B");
        queue.offer("C");

        System.out.println("Queue After enqueue: " + queue);  // Queue After enqueue: [A, B, C]

        // Dequeue element
        String removed = queue.poll(); // removes first element
        System.out.println("Dequeue: " + removed);  // Dequeue: A
        System.out.println("Queue at element: " + queue);  // Queue at element: [B, C]

        // Peek at front element
        String front = queue.peek(); // return first element without removing
        System.out.println("Front element: " + front);  // Front element: B

        // Check if empty
        System.out.println("Is queue? " + queue.isEmpty());  // Is queue? false

    }
}
