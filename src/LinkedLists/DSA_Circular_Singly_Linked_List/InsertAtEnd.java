package LinkedLists.DSA_Circular_Singly_Linked_List;


class Node2 {
    int data;
    Node2 next;

    public Node2(int data) {
        this.data = data;
        this.next = null;
    }
}

public class InsertAtEnd {
    Node2 head = null;
    Node2 tail = null;

    // Insert at end
    public void insertAtEnd(int data) {
        Node2 newNode = new Node2(data);

        if (head == null) {
            head = newNode;
            tail = newNode;
            newNode.next = head; // circle back
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head; // maintain circle
        }
    }

    // Display the list
    public void display() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node2 temp = head;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }

    // Main method to test
    public static void main(String[] args) {
        InsertAtEnd csll = new InsertAtEnd();

        csll.insertAtEnd(10);
        csll.insertAtEnd(20);
        csll.insertAtEnd(30);
        csll.insertAtEnd(40);

        csll.display();  // Output: 10 20 30 40
    }
}

// 10 20 30 40