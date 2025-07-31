package LinkedLists.DSA_Circular_Singly_Linked_List;

// Insertion at position in scll

class Node3 {
    int data;
    Node3 next;

    Node3(int data) {
        this.data = data;
        this.next = null;
    }
}

public class InsertAtPosition {

    Node3 head = null;
    Node3 tail = null;

    // Insert at end
    public void insertAtEnd(int data) {
        Node3 newNode = new Node3(data);

        if (head == null) {
            head = tail = newNode;
            tail.next = head;  // Circular link
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
    }

    // Insert at specific position
    public void insertAtPosition(int position, int data) {
        Node3 newNode = new Node3(data);

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

        Node3 temp = head;
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

    // Display the list
    public void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node3 temp = head;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);

        System.out.println();
    }

    // Main method
    public static void main(String[] args) {
        InsertAtPosition csll = new InsertAtPosition();

        csll.insertAtEnd(10);
        csll.insertAtEnd(20);
        csll.insertAtEnd(30);
        csll.insertAtEnd(40);

        csll.display(); // Output: 10 20 30 40

        csll.insertAtPosition(1, 5);   // Insert at beginning
        csll.insertAtPosition(3, 15);  // Insert in middle
        csll.insertAtPosition(7, 50);  // Insert at end

        csll.display(); // Output: 5 10 15 20 30 40 50
    }
}

/*
10 20 30 40
5 10 15 20 30 40 50

 */