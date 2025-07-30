package LinkedLists.DSA_Doubly_Linked_List;


// DLL insert at beginning

// Node definition
class Node2 {
    int data;
    Node2 prev;
    Node2 next;

    Node2(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}
public class Dll_InsertAtBeginning {

    Node2 head;

    // Insert at beginning
    public void insertAtBeginning(int data) {
        Node2 newNode = new Node2(data);

        if (head != null) {
            newNode.next = head;
            head.prev = newNode;
        }

        head = newNode;
    }

    // Display forward
    public void displayForward() {
        Node2 temp = head;
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Main method to test
    public static void main(String[] args) {
        Dll_InsertAtBeginning dll = new Dll_InsertAtBeginning();

        dll.insertAtBeginning(30);
        dll.insertAtBeginning(20);
        dll.insertAtBeginning(10);
        dll.displayForward();  // Output: 10 <-> 20 <-> 30 <-> null
    }
}
