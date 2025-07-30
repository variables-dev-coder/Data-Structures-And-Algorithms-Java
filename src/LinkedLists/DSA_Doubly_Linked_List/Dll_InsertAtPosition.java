package LinkedLists.DSA_Doubly_Linked_List;

// Dll insert at a position

class Node3 {
    int data;
    Node3 prev;
    Node3 next;

    Node3(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

public class Dll_InsertAtPosition {

    Node3 head;

    // Insert at beginning (for testing insertAtPosition)
    public void insertAtBeginning(int data) {
        Node3 newNode = new Node3(data);
        newNode.next = head;
        if (head != null)
            head.prev = newNode;
        head = newNode;
    }

    // Insert at specific position
    public void insertAtPosition(int position, int data) {
        if (position < 1) {
            System.out.println("Invalid position!");
            return;
        }

        Node3 newNode = new Node3(data);

        // Insert at beginning if position == 1
        if (position == 1) {
            newNode.next = head;
            if (head != null) head.prev = newNode;
            head = newNode;
            return;
        }

        Node3 temp = head;
        int count = 1;

        // Traverse to (position - 1)th node
        while (count < position - 1 && temp != null) {
            temp = temp.next;
            count++;
        }

        if (temp == null) {
            System.out.println("Position out of range.");
            return;
        }

        newNode.next = temp.next;
        newNode.prev = temp;

        if (temp.next != null)
            temp.next.prev = newNode;

        temp.next = newNode;
    }

    // Display the list forward
    public void displayForward() {
        Node3 current = head;
        System.out.print("List: ");
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Dll_InsertAtPosition dll = new Dll_InsertAtPosition();

        dll.insertAtBeginning(30);
        dll.insertAtBeginning(20);
        dll.insertAtBeginning(10);

        dll.displayForward();

        dll.insertAtPosition(2, 15);
        dll.displayForward();
    }
}






