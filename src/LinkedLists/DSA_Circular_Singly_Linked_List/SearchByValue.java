package LinkedLists.DSA_Circular_Singly_Linked_List;


// Search by value

class Node8 {
    int data;
    Node8 next;

    Node8(int data) {
        this.data = data;
        this.next = null;
    }
}

public class SearchByValue {

    Node8 head = null;
    Node8 tail = null;

    // Insert at end
    public void insertAtEnd(int data) {
        Node8 newNode = new Node8(data);

        if (head == null) {
            head = tail = newNode;
            tail.next = head;
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
    }

    // Search for a value and return its position (1-based)
    public void searchByValue(int target) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node8 current = head;
        int pos = 1;

        do {
            if (current.data == target) {
                System.out.println("Value " + target + " found at position: " + pos);
                return;
            }
            current = current.next;
            pos++;
        } while (current != head);

        System.out.println("Value " + target + " not found in the list.");
    }

    // Display the list
    public void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node8 temp = head;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }

    // Main method to test
    public static void main(String[] args) {
        SearchByValue csll = new SearchByValue();

        csll.insertAtEnd(10);
        csll.insertAtEnd(20);
        csll.insertAtEnd(30);
        csll.insertAtEnd(40);

        System.out.println("List:");
        csll.display();  // Output: 10 20 30 40

        csll.searchByValue(30);  // Output: Value 30 found at position: 3
        csll.searchByValue(50);  // Output: Value 50 not found in the list.
    }
}

/*
List:
10 20 30 40
Value 30 found at position: 3
Value 50 not found in the list.

 */