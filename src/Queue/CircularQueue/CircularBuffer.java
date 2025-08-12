package Queue.CircularQueue;

public class CircularBuffer {
    int[] buffer;
    int size;
    int front, rear;

    public CircularBuffer(int size) {
        this.size = size;
        buffer = new int[size];
        front = -1;
        rear = -1;
    }

    public boolean isFull() {
        return (front == 0 && rear == size - 1) || (rear + 1) % size == front;
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public void enqueue(int data) {
        if (isFull()) {
            System.out.println("Buffer Overflow! Cannot insert " + data);
            return;
        }
        if (front == -1) {
            front = 0;
        }
        rear = (rear + 1) % size;
        buffer[rear] = data;
        System.out.println("Enqueued: " + data);
    }

    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Buffer Underflow! Cannot remove.");
            return;
        }
        System.out.println("Dequeued: " + buffer[front]);
        if (front == rear) { // Only one element
            front = rear = -1;
        } else {
            front = (front + 1) % size;
        }
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Buffer is empty");
            return;
        }
        System.out.print("Buffer: ");
        int i = front;
        while (true) {
            System.out.print(buffer[i] + " ");
            if (i == rear) break;
            i = (i + 1) % size;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CircularBuffer cb = new CircularBuffer(5);

        cb.enqueue(10);
        cb.enqueue(20);
        cb.enqueue(30);
        cb.enqueue(40);
        cb.enqueue(50);

        cb.display();

        cb.dequeue();
        cb.dequeue();

        cb.enqueue(60);
        cb.enqueue(70);

        cb.display();
    }
}


/*
Enqueued: 10
Enqueued: 20
Enqueued: 30
Enqueued: 40
Enqueued: 50
Buffer: 10 20 30 40 50
Dequeued: 10
Dequeued: 20
Enqueued: 60
Enqueued: 70
Buffer: 30 40 50 60 70

 */

/*
Circular Buffer (Ring Buffer) – Concept
A Circular Buffer (also called a Ring Buffer) is a fixed-size queue that wraps around when it reaches the end.

It’s often used in:
Streaming data (audio/video)
Real-time logging
Producer-consumer problems
Networking (packet buffering)
Fixed memory scenarios (no dynamic allocation)

How It Works
-You have a fixed-size array.
-Two pointers:
    front (or head) → points to the position for reading (dequeue).
    rear (or tail) → points to the position for writing (enqueue).
-When rear reaches the end of the array, it wraps back to 0 (circular movement).
-Overflow: Queue is full when (rear + 1) % size == front.
-Underflow: Queue is empty when front == -1.


Example in Action
Let’s assume buffer size = 5.
Step 1 – Initial
[ _ , _ , _ , _ , _ ]
front = -1
rear  = -1


Step 2 – Enqueue (Add data)
[ 10 , _ , _ , _ , _ ]
front = 0
rear  = 0

Step 3 – Fill up
[ 10 , 20 , 30 , 40 , 50 ]
front = 0
rear  = 4

Step 4 – Dequeue twice (Read two items)
[ _ , _ , 30 , 40 , 50 ]
front = 2
rear  = 4

Step 5 – Wrap around (Enqueue 60, 70)
[ 60 , 70 , 30 , 40 , 50 ]
front = 2
rear  = 1   (wraps to start)

Why Circular Buffer is Better than Normal Queue in Fixed Memory
Efficient in fixed-size storage (no shifting elements)
Prevents wasting unused space at start after dequeues
Perfect for continuous data flow scenarios like streaming

 */