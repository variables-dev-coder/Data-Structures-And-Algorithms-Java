package Revision.Day_5_Queue;


// Queue using Arrays


public class ArrayQueue {
    int[] arr;
    int front, rear, size, capacity;

    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
        front = size = 0;
        rear = capacity - 1; // important for circular
    }

    boolean isFull() { return size == capacity; }
    boolean isEmpty() { return size == 0; }

    void enqueue(int item) {
        if (isFull()) {
            System.out.println("Queue is full!");
            return;
        }
        rear = (rear + 1) % capacity;
        arr[rear] = item;
        size++;
    }

    int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return -1;
        }
        int item = arr[front];
        front = (front + 1) % capacity;
        size--;
        return item;
    }

    int peek() {
        if (isEmpty()) return -1;
        return arr[front];
    }

    public static void main(String[] args) {
        ArrayQueue q = new ArrayQueue(5);
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        System.out.println("Front: " + q.peek());   // 10
        System.out.println("Dequeued: " + q.dequeue()); // 10
        q.enqueue(40);
        q.enqueue(50);
        q.enqueue(60);
        System.out.println("Dequeued: " + q.dequeue()); // 20
    }
}

//Front: 10
//Dequeued: 10
//Dequeued: 20