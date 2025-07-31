package LinkedLists.DSA_Circular_Singly_Linked_List;

// CSLL Delete at position

class Node6 {
    int data;
    Node6 next;

    Node6(int data) {
        this.data = data;
        this.next = null;
    }
}

public class DeleteAtPosition {
    Node6 head = null;
    Node6 tail = null;

    // Insert at end
    public void insertAtEnd(int data) {
        Node6 newNode = new Node6(data);

        if (head == null) {
            head = tail = newNode;
            tail.next = head;
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
    }

    // Delete node at a given position
    public void deleteAtPosition(int pos) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (pos == 1) {
            // Delete from beginning
            if (head == tail) {
                head = tail = null;
            } else {
                head = head.next;
                tail.next = head;
            }
            return;
        }

        Node6 current = head;
        Node6 prev = null;

        int count = 1;
        while (count < pos && current.next != head) {
            prev = current;
            current = current.next;
            count++;
        }

        if (count != pos) {
            System.out.println("Invalid position");
            return;
        }

        prev.next = current.next;

        if (current == tail) {
            tail = prev;
        }
    }

    // Display the list
    public void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node6 temp = head;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }

    // Main method to test
    public static void main(String[] args) {
        DeleteAtPosition csll = new DeleteAtPosition();

        csll.insertAtEnd(10);
        csll.insertAtEnd(20);
        csll.insertAtEnd(30);
        csll.insertAtEnd(40);
        csll.insertAtEnd(50);

        System.out.println("Original List:");
        csll.display();  // Output: 10 20 30 40 50

        csll.deleteAtPosition(1);
        System.out.println("After deleteAtPosition(1):");
        csll.display();  // Output: 20 30 40 50

        csll.deleteAtPosition(3);
        System.out.println("After deleteAtPosition(3):");
        csll.display();  // Output: 20 30 50

        csll.deleteAtPosition(5); // Invalid position
    }
}

/*
Original List:
10 20 30 40 50
After deleteAtPosition(1):
20 30 40 50
After deleteAtPosition(3):
20 30 50
Invalid position

 */