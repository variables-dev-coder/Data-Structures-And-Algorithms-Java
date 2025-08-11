package Queue.SimpleQueue;


// Given a number N, generate binary numbers from 1 to N using a Queue.
//Input: N = 5
//Output: 1, 10, 11, 100, 101

// Logic
//We can use a queue for level-wise generation of binary numbers.
//Start with "1" in the queue.
//Repeat until we generate N numbers:
//Dequeue the front element → print/store it.
//Append "0" to it and enqueue.
//Append "1" to it and enqueue.
//This is just like BFS for binary strings.

import java.util.LinkedList;
import java.util.Queue;

public class BinaryNumbersUsingQueue {
    public static void main(String[] args) {
        int N = 10; // You can change this value

        generateBinaryNumbers(N);
    }

    public static void generateBinaryNumbers(int N) {
        Queue<String> queue = new LinkedList<>();

        // Start with "1"
        queue.offer("1");

        for (int i = 0; i < N; i++) {
            // Get and print front of queue
            String current = queue.poll();
            System.out.print(current + " ");

            // Append "0" and "1" to current and enqueue
            queue.offer(current + "0");
            queue.offer(current + "1");
        }
    }
}
