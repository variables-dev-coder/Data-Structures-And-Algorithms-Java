package LinkedLists.DSA_Circular_Singly_Linked_List;

// CSLL Delete from end

class Node5 {
    int data;
    Node5 next;

    Node5(int data) {
        this.data = data;
        this.next = null;
    }
}

public class DeleteFromEnd {

    Node5 head = null;
    Node5 tail = null;

    // Insert at end
    public void insertAtEnd(int data) {
        Node5 newNode = new Node5(data);

        if (head == null) {
            head = tail = newNode;
            tail.next = head;
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
    }

    // Delete from end
    public void deleteFromEnd() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (head == tail) {
            // Only one node
            head = tail = null;
            return;
        }

        Node5 current = head;
        while (current.next != tail) {
            current = current.next;
        }

        current.next = head;
        tail = current;
    }

    // Display the list
    public void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node5 temp = head;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);

        System.out.println();
    }

    // Main method
    public static void main(String[] args) {
        DeleteFromEnd csll = new DeleteFromEnd();

        csll.insertAtEnd(10);
        csll.insertAtEnd(20);
        csll.insertAtEnd(30);
        csll.insertAtEnd(40);

        System.out.println("Original List:");
        csll.display();  // Output: 10 20 30 40

        csll.deleteFromEnd();
        System.out.println("After deleteFromEnd:");
        csll.display();  // Output: 10 20 30

        csll.deleteFromEnd();
        System.out.println("After another deleteFromEnd:");
        csll.display();  // Output: 10 20
    }
}

/*
Original List:
10 20 30 40
After deleteFromEnd:
10 20 30
After another deleteFromEnd:
10 20

 */