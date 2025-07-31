package LinkedLists.DSA_Circular_Singly_Linked_List;


// CSLL delete by value


class Node9 {
    int data;
    Node9 next;

    Node9(int data) {
        this.data = data;
        this.next = null;
    }
}

public class DeleteByValue {

    Node9 head = null;
    Node9 tail = null;

    // Insert at end
    public void insertAtEnd(int data) {
        Node9 newNode = new Node9(data);

        if (head == null) {
            head = tail = newNode;
            tail.next = head;
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
    }

    // Delete first occurrence of a value
    public void deleteByValue(int value) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        // If head is the node to be deleted
        if (head.data == value) {
            // If only one node
            if (head == tail) {
                head = tail = null;
            } else {
                head = head.next;
                tail.next = head;
            }
            System.out.println("Deleted value: " + value);
            return;
        }

        Node9 current = head;
        Node9 prev = null;

        do {
            prev = current;
            current = current.next;

            if (current.data == value) {
                prev.next = current.next;

                // If tail is being deleted
                if (current == tail) {
                    tail = prev;
                }

                System.out.println("Deleted value: " + value);
                return;
            }
        } while (current != head);

        System.out.println("Value " + value + " not found in the list.");
    }

    // Display list
    public void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node9 temp = head;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }

    // Main method to test
    public static void main(String[] args) {
        DeleteByValue csll = new DeleteByValue();

        csll.insertAtEnd(10);
        csll.insertAtEnd(20);
        csll.insertAtEnd(30);
        csll.insertAtEnd(40);

        System.out.println("List before deletion:");
        csll.display(); // 10 20 30 40

        csll.deleteByValue(30); // delete middle
        csll.display(); // 10 20 40

        csll.deleteByValue(10); // delete head
        csll.display(); // 20 40

        csll.deleteByValue(50); // not found
    }
}

/*
List before deletion:
10 20 30 40
Deleted value: 30
20 40
Deleted value: 10
20 40
Value 50 not found in the list.

 */