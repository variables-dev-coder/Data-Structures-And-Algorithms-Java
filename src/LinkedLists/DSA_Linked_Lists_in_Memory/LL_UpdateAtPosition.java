package LinkedLists.DSA_Linked_Lists_in_Memory;

public class LL_UpdateAtPosition {

    static class Node13 {
        int data;
        Node13 next;

        Node13(int data) {
            this.data = data;
        }
    }

    Node13 head;

    // Update node data at a specific position
    public void updateAtPosition(int pos, int newValue) {
        if (pos <= 0) {
            System.out.println("Invalid position");
            return;
        }

        Node13 current = head;
        int count = 1;

        while (current != null && count < pos) {
            current = current.next;
            count++;
        }

        if (current == null) {
            System.out.println("Position out of bounds");
        } else {
            current.data = newValue;
            System.out.println("Node updated at position " + pos);
        }
    }

    // Utility: Insert at end for testing
    public void insertAtEnd(int data) {
        Node13 newNode = new Node13(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node13 temp = head;
        while (temp.next != null)
            temp = temp.next;
        temp.next = newNode;
    }

    // Utility: Display
    public void display() {
        Node13 temp = head;
        while (temp != null) {
            System.out.print(temp.data + " → ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Main for testing
    public static void main(String[] args) {
        LL_UpdateAtPosition list = new LL_UpdateAtPosition();

        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);
        list.insertAtEnd(40);

        System.out.println("Original List:");
        list.display();

        list.updateAtPosition(3, 99);  // Updating value at 3rd position to 99

        System.out.println("After update:");
        list.display();
    }
}
