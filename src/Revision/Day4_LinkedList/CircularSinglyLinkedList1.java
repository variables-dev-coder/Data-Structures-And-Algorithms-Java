package Revision.Day4_LinkedList;

public class CircularSinglyLinkedList1 {
    class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    Node head = null;

    // Insert at end
    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            head.next = head; // circular
            return;
        }
        Node temp = head;
        while (temp.next != head) temp = temp.next;
        temp.next = newNode;
        newNode.next = head;
    }

    // Traverse
    public void traverse() {
        if (head == null) return;
        Node temp = head;
        do {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("(back to head)");
    }

    public static void main(String[] args) {
        CircularSinglyLinkedList1 list = new CircularSinglyLinkedList1();
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.traverse();  // 10 -> 20 -> 30 -> (back to head)
    }
}

/*
Dry Run

Insert(10) → 10 → points back to 10

Insert(20) → 10 → 20 → back to 10

Insert(30) → 10 → 20 → 30 → back to 10

 */