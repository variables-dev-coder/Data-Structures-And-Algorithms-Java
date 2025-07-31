package LinkedLists.DSA_Circular_Singly_Linked_List;

// insertAtBeginning() in Circular Singly Linked List (Java)
//This operation inserts a new node at the start of the list.
// In Circular Singly Linked List, the new node becomes the head, and the last node's next points to the new head.

class Node1 {
    int data;
    Node1 next;

    Node1(int data) {
        this.data = data;
        this.next = null;
    }
}

public class InsertAtBeginning {
    Node1 head = null;
    Node1 tail = null;

    // Insert at beginning
    public void insertAtBeginning(int data) {
        Node1 newNode = new Node1(data);

        if (head == null) {
            // List is empty
            head = newNode;
            tail = newNode;
            newNode.next = head;
        } else {
            newNode.next = head;
            head = newNode;
            tail.next = head; // make circular
        }
    }

    // Display the list
    public void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node1 temp = head;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }

    public static void main(String[] args) {
        InsertAtBeginning csll = new InsertAtBeginning();

        csll.insertAtBeginning(30);
        csll.insertAtBeginning(20);
        csll.insertAtBeginning(10);
        csll.display();  // Output: 10 20 30
    }
}


// 10 20 30