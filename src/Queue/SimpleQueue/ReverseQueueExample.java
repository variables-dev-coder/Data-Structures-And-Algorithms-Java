package Queue.SimpleQueue;


// Given a queue, reverse the order of its elements.
//Input:  [1, 2, 3, 4, 5]
//Output: [5, 4, 3, 2, 1]

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseQueueExample {
    public static void main(String[] args) {

        // Step 1: Create and fill queue

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);

        System.out.println("Original Queue: " + queue);

        // Step 2: Reverse elements from the queue using to stack
        Stack<Integer> stack = new Stack<>();

        // Move all elements from queue to stack
        while (!queue.isEmpty()) {
            stack.push(queue.poll());
        }

        // Move all elements from stack back to queue
        while (!stack.isEmpty()) {
            queue.offer(stack.pop());
        }
        System.out.println("Reversed Queue: " + queue);
    }
}

//Logic
//We can do this using a Stack because:
//A stack follows LIFO (Last In, First Out).
//If we take elements from the queue and push them into a stack, the order gets reversed.
//Then, if we pop from the stack back into the queue, we get a reversed queue.