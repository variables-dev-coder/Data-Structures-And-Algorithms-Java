package Revision.Day_5_Queue;

import java.util.*;

class MinQueue {
    Queue<Integer> q = new LinkedList<>();
    Deque<Integer> dq = new LinkedList<>();

    void enqueue(int x) {
        q.add(x);
        // maintain increasing order in dq
        while (!dq.isEmpty() && dq.peekLast() > x) {
            dq.pollLast();
        }
        dq.addLast(x);
    }

    int dequeue() {
        if (q.isEmpty()) {
            System.out.println("Queue is empty!");
            return -1;
        }
        int val = q.poll();
        if (val == dq.peekFirst()) {
            dq.pollFirst();
        }
        return val;
    }

    int getMin() {
        if (dq.isEmpty()) return -1;
        return dq.peekFirst();
    }

    public static void main(String[] args) {
        MinQueue q = new MinQueue();
        q.enqueue(5);
        q.enqueue(3);
        q.enqueue(7);
        q.enqueue(2);
        System.out.println("Min: " + q.getMin()); // 2
        q.dequeue(); // removes 5
        System.out.println("Min: " + q.getMin()); // 2
        q.dequeue(); // removes 3
        q.dequeue(); // removes 7
        System.out.println("Min: " + q.getMin()); // 2
    }
}

