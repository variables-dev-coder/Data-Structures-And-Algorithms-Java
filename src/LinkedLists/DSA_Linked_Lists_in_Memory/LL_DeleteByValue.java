package LinkedLists.DSA_Linked_Lists_in_Memory;


// Delete by value

public class LL_DeleteByValue {

    static class Node15 {
        int data;
        Node15 next;

        Node15(int data) {
            this.data = data;
        }
    }

    Node15 head;

    // 🔸 Delete the first node with matching value
    public void deleteByValue(int value) {
        // Case 1: List is empty
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        // Case 2: Head node contains the value
        if (head.data == value) {
            head = head.next;
            System.out.println("Deleted " + value + " from the beginning.");
            return;
        }

        // Case 3: Search and delete matching node
        Node15 current = head;
        while (current.next != null && current.next.data != value) {
            current = current.next;
        }

        if (current.next == null) {
            System.out.println("Value " + value + " not found.");
        } else {
            current.next = current.next.next;
            System.out.println("Deleted " + value + " from the list.");
        }
    }

    // Utility: Insert at end
    public void insertAtEnd(int data) {
        Node15 newNode = new Node15(data);
        if (head == null) {
            head = newNode;
            return;
        }

        Node15 temp = head;
        while (temp.next != null)
            temp = temp.next;
        temp.next = newNode;
    }

    // Utility: Display
    public void display() {
        Node15 temp = head;
        while (temp != null) {
            System.out.print(temp.data + " → ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Main for testing
    public static void main(String[] args) {
        LL_DeleteByValue list = new LL_DeleteByValue();

        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);
        list.insertAtEnd(40);

        System.out.println("Original List:");
        list.display();

        list.deleteByValue(30);  // Delete node with value 30

        System.out.println("After Deletion:");
        list.display();
    }
}
