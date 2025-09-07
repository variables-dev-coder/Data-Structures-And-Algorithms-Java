package Revision.Day_5_Queue;

import java.util.*;

class QueueOneStack {
    Stack<Integer> s = new Stack<>();

    // Enqueue is simple push
    void enqueue(int x) {
        s.push(x);
    }

    // Dequeue is recursive
    int dequeue() {
        if (s.isEmpty()) {
            System.out.println("Queue is empty!");
            return -1;
        }
        int x = s.pop();
        if (s.isEmpty()) {
            // last element = front of queue
            return x;
        }
        int res = dequeue(); // recursive call
        s.push(x); // push back
        return res;
    }

    public static void main(String[] args) {
        QueueOneStack q = new QueueOneStack();
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        System.out.println("Dequeued: " + q.dequeue()); // 10
        q.enqueue(40);
        System.out.println("Dequeued: " + q.dequeue()); // 20
    }
}

