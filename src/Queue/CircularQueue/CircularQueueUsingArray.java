package Queue.CircularQueue;


/*

1. Understanding Overflow & Underflow in Circular Queue
In a Circular Queue, elements wrap around using modulo (%) when they reach the end of the array.

Overflow Condition (Queue is Full)
Happens when the next position of rear (calculated using (rear + 1) % size) is equal to front.

(rear + 1) % size == front

Underflow Condition (Queue is Empty)
Happens when front == -1 (no elements in queue).
 */

public class CircularQueueUsingArray {

    private int[] queue;
    private int front, rear, size, capacity;

    // Constructor
    public CircularQueueUsingArray(int capacity) {
        this.capacity = capacity;
        this.queue = new int[capacity];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    // Check if queue is full
    public boolean isFull() {
        return size == capacity;
    }

    // Check if queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Add element to queue (Enqueue)
    public void enqueue(int data) {
        if (isFull()) {
            System.out.println("Queue Overflow! Cannot enqueue " + data);
            return;
        }
        rear = (rear + 1) % capacity; // Circular increment
        queue[rear] = data;
        size++;
        System.out.println("Enqueued: " + data);
    }

    // Remove element from queue (Dequeue)
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow! Cannot dequeue.");
            return -1; // Indicates error
        }
        int removed = queue[front];
        front = (front + 1) % capacity; // Circular increment
        size--;
        System.out.println("Dequeued: " + removed);
        return removed;
    }

    // Peek at front element
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Nothing to peek.");
            return -1;
        }
        return queue[front];
    }

    // Display queue elements
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.print("Queue: ");
        for (int i = 0; i < size; i++) {
            System.out.print(queue[(front + i) % capacity] + " ");
        }
        System.out.println();
    }

    // Main method for testing
    public static void main(String[] args) {
        CircularQueueUsingArray cq = new CircularQueueUsingArray(5);

        cq.enqueue(10);
        cq.enqueue(20);
        cq.enqueue(30);
        cq.enqueue(40);
        cq.enqueue(50); // Full now
        cq.enqueue(60); // Overflow

        cq.display();
        System.out.println("Peek: " + cq.peek());

        cq.dequeue();
        cq.dequeue();
        cq.display();

        cq.enqueue(60);
        cq.enqueue(70);
        cq.display();

        cq.dequeue();
        cq.dequeue();
        cq.dequeue();
        cq.dequeue(); // Underflow
    }
}


/*
Enqueued: 10
Enqueued: 20
Enqueued: 30
Enqueued: 40
Enqueued: 50
Queue Overflow! Cannot enqueue 60
Queue: 10 20 30 40 50
Peek: 10
Dequeued: 10
Dequeued: 20
Queue: 30 40 50
Enqueued: 60
Enqueued: 70
Queue: 30 40 50 60 70
Dequeued: 30
Dequeued: 40
Dequeued: 50
Dequeued: 60


How It Works
Overflow check → If size == capacity → can't enqueue more.
Underflow check → If size == 0 → can't dequeue.
Circular indexing → (index + 1) % capacity keeps the queue circular.
front points to first element, rear points to last element.
size tracks number of elements in queue.

Dry Run Example

Size = 5
Queue: [0, 0, 0, 0, 0]
front = -1, rear = -1

enqueue(10) → front=0, rear=0 → [10, 0, 0, 0, 0]
enqueue(20) → rear=1 → [10, 20, 0, 0, 0]
enqueue(30) → rear=2 → [10, 20, 30, 0, 0]

dequeue() → removes 10, front=1
enqueue(40) → rear=3 → [10, 20, 30, 40, 0]
enqueue(50) → rear=4 → [10, 20, 30, 40, 50]
enqueue(60) → OVERFLOW because (rear+1)%size == front

 */