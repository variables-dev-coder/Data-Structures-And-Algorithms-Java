package LinkedLists.DSA_Circular_Singly_Linked_List;

// Update at position

class Node7 {
    int data;
    Node7 next;

    Node7(int data) {
        this.data = data;
        this.next = null;
    }
}

public class UpdateAtPosition {

    Node7 head = null;
    Node7 tail = null;

    // Insert at end
    public void insertAtEnd(int data) {
        Node7 newNode = new Node7(data);

        if (head == null) {
            head = tail = newNode;
            tail.next = head;
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
    }

    // Update data at a given position
    public void updateAtPosition(int pos, int newData) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node7 current = head;
        int count = 1;

        do {
            if (count == pos) {
                current.data = newData;
                return;
            }
            current = current.next;
            count++;
        } while (current != head);

        System.out.println("Invalid position");
    }

    // Display the list
    public void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node7 temp = head;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }

    // Main method to test
    public static void main(String[] args) {
        UpdateAtPosition csll = new UpdateAtPosition();

        csll.insertAtEnd(10);
        csll.insertAtEnd(20);
        csll.insertAtEnd(30);
        csll.insertAtEnd(40);

        System.out.println("Original List:");
        csll.display();  // Output: 10 20 30 40

        csll.updateAtPosition(2, 99);
        System.out.println("After updateAtPosition(2, 99):");
        csll.display();  // Output: 10 99 30 40

        csll.updateAtPosition(4, 77);
        System.out.println("After updateAtPosition(4, 77):");
        csll.display();  // Output: 10 99 30 77

        csll.updateAtPosition(5, 123); // Invalid position
    }
}

/*
Original List:
10 20 30 40
After updateAtPosition(2, 99):
10 99 30 40
After updateAtPosition(4, 77):
10 99 30 77
Invalid position

 */