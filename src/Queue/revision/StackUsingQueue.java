package Queue.revision;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {

    static Queue<Integer> q1 = new LinkedList<>();
    static Queue<Integer> q2 = new LinkedList<>();

    static void push(int x) {
        q2.add(x);
        while (!q1.isEmpty()) {
            q2.add(q1.poll());
        }
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    static void pop() {
        if (q1.isEmpty()) {
            System.out.println("Stack Empty");
            return;
        }
        System.out.println("Popped: " + q1.poll());
    }

    public static void main(String[] args) {
        push(10);
        push(20);
        push(30);
        pop();
        pop();
    }
}

