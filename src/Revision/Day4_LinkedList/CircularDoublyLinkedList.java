package Revision.Day4_LinkedList;

class CDNode {
    int data;
    CDNode next, prev;

    CDNode(int data) {
        this.data = data;
        this.next = this.prev = null;
    }
}

public class CircularDoublyLinkedList {
    CDNode head, tail;

    // Insert at end
    public void insertAtEnd(int data) {
        CDNode newNode = new CDNode(data);
        if (head == null) {
            head = tail = newNode;
            head.next = head.prev = head; // circular link
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            newNode.next = head;
            head.prev = newNode;
            tail = newNode;
        }
    }

    // Print list (circular, stop when back at head)
    public void display() {
        if (head == null) return;
        CDNode temp = head;
        do {
            System.out.print(temp.data + " ⇄ ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("(back to head)");
    }

    public static void main(String[] args) {
        CircularDoublyLinkedList list = new CircularDoublyLinkedList();
        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);
        list.display(); // 10 ⇄ 20 ⇄ 30 ⇄ (back to head)
    }
}

