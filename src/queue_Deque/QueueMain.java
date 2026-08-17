package queue_Deque;


class MyQueue {

    private int[] queue;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    public MyQueue(int capacity) {

        this.capacity = capacity;
        queue = new int[capacity];

        front = 0;
        rear = -1;
        size = 0;
    }

    // Add element
    public void enqueue(int value) {

        if (isFull()) {
            System.out.println("Queue is full");
            return;
        }

        rear++;

        queue[rear] = value;

        size++;
    }

    // Remove element
    public int dequeue() {

        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }

        int value = queue[front];

        front++;

        size--;

        return value;
    }

    // See front element
    public int peek() {

        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }

        return queue[front];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }
}

public class QueueMain {

    public static void main(String[] args) {

        MyQueue q = new MyQueue(5);

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);

        System.out.println(q.peek());

        System.out.println(q.dequeue());
        System.out.println(q.dequeue());

        System.out.println(q.peek());
    }
}

//10
//10
//20
//30