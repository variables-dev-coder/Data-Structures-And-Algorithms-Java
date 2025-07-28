package LinkedLists.DSA_Linked_Lists_in_Memory;


// In Link list Insert data at a position

class Node3 {
    int data;
    Node3 next;

    Node3 (int data) {
        this.data = data;
        this.next = null;
    }
}

public class LLInsertAtPosition {

    Node3 head;

    //Insert at specific position
    public void insertAtPosition(int pos, int value) {
        Node3 newNode = new Node3(value);

        // case 1: Insert at head
        if (pos == 0) {
            newNode.next = head;
            head = newNode;
            return;
        }

        // Traverse to (pos - 1)
        Node3 temp = head;
        int count = 0;

        while (temp != null & count < pos - 1) {
            temp = temp.next;
            count++;
        }

        // If position is invalid
        if (temp == null) {
            System.out.println("Invalid Position");
            return;
        }

        // Insert newNode at position
        newNode.next = temp.next;
        temp.next = newNode;
    }

    // Display the list
    public void display() {
        Node3 temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Main to test
    public static void main(String[] args) {
        LLInsertAtPosition list = new LLInsertAtPosition();

        list.insertAtEnd(10);
        list.insertAtEnd(30);
        list.insertAtPosition(1, 20);  // Insert 20 between 10 and 30
        list.insertAtPosition(0, 5);   // Insert 5 at head
        list.insertAtPosition(4, 40);  // Insert 40 at end
        list.insertAtPosition(10, 100); // Invalid

        list.display();  // Output: 5 -> 10 -> 20 -> 30 -> 40 -> null
    }

    // Helper to insert at end (reused from earlier)
    public void insertAtEnd(int value) {
        Node3 newNode = new Node3(value);
        if (head == null) {
            head = newNode;
            return;
        }
        Node3 temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }
}
