package Queue.CircularQueue;


/*
Concept
Circular Queue using Linked List:
Nodes are connected in a circular way — the last node points back to the first.
No fixed size limit (unlike array), so overflow is only possible if the system runs out of memory.
Underflow occurs if you try to dequeue from an empty queue.
 */

// Node class for Linked List
class Node2 {
    int data;
    Node2 next;

    Node2(int data) {
        this.data = data;
        this.next = null;
    }
}

// Circular Queue implementation using Linked List
class CircularQueueUsingLinkedList {
    private Node2 front; // Points to first element
    private Node2 rear;  // Points to last element

    public CircularQueueUsingLinkedList() {
        front = null;
        rear = null;
    }

    // Check if queue is empty
    public boolean isEmpty() {
        return front == null;
    }

    // Enqueue operation
    public void enqueue(int value) {
        Node2 newNode = new Node2(value);
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
            newNode.next = front; // Circular link
        } else {
            rear.next = newNode;
            rear = newNode;
            rear.next = front; // Maintain circular link
        }
        System.out.println("Enqueued: " + value);
    }

    // Dequeue operation
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow! Cannot dequeue.");
            return -1;
        }

        int value;
        if (front == rear) { // Only one element
            value = front.data;
            front = null;
            rear = null;
        } else {
            value = front.data;
            front = front.next;
            rear.next = front; // Maintain circular link
        }
        System.out.println("Dequeued: " + value);
        return value;
    }

    // Peek operation
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return -1;
        }
        return front.data;
    }

    // Display the queue
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        }
        System.out.print("Queue: ");
        Node2 temp = front;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != front);
        System.out.println();
    }
}

// Main class to test
public class CircularQueueUsingLinkedListMain {

    public static void main(String[] args) {
        CircularQueueUsingLinkedList cq = new CircularQueueUsingLinkedList();

        // Testing enqueue
        cq.enqueue(10);
        cq.enqueue(20);
        cq.enqueue(30);
        cq.enqueue(40);

        // Display queue
        cq.display();

        // Peek
        System.out.println("Front element: " + cq.peek());

        // Dequeue
        cq.dequeue();
        cq.dequeue();
        cq.display();

        // Dequeue all to cause underflow
        cq.dequeue();
        cq.dequeue();
        cq.dequeue(); // Underflow case
    }

}

/*
Enqueued: 10
Enqueued: 20
Enqueued: 30
Enqueued: 40
Queue: 10 20 30 40
Front element: 10
Dequeued: 10
Dequeued: 20
Queue: 30 40
Dequeued: 30
Dequeued: 40
Queue Underflow! Cannot dequeue.


How Overflow & Underflow Work
Overflow:
In a linked list-based queue, there’s no fixed size, so overflow only happens when memory is full. Unlike array-based queues, we don’t check isFull() here unless we impose a manual limit.

Underflow:
Happens if we try to dequeue() or peek() when front == null (empty queue).
 */