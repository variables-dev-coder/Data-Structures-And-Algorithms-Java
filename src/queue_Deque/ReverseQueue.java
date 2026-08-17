package queue_Deque;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseQueue {

    public static void reverseQueue(Queue<Integer> queue) {

        Stack<Integer> stack = new Stack<>();

        // Queue → Stack
        while (!queue.isEmpty()) {

            int value = queue.poll();

            stack.push(value);
        }

        // Stack → Queue
        while (!stack.isEmpty()) {

            int value = stack.pop();

            queue.offer(value);
        }
    }

    public static void main(String[] args) {

        Queue<Integer> queue = new LinkedList<>();

        queue.offer(10);
        queue.offer(20);
        queue.offer(30);
        queue.offer(40);
        queue.offer(50);

        System.out.println("Before: " + queue);

        reverseQueue(queue);

        System.out.println("After: " + queue);
    }
}
