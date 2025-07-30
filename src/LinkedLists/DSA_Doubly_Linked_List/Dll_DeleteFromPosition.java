package LinkedLists.DSA_Doubly_Linked_List;

// Delete from position

class Node6 {
    int data;
    Node6 prev;
    Node6 next;

    Node6(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

public class Dll_DeleteFromPosition {

    Node6 head;

    // Insert at end
    public void insertAtEnd(int data) {
        Node6 newNode = new Node6(data);
        if (head == null) {
            head = newNode;
            return;
        }

        Node6 temp = head;
        while (temp.next != null)
            temp = temp.next;

        temp.next = newNode;
        newNode.prev = temp;
    }

    // Delete from given position
    public void deleteFromPosition(int position) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        if (position <= 0) {
            System.out.println("Invalid position.");
            return;
        }

        Node6 temp = head;

        // If deleting head
        if (position == 1) {
            System.out.println("Deleted: " + temp.data);
            head = head.next;
            if (head != null) head.prev = null;
            return;
        }

        // Traverse to the position
        for (int i = 1; temp != null && i < position; i++) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Position out of bounds.");
            return;
        }

        System.out.println("Deleted: " + temp.data);

        if (temp.next != null)
            temp.next.prev = temp.prev;

        if (temp.prev != null)
            temp.prev.next = temp.next;

        temp.next = null;
        temp.prev = null;
    }

    // Display list
    public void displayForward() {
        Node6 temp = head;
        System.out.print("List: ");
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Dll_DeleteFromPosition dll = new Dll_DeleteFromPosition();

        dll.insertAtEnd(10);
        dll.insertAtEnd(20);
        dll.insertAtEnd(30);
        dll.insertAtEnd(40);
        dll.displayForward();  // List: 10 <-> 20 <-> 30 <-> 40 <-> null

        dll.deleteFromPosition(2); // Delete 20
        dll.displayForward();      // List: 10 <-> 30 <-> 40 <-> null

        dll.deleteFromPosition(1); // Delete 10 (head)
        dll.displayForward();      // List: 30 <-> 40 <-> null

        dll.deleteFromPosition(5); // Invalid position

    }
}
