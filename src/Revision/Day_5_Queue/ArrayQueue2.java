package Revision.Day_5_Queue;

public class ArrayQueue2 {
    int[] arr;
    int front, rear, size, capacity;

    public ArrayQueue2(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
        front = size = 0;
        rear = capacity - 1;
    }

    boolean isFull() {
        return size == capacity;
    }

    boolean isEmpty() {
        return size == 0;
    }

    void enqueue(int item) {
        if (isFull()) {
            System.out.println("Queue is full");
            return;
        }

        rear = (rear + 1) % capacity;
        arr[rear] = item;
        size++;
    }

    int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return - 1;
        }

        int item = arr[front];
        front = (front + 1) % capacity;
        size--;
        return item;
    }

    int peek() {
        if (isEmpty()) return - 1;
        return arr[front];
    }

    public static void main(String[] args) {
        ArrayQueue2 q = new ArrayQueue2(5);

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);

        System.out.println("Front: " + q.peek()); // 10

        System.out.println("Dequeue: " + q.dequeue());  // remove 10

        q.enqueue(40);
        q.enqueue(50);
        q.enqueue(60);

        System.out.println("Dequeue: " + q.dequeue());    // remove 20

        System.out.println(q.size);  // 4

        System.out.println(q.front);  // index 2

        System.out.println(q.rear);   // index 0

        System.out.println(q.capacity);  // 5

        System.out.println(q.isEmpty());  // false

        System.out.println(q.isFull());  // false

        System.out.println(q.peek());   // 30
        
    }
}
