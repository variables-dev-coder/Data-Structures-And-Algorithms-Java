package Queue.Deque;


/*
Problem Statement

Implement a double-ended queue (deque) using a fixed-size array, with the following operations:
insertFront(x) – Add element at front.
insertRear(x) – Add element at rear.
deleteFront() – Remove element from front.
deleteRear() – Remove element from rear.
getFront() – Get front element.
getRear() – Get rear element.
isFull() – Check if deque is full.
isEmpty() – Check if deque is empty.

Approach
Maintain:

front pointer
rear pointer
size of array

Use circular indexing so that after reaching the end of the array, it wraps around ((index + 1) % size).

For front:
Move front backward (front - 1 + size) % size for insert.

For rear:
Move rear forward (rear + 1) % size for insert.

 */


public class ArrayDeque {
    private int[] arr;
    private int front, rear, size, capacity;

    public ArrayDeque(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
        front = -1;
        rear = 0;
        size = 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void insertFront(int key) {
        if (isFull()) {
            System.out.println("Overflow! Cannot insert at front");
            return;
        }
        if (front == -1) { // first element
            front = 0;
            rear = 0;
        } else {
            front = (front - 1 + capacity) % capacity;
        }
        arr[front] = key;
        size++;
    }

    public void insertRear(int key) {
        if (isFull()) {
            System.out.println("Overflow! Cannot insert at rear");
            return;
        }
        if (front == -1) { // first element
            front = 0;
            rear = 0;
        } else {
            rear = (rear + 1) % capacity;
        }
        arr[rear] = key;
        size++;
    }

    public void deleteFront() {
        if (isEmpty()) {
            System.out.println("Underflow! Cannot delete from front");
            return;
        }
        if (front == rear) { // only one element
            front = -1;
            rear = 0;
        } else {
            front = (front + 1) % capacity;
        }
        size--;
    }

    public void deleteRear() {
        if (isEmpty()) {
            System.out.println("Underflow! Cannot delete from rear");
            return;
        }
        if (front == rear) { // only one element
            front = -1;
            rear = 0;
        } else {
            rear = (rear - 1 + capacity) % capacity;
        }
        size--;
    }

    public int getFront() {
        if (isEmpty()) {
            System.out.println("Deque is empty");
            return -1;
        }
        return arr[front];
    }

    public int getRear() {
        if (isEmpty()) {
            System.out.println("Deque is empty");
            return -1;
        }
        return arr[rear];
    }

    public static void main(String[] args) {
        ArrayDeque dq = new ArrayDeque(5);

        dq.insertRear(1);
        dq.insertRear(2);
        dq.insertFront(0);
        dq.insertRear(3);

        System.out.println("Front element: " + dq.getFront());
        System.out.println("Rear element: " + dq.getRear());

        dq.deleteFront();
        dq.deleteRear();

        System.out.println("Front element after deletion: " + dq.getFront());
        System.out.println("Rear element after deletion: " + dq.getRear());
    }
}

/*
Dry Run

Insert:
insertRear(1) → [1]
insertRear(2) → [1, 2]
insertFront(0) → [0, 1, 2]
insertRear(3) → [0, 1, 2, 3]

Delete:
deleteFront() → [1, 2, 3]
deleteRear() → [1, 2]


 */