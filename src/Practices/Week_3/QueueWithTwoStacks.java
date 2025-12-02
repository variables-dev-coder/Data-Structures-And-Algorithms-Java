package Practices.Week_3;

import java.util.ArrayDeque;
import java.util.Deque;

public class QueueWithTwoStacks {
    Deque<Integer> in = new ArrayDeque<>();
    Deque<Integer> out = new ArrayDeque<>();

    public void enqueue(int x) { in.push(x); }
    public int dequeue() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) out.push(in.pop());
        }
        return out.pop();
    }

    public boolean empty() { return in.isEmpty() && out.isEmpty(); }

    public static void main(String[] args) {
        QueueWithTwoStacks q = new QueueWithTwoStacks();
        q.enqueue(1); q.enqueue(2); q.enqueue(3);
        System.out.println(q.dequeue()); // 1
        System.out.println(q.dequeue()); // 2
        q.enqueue(4);
        System.out.println(q.dequeue()); // 3
    }
}
