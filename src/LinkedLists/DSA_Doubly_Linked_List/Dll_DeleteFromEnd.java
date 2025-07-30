package LinkedLists.DSA_Doubly_Linked_List;

// Delete from end

class Node5 {
    int data;
    Node5 prev;
    Node5 next;

    Node5(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

public class Dll_DeleteFromEnd {

    Node5 head;

    // Insert at end
    public void insertAtEnd(int data) {
        Node5 newNode = new Node5(data);
        if (head == null) {
            head = newNode;
            return;
        }

        Node5 temp = head;
        while (temp.next != null)
            temp = temp.next;

        temp.next = newNode;
        newNode.prev = temp;
    }

    // Delete from end
    public void deleteFromEnd() {
        if (head == null) {
            System.out.println("List is empty, nothing to delete.");
            return;
        }

        if (head.next == null) {
            System.out.println("Deleted: " + head.data);
            head = null;
            return;
        }

        Node5 temp = head;
        while (temp.next != null)
            temp = temp.next;

        System.out.println("Deleted: " + temp.data);

        temp.prev.next = null;
        temp.prev = null; // Optional cleanup
    }

    // Display the list
    public void displayForward() {
        Node5 temp = head;
        System.out.print("List: ");
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {

        Dll_DeleteFromEnd dll = new Dll_DeleteFromEnd();

        dll.insertAtEnd(10);
        dll.insertAtEnd(20);
        dll.insertAtEnd(30);
        dll.insertAtEnd(40);
        dll.displayForward();   // List: 10 <-> 20 <-> 30 <-> 40 <-> null

        dll.deleteFromEnd();    // Delete 40
        dll.displayForward();   // List: 10 <-> 20 <-> 30 <-> null

        dll.deleteFromEnd();    // Delete 30
        dll.displayForward();   // List: 10 <-> 20 <-> null
    }
}
