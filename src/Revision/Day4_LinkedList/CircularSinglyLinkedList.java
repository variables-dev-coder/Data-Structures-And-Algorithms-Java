package Revision.Day4_LinkedList;

class CNode {
    int data;
    CNode next;

    CNode(int data) {
        this.data = data;
        this.next = null;
    }
}

public class CircularSinglyLinkedList {
    CNode head, tail;

    // Insert at end
    public void insertAtEnd(int data) {
        CNode newNode = new CNode(data);
        if (head == null) {
            head = tail = newNode;
            newNode.next = head; // circular link
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head; // circular link
        }
    }

    // Print list (stop when back to head)
    public void display() {
        if (head == null) return;
        CNode temp = head;
        do {
            System.out.print(temp.data + " → ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("(back to head)");
    }

    public static void main(String[] args) {
        CircularSinglyLinkedList list = new CircularSinglyLinkedList();
        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);
        list.display(); // 10 → 20 → 30 → (back to head)
    }
}

