package LinkedLists.DSA_Linked_Lists_in_Memory;

// delete data from beginning

class Node4 {
    int data;
    Node4 next;

    Node4(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LL_DeleteFromBeginning {

    Node4 head;

    // Insert at end (for testing)
    public void insertAtEnd(int value) {
        Node4 newNode = new Node4(value);
        if (head == null) {
            head = newNode;
            return;
        }
        Node4 temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // Delete from beginning
    public void deleteFromBeginning() {
        if (head == null) {
            System.out.println("List is already empty.");
            return;
        }

        System.out.println("Deleted: " + head.data);
        head = head.next; // Move head to next node
    }

    // Display list
    public void display() {
        Node4 temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Main to test
    public static void main(String[] args) {
        LL_DeleteFromBeginning list = new LL_DeleteFromBeginning();

        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);

        list.display();              // 10 -> 20 -> 30 -> null
        list.deleteFromBeginning();  // Deletes 10
        list.display();              // 20 -> 30 -> null
        list.deleteFromBeginning();  // Deletes 20
        list.display();              // 30 -> null
        list.deleteFromBeginning();  // Deletes 30
        list.display();              // null
        list.deleteFromBeginning();  // Already empty
    }
}
