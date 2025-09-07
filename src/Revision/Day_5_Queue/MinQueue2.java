package Revision.Day_5_Queue;

import java.util.*;

class MinQueue2 {
    Queue<Integer> q = new LinkedList<>();
    Deque<Integer> minQ = new LinkedList<>();

    void enqueue(int x) {
        q.add(x);
        while (!minQ.isEmpty() && minQ.peekLast() > x) {
            minQ.pollLast();
        }
        minQ.addLast(x);
    }

    int dequeue() {
        if (q.isEmpty()) return -1;
        int removed = q.poll();
        if (removed == minQ.peekFirst()) {
            minQ.pollFirst();
        }
        return removed;
    }

    int getMin() {
        if (minQ.isEmpty()) return -1;
        return minQ.peekFirst();
    }

    public static void main(String[] args) {
        MinQueue2 mq = new MinQueue2();
        mq.enqueue(3);
        mq.enqueue(5);
        mq.enqueue(2);
        mq.enqueue(1);
        mq.enqueue(4);

        System.out.println("Current Min: " + mq.getMin()); // 1
        mq.dequeue(); // removes 3
        mq.dequeue(); // removes 5
        System.out.println("Current Min: " + mq.getMin()); // 1
        mq.dequeue(); // removes 2
        System.out.println("Current Min: " + mq.getMin()); // 1
        mq.dequeue(); // removes 1
        System.out.println("Current Min: " + mq.getMin()); // 4
    }
}

