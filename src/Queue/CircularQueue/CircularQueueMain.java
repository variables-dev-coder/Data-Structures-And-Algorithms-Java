package Queue.CircularQueue;

/*
What is a Circular Queue?
A Circular Queue is like a normal queue, but the last position connects back to the
first position, forming a circle.

This helps reuse empty spaces when items are dequeued from the front.

Problem in Normal Queue
If we use a normal queue with an array, after many enqueues and dequeues, front will move forward and waste space.

Example with size = 5:
Enqueue: 10, 20, 30, 40, 50
Dequeue: 10, 20  (front moved ahead)
Now: [x, x, 30, 40, 50]
Even though 2 slots are empty, enqueue fails because rear is at end.


How Circular Queue Fixes This
Instead of rear moving endlessly forward, when rear reaches the end of the array and space is
available at the beginning, rear wraps around to index 0.
We achieve this using modulus (%) operator.

Key Concepts
Let’s store:
front → index of first element
rear → index of last element
size → capacity of queue

Formulas
Enqueue:
rear = (rear + 1) % size

Dequeue:
front = (front + 1) % size

Conditions
isFull: (rear + 1) % size == front
isEmpty: front == -1

 */

class CircularQueue {
    int size;
    int front, rear;
    int[] arr;

    CircularQueue(int size) {
        this.size = size;
        arr = new int[size];
        front = rear = -1;
    }

    // Check if queue is full
    boolean isFull() {
        return (front == 0 && rear == size - 1) || (rear + 1) % size == front;
    }

    // Check if queue is empty
    boolean isEmpty() {
        return front == -1;
    }

    // Add element
    void enqueue(int data) {
        if (isFull()) {
            System.out.println("Queue is full!");
            return;
        }
        if (front == -1) { // first element
            front = 0;
        }
        rear = (rear + 1) % size;
        arr[rear] = data;
    }

    // Remove element
    int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return -1;
        }
        int result = arr[front];
        if (front == rear) { // only one element
            front = rear = -1;
        } else {
            front = (front + 1) % size;
        }
        return result;
    }

    // Peek
    int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return -1;
        }
        return arr[front];
    }

    // Display queue
    void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        }
        int i = front;
        while (true) {
            System.out.print(arr[i] + " ");
            if (i == rear) break;
            i = (i + 1) % size;
        }
        System.out.println();
    }
}


public class CircularQueueMain {

    public static void main(String[] args) {
        CircularQueue q = new CircularQueue(5);
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);
        q.display();

        System.out.println("Dequeued: " + q.dequeue());
        System.out.println("Dequeued: " + q.dequeue());

        q.enqueue(50);
        q.enqueue(60);
        q.display(); // wrap-around happens here

    }
}


/*
10 20 30 40
Dequeued: 10
Dequeued: 20
30 40 50 60
 */


/*
Size = 5

Enqueue 10 → front=0, rear=0 → [10, _, _, _, _]
Enqueue 20 → rear=1 → [10, 20, _, _, _]
Enqueue 30 → rear=2 → [10, 20, 30, _, _]
Enqueue 40 → rear=3 → [10, 20, 30, 40, _]
Dequeue → removes 10 → front=1
Dequeue → removes 20 → front=2
Enqueue 50 → rear wraps to 4 → [_, _, 30, 40, 50]
Enqueue 60 → rear wraps to 0 → [60, _, 30, 40, 50]

 */