package Queue.SimpleQueue;


/*

Given an integer k and a queue of integers, reverse the order of the first k elements,
leaving the rest in the same order.

Example:
Input: Queue = [10, 20, 30, 40, 50, 60], k = 4
Output: [40, 30, 20, 10, 50, 60]

Logic
Use a stack to reverse the first k elements.
Push the first k elements into the stack.
Pop from the stack and enqueue back into the queue (reverses them).
Move the remaining elements (n-k) to the back of the queue to maintain order.

 */
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseFirstK {
    public static void reverseFirstK(Queue<Integer> queue, int k) {
        if (queue == null || k <= 0 || k > queue.size()) return;

        Stack<Integer> stack = new Stack<>();

        // Step 1: Push first K elements into stack
        for (int i = 0; i < k; i++) {
            stack.push(queue.poll());
        }

        // Step 2: Enqueue back from stack
        while (!stack.isEmpty()) {
            queue.offer(stack.pop());
        }

        // Step 3: Move remaining elements to back
        int size = queue.size();
        for (int i = 0; i < size - k; i++) {
            queue.offer(queue.poll());
        }
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(10, 20, 30, 40, 50, 60));
        int k = 4;

        System.out.println("Original Queue: " + queue);
        reverseFirstK(queue, k);
        System.out.println("Modified Queue: " + queue);
    }
}
