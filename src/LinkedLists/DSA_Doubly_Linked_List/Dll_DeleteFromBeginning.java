package LinkedLists.DSA_Doubly_Linked_List;



class Node4 {
    int data;
    Node4 prev;
    Node4 next;

    Node4(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

public class Dll_DeleteFromBeginning {

    Node4 head;

    // Insert at end for testing
    public void insertAtEnd(int data) {
        Node4 newNode = new Node4(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node4 temp = head;
        while (temp.next != null)
            temp = temp.next;

        temp.next = newNode;
        newNode.prev = temp;
    }

    // Delete from beginning
    public void deleteFromBeginning() {
        if (head == null) {
            System.out.println("List is empty, nothing to delete.");
            return;
        }

        System.out.println("Deleted: " + head.data);

        head = head.next;
        if (head != null)
            head.prev = null;
    }

    // Display the list forward
    public void displayForward() {
        Node4 temp = head;
        System.out.print("List: ");
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Dll_DeleteFromBeginning dll = new Dll_DeleteFromBeginning();

        dll.insertAtEnd(10);
        dll.insertAtEnd(20);
        dll.insertAtEnd(30);
        dll.insertAtEnd(40);
        dll.displayForward(); // List: 10 <-> 20 <-> 30 <-> 40 <-> null

        dll.deleteFromBeginning();      // Delete 10
        dll.displayForward();           // List: 20 <-> 30 <-> 40 <-> null

        dll.deleteFromBeginning();      // Delete 20
        dll.displayForward();           // List: 30 <-> 40 <-> null

    }
}
