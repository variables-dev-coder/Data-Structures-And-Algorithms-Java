package LinkedLists.DSA_Linked_Lists_in_Memory;


// Delete from end

class Node11 {
    int data;
    Node11 next;

    Node11(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LL_DeleteFromEnd {

    Node11 head;

    // Insert at end (for testing)
    public void insertAtEnd(int value) {
        Node11 newNode = new Node11(value);
        if (head == null) {
            head = newNode;
            return;
        }
        Node11 temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // Delete from end
    public void deleteFromEnd() {
        if (head == null) {
            System.out.println("List is already empty.");
            return;
        }

        // Case: Only one node
        if (head.next == null) {
            System.out.println("Deleted: " + head.data);
            head = null;
            return;
        }

        // Traverse to second last node
        Node11 temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }

        // temp.next is the last node
        System.out.println("Deleted: " + temp.next.data);
        temp.next = null;
    }

    // Display list
    public void display() {
        Node11 temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Main to test
    public static void main(String[] args) {
        LL_DeleteFromEnd list = new LL_DeleteFromEnd();

        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);

        list.display();            // 10 -> 20 -> 30 -> null
        list.deleteFromEnd();      // Deletes 30
        list.display();            // 10 -> 20 -> null
        list.deleteFromEnd();      // Deletes 20
        list.display();            // 10 -> null
        list.deleteFromEnd();      // Deletes 10
        list.display();            // null
        list.deleteFromEnd();      // Already empty
    }
}
