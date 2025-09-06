package Revision.Day_5_Queue;

class Node {
    int data;
    Node next;
    Node(int d) { data = d; next = null; }
}

class LinkedQueue {
    Node front, rear;

    void enqueue(int x) {
        Node temp = new Node(x);
        if (rear == null) {
            front = rear = temp;
            return;
        }
        rear.next = temp;
        rear = temp;
    }

    int dequeue() {
        if (front == null) {
            System.out.println("Queue is empty!");
            return -1;
        }
        int val = front.data;
        front = front.next;
        if (front == null) rear = null;
        return val;
    }

    int peek() {
        return (front != null) ? front.data : -1;
    }

    public static void main(String[] args) {
        LinkedQueue q = new LinkedQueue();
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        System.out.println("Front: " + q.peek());   // 10
        System.out.println("Dequeued: " + q.dequeue()); // 10
        System.out.println("Front: " + q.peek());   // 20
    }
}

//Front: 10
//Dequeued: 10
//Front: 20