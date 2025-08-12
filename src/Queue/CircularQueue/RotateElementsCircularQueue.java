package Queue.CircularQueue;

/*
Concept
A circular queue rotation means shifting the elements by a certain number of positions (k), while preserving the circular property.
If k is positive → rotate to the right.
If k is negative → rotate to the left.

ex
Queue: [10, 20, 30, 40, 50]  (front=10, rear=50)
Rotate right by 2 → [40, 50, 10, 20, 30]
Rotate left by 2  → [30, 40, 50, 10, 20]

Logic
1.Use modulo to avoid extra rotations:
k = k % size

2.To rotate right by k:
    New front index = (front - k + size) % size
3.To rotate left by k:
    New front index = (front + k) % size
4.Rear is automatically (front + size - 1) % size.

 */

class CircularQueueRotate {
    private int[] queue;
    private int front, rear, size, capacity;

    public CircularQueueRotate(int capacity) {
        this.capacity = capacity;
        this.queue = new int[capacity];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enqueue(int item) {
        if (isFull()) {
            System.out.println("Queue is full");
            return;
        }
        rear = (rear + 1) % capacity;
        queue[rear] = item;
        size++;
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        int item = queue[front];
        front = (front + 1) % capacity;
        size--;
        return item;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        System.out.print("Queue: ");
        for (int i = 0; i < size; i++) {
            System.out.print(queue[(front + i) % capacity] + " ");
        }
        System.out.println();
    }

    // Rotate queue by k steps (right if k>0, left if k<0)
    public void rotate(int k) {
        if (isEmpty()) return;
        k = k % size; // Avoid unnecessary full rotations
        if (k < 0) { // Left rotation
            front = (front + Math.abs(k)) % capacity;
        } else { // Right rotation
            front = (front - k + capacity) % capacity;
        }
        rear = (front + size - 1) % capacity;
    }
}

public class RotateElementsCircularQueue {

    public static void main(String[] args) {
        CircularQueueRotate cq = new CircularQueueRotate(5);
        cq.enqueue(10);
        cq.enqueue(20);
        cq.enqueue(30);
        cq.enqueue(40);
        cq.enqueue(50);

        cq.display();

        System.out.println("Rotate right by 2:");
        cq.rotate(2);
        cq.display();

        System.out.println("Rotate left by 3:");
        cq.rotate(-3);
        cq.display();
    }
}

/*
Queue: 10 20 30 40 50
Rotate right by 2:
Queue: 40 50 10 20 30
Rotate left by 3:
Queue: 20 30 40 50 10


Dry Run
Initial queue:
front=0, rear=4, [10, 20, 30, 40, 50]

Rotate right by 2:
front = (0 - 2 + 5) % 5 = 3 → front=3, rear=2
Queue: [40, 50, 10, 20, 30]

Rotate left by 3:
front = (3 + 3) % 5 = 1 → front=1, rear=0
Queue: [50, 10, 20, 30, 40]
 */