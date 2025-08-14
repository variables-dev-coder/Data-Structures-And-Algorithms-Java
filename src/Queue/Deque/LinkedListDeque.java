package Queue.Deque;


/*
Problem Statement

Implement a double-ended queue (deque) using a doubly linked list, with operations:

insertFront(x) – Insert at front.
insertRear(x) – Insert at rear.
deleteFront() – Remove from front.
deleteRear() – Remove from rear.
getFront() – Return front element.
getRear() – Return rear element.
isEmpty() – Check if deque is empty.

Why Linked List?
No fixed size limitation (like array-based deque).
Insertions and deletions from both ends are O(1) time.
Uses doubly linked list so we can move in both directions.

 */


class Node {
    int data;
    Node prev, next;
    Node(int data) {
        this.data = data;
        this.prev = this.next = null;
    }
}

class LinkedListDeque {
    Node front, rear;

    public LinkedListDeque() {
        front = rear = null;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void insertFront(int key) {
        Node newNode = new Node(key);
        if (isEmpty()) {
            front = rear = newNode;
        } else {
            newNode.next = front;
            front.prev = newNode;
            front = newNode;
        }
    }

    public void insertRear(int key) {
        Node newNode = new Node(key);
        if (isEmpty()) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            newNode.prev = rear;
            rear = newNode;
        }
    }

    public void deleteFront() {
        if (isEmpty()) {
            System.out.println("Deque is empty!");
            return;
        }
        if (front == rear) {
            front = rear = null;
        } else {
            front = front.next;
            front.prev = null;
        }
    }

    public void deleteRear() {
        if (isEmpty()) {
            System.out.println("Deque is empty!");
            return;
        }
        if (front == rear) {
            front = rear = null;
        } else {
            rear = rear.prev;
            rear.next = null;
        }
    }

    public int getFront() {
        if (isEmpty()) {
            System.out.println("Deque is empty!");
            return -1;
        }
        return front.data;
    }

    public int getRear() {
        if (isEmpty()) {
            System.out.println("Deque is empty!");
            return -1;
        }
        return rear.data;
    }

    public static void main(String[] args) {
        LinkedListDeque dq = new LinkedListDeque();

        dq.insertRear(1);
        dq.insertRear(2);
        dq.insertFront(0);
        dq.insertRear(3);

        System.out.println("Front: " + dq.getFront()); // 0
        System.out.println("Rear: " + dq.getRear());   // 3

        dq.deleteFront();
        dq.deleteRear();

        System.out.println("Front after deletion: " + dq.getFront()); // 1
        System.out.println("Rear after deletion: " + dq.getRear());   // 2
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