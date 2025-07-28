package LinkedLists.DSA_Linked_Lists_in_Memory;


// Delete at a Position

class Node12 {
    int data;
    Node12 next;

    Node12(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LL_DeleteAtPosition {

    Node12 head;

    // Insert at end (for testing)
    public void insertAtEnd(int value) {
        Node12 newNode = new Node12(value);
        if (head == null) {
            head = newNode;
            return;
        }
        Node12 temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // Delete at specific position
    public void deleteAtPosition(int pos) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        // Case 1: Delete head (pos = 0)
        if (pos == 0) {
            System.out.println("Deleted: " + head.data);
            head = head.next;
            return;
        }

        Node12 temp = head;
        int count = 0;

        // Traverse to (pos - 1) node
        while (temp != null && count < pos - 1) {
            temp = temp.next;
            count++;
        }

        // Invalid position
        if (temp == null || temp.next == null) {
            System.out.println("Invalid position.");
            return;
        }

        System.out.println("Deleted: " + temp.next.data);
        temp.next = temp.next.next;
    }

    // Display the list
    public void display() {
        Node12 temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Main to test
    public static void main(String[] args) {
        LL_DeleteAtPosition list = new LL_DeleteAtPosition();

        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);
        list.insertAtEnd(40);

        list.display();                   // 10 -> 20 -> 30 -> 40 -> null

        list.deleteAtPosition(2);         // Deletes 30
        list.display();                   // 10 -> 20 -> 40 -> null

        list.deleteAtPosition(0);         // Deletes 10
        list.display();                   // 20 -> 40 -> null

        list.deleteAtPosition(5);         // Invalid position
        list.display();                   // 20 -> 40 -> null

        list.deleteAtPosition(1);         // Deletes 40
        list.deleteAtPosition(0);         // Deletes 20
        list.deleteAtPosition(0);         // List is empty
    }
}
