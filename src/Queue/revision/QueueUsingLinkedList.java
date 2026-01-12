package Queue.revision;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class QueueUsingLinkedList {

    static Node front = null, rear = null;

    static void enqueue(int x) {
        Node newNode = new Node(x);

        if (rear == null) {
            front = rear = newNode;
            return;
        }

        rear.next = newNode;
        rear = newNode;
    }

    static void dequeue() {
        if (front == null) {
            System.out.println("Queue Empty");
            return;
        }

        System.out.println("Removed: " + front.data);
        front = front.next;

        if (front == null) rear = null;
    }

    static void display() {
        Node temp = front;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        enqueue(5);
        enqueue(15);
        enqueue(25);
        display();
        dequeue();
        display();
    }
}

