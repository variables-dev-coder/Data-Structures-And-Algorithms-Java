package Queue.CircularQueue;


/*
1.Concept
A Circular Queue using a linked list is just like a normal queue (FIFO — First In First Out),
but the last node’s next pointer connects back to the first node, forming a circle.

Why use linked list?

    No fixed size like an array — grows dynamically.
    Avoids shifting elements during dequeue.

2.Structure
We’ll maintain:

    front → first element in queue (dequeue happens here)
    rear → last element in queue (enqueue happens here)
    In circular queue, rear.next = front.

Dequeue (Remove)
    If empty → "Queue Underflow".
    If only one element → set both front and rear to null.
    Else → move front to front.next → rear.next = front.

Peek
    Return front.data if not empty.

isEmpty
    front == null

 */

class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class CircularQueue2 {
    Node front = null;
    Node rear = null;

    // Enqueue
    public void enqueue(int data) {
        Node newNode = new Node(data);
        if (front == null) { // Empty queue
            front = newNode;
            rear = newNode;
            rear.next = front;
        } else {
            rear.next = newNode;
            rear = newNode;
            rear.next = front;
        }
        System.out.println(data + " inserted");
    }

    // Dequeue
    public void dequeue() {
        if (front == null) {
            System.out.println("Queue Underflow");
            return;
        }
        if (front == rear) { // Only one element
            System.out.println(front.data + " removed");
            front = null;
            rear = null;
        } else {
            System.out.println(front.data + " removed");
            front = front.next;
            rear.next = front;
        }
    }

    // Peek
    public void peek() {
        if (front == null) {
            System.out.println("Queue is empty");
        } else {
            System.out.println("Front element: " + front.data);
        }
    }

    // Display
    public void display() {
        if (front == null) {
            System.out.println("Queue is empty");
            return;
        }
        Node temp = front;
        System.out.print("Queue elements: ");
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != front);
        System.out.println();
    }
}

public class CircularQueueLinkedList {

    public static void main(String[] args) {
        CircularQueue2 cq = new CircularQueue2();
        cq.enqueue(10);
        cq.enqueue(20);
        cq.enqueue(30);
        cq.display();
        cq.dequeue();
        cq.display();
        cq.peek();
    }
}



/*
enqueue(10)
enqueue(20)
enqueue(30)
display()
dequeue()
display()
peek()


Step-by-step:

1.enqueue(10) → first element, front = rear = 10, rear.next → front
    Queue: 10 → back to 10

2.enqueue(20) → rear.next = 20, rear = 20, rear.next = front
    Queue: 10 → 20 → back to 10

3.enqueue(30) → rear.next = 30, rear = 30, rear.next = front
    Queue: 10 → 20 → 30 → back to 10

4.display() → prints 10 20 30

5.dequeue() → remove 10, front = 20, rear.next = 20
    Queue: 20 → 30 → back to 20

6.display() → prints 20 30

7.peek() → front = 20


 */