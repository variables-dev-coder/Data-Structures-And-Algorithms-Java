package Revision.Day_5_Queue;

import java.util.*;

class QueueUsingStacks {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    void enqueue(int x) {
        s1.push(x);
    }

    int dequeue() {
        if (s1.isEmpty() && s2.isEmpty()) {
            System.out.println("Queue is empty!");
            return -1;
        }
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) s2.push(s1.pop());
        }
        return s2.pop();
    }

    public static void main(String[] args) {
        QueueUsingStacks q = new QueueUsingStacks();
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        System.out.println("Dequeued: " + q.dequeue()); // 10
        q.enqueue(40);
        System.out.println("Dequeued: " + q.dequeue()); // 20
    }
}

//Dequeued: 10
//Dequeued: 20
