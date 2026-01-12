package Queue.revision;

public class QueueUsingArray {

    static int[] queue = new int[5];
    static int front = 0, rear = 0;

    static void enqueue(int x) {
        if (rear == queue.length) {
            System.out.println("Queue Overflow");
            return;
        }
        queue[rear++] = x;
    }

    static void dequeue() {
        if (front == rear) {
            System.out.println("Queue Underflow");
            return;
        }
        System.out.println("Removed: " + queue[front++]);
    }

    static void display() {
        for (int i = front; i < rear; i++) {
            System.out.print(queue[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        enqueue(10);
        enqueue(20);
        enqueue(30);
        display();
        dequeue();
        display();
    }
}

