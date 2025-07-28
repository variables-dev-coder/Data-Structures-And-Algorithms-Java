package LinkedLists.DSA_Linked_Lists_in_Memory;

// LL reverse


public class LL_Reverse {

    // Node class
    static class Node16 {
        int data;
        Node16 next;

        Node16(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Head of the list
    Node16 head;

    // Add node at the end
    public void insertAtEnd(int data) {
        Node16 newNode = new Node16(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node16 temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // Reverse the linked list
    public void reverse() {
        Node16 prev = null;
        Node16 current = head;
        Node16 next = null;

        while (current != null) {
            next = current.next;    // save next
            current.next = prev;    // reverse pointer
            prev = current;         // move prev
            current = next;         // move current
        }

        head = prev; // new head is last node
    }

    // Display the linked list
    public void display() {
        Node16 temp = head;
        while (temp != null) {
            System.out.print(temp.data + " → ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Main method
    public static void main(String[] args) {
        LL_Reverse list = new LL_Reverse();

        // Inserting elements
        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);
        list.insertAtEnd(40);

        System.out.println("Original List:");
        list.display();

        // Reversing
        list.reverse();

        System.out.println("Reversed List:");
        list.display();
    }
}
