package LinkedLists.DSA_Circular_Singly_Linked_List;

// Circular Singly Linked List with deleteFromBeginning

class Node4 {
    int data;
    Node4 next;

    Node4(int data) {
        this.data = data;
        this.next = null;
    }
}

public class DeleteFromBeginning {
    Node4 head = null;
    Node4 tail = null;

    // Insert at end
    public void insertAtEnd(int data) {
        Node4 newNode = new Node4(data);

        if (head == null) {
            head = tail = newNode;
            tail.next = head;
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
    }

    // Insert at specific position
    public void insertAtPosition(int position, int data) {
        Node4 newNode = new Node4(data);

        if (position < 1) {
            System.out.println("Invalid position!");
            return;
        }

        if (position == 1) {
            if (head == null) {
                head = tail = newNode;
                tail.next = head;
            } else {
                newNode.next = head;
                head = newNode;
                tail.next = head;
            }
            return;
        }

        Node4 temp = head;
        int count = 1;

        while (count < position - 1 && temp.next != head) {
            temp = temp.next;
            count++;
        }

        if (count < position - 1) {
            System.out.println("Position out of range");
            return;
        }

        newNode.next = temp.next;
        temp.next = newNode;

        if (temp == tail) {
            tail = newNode;
        }
    }

    // Delete from beginning
    public void deleteFromBeginning() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (head == tail) {
            // Only one node
            head = tail = null;
        } else {
            head = head.next;
            tail.next = head;
        }
    }

    // Display the list
    public void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node4 temp = head;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);

        System.out.println();
    }

    // Main method
    public static void main(String[] args) {
         DeleteFromBeginning csll = new DeleteFromBeginning();

        csll.insertAtEnd(10);
        csll.insertAtEnd(20);
        csll.insertAtEnd(30);
        csll.insertAtEnd(40);

        System.out.println("Original List:");
        csll.display(); // Output: 10 20 30 40

        csll.deleteFromBeginning(); // Delete first node

        System.out.println("After deleteFromBeginning:");
        csll.display(); // Output: 20 30 40

        csll.deleteFromBeginning(); // Delete again
        csll.display(); // Output: 30 40
    }
}

/*
Original List:
10 20 30 40
After deleteFromBeginning:
20 30 40
30 40

 */