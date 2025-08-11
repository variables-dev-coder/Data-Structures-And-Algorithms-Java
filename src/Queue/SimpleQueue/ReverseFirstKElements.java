package Queue.SimpleQueue;


// Given an integer k and a queue, reverse the first k elements while
// keeping the order of the rest of the elements the same.

//Input:
//Queue = [1, 2, 3, 4, 5]
//k = 3
//Output:
//[3, 2, 1, 4, 5]

// Logic
//Use a stack to reverse the first k elements (LIFO property).
//Remove first k elements from queue and push them onto stack.
//Pop from stack and enqueue back to queue → first k reversed.
//Move the remaining (size - k) elements to the back to restore order.

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseFirstKElements {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= 5; i++) {
            queue.offer(i);
        }
        int k = 3;

        System.out.println("Original Queue: " + queue);
        reverseFirstK(queue, k);
        System.out.println("Modified Queue: " + queue);
    }

    public static void reverseFirstK(Queue<Integer> queue, int k) {
        if (queue.isEmpty() || k <= 0 || k > queue.size()) {
            return;
        }

        Stack<Integer> stack = new Stack<>();

        // Step 1: Push first k elements into stack
        for (int i = 0; i < k; i++) {
            stack.push(queue.poll());
        }

        // Step 2: Add elements from stack back to queue
        while (!stack.isEmpty()) {
            queue.offer(stack.pop());
        }

        // Step 3: Move the remaining elements to back of queue
        int remaining = queue.size() - k;
        for (int i = 0; i < remaining; i++) {
            queue.offer(queue.poll());
        }
    }
}
