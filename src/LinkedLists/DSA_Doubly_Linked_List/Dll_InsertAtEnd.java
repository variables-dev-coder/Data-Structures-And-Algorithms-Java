package LinkedLists.DSA_Doubly_Linked_List;

// Dll Insert at end

class Node1 {
    int data;
    Node1 prev;
    Node1 next;

    Node1(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

public class Dll_InsertAtEnd {

    Node1 head;

    // Insert at end
    public void insertAtEnd(int data) {
        Node1 newNode = new Node1(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node1 temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
        newNode.prev = temp;
    }

    // Display list
    public void displayForward() {
        Node1 temp = head;
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Dll_InsertAtEnd dll = new Dll_InsertAtEnd();

        dll.insertAtEnd(10);
        dll.insertAtEnd(20);
        dll.insertAtEnd(30);
        dll.displayForward();  // Output: 10 <-> 20 <-> 30 <-> null
    }

}
