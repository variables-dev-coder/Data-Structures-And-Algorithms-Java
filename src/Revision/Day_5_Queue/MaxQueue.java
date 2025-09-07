package Revision.Day_5_Queue;

import java.util.*;

class MaxQueue {
    Queue<Integer> q = new LinkedList<>();
    Deque<Integer> maxQ = new LinkedList<>();

    void enqueue(int x) {
        q.add(x);
        while (!maxQ.isEmpty() && maxQ.peekLast() < x) {
            maxQ.pollLast();
        }
        maxQ.addLast(x);
    }

    int dequeue() {
        if (q.isEmpty()) return -1;
        int removed = q.poll();
        if (removed == maxQ.peekFirst()) {
            maxQ.pollFirst();
        }
        return removed;
    }

    int getMax() {
        if (maxQ.isEmpty()) return -1;
        return maxQ.peekFirst();
    }

    public static void main(String[] args) {
        MaxQueue mq = new MaxQueue();
        mq.enqueue(3);
        mq.enqueue(5);
        mq.enqueue(2);
        mq.enqueue(1);
        mq.enqueue(4);

        System.out.println("Current Max: " + mq.getMax()); // 5
        mq.dequeue(); // removes 3
        System.out.println("Current Max: " + mq.getMax()); // 5
        mq.dequeue(); // removes 5
        System.out.println("Current Max: " + mq.getMax()); // 4
    }
}

