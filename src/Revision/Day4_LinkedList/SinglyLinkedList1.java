package Revision.Day4_LinkedList;

//Implement Singly Linked List (Insert, Delete, Traverse)

public class SinglyLinkedList1 {
    // Node structure
    class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head = null;

    // Insert at end
    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // Delete by value
    public void delete(int key) {
        if (head == null) return;
        if (head.data == key) {
            head = head.next;
            return;
        }
        Node temp = head;
        while (temp.next != null && temp.next.data != key) {
            temp = temp.next;
        }
        if (temp.next != null) {
            temp.next = temp.next.next;
        }
    }

    // Traverse
    public void traverse() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        SinglyLinkedList1 list = new SinglyLinkedList1();
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.traverse();   // 10 -> 20 -> 30 -> null
        list.delete(20);
        list.traverse();   // 10 -> 30 -> null
    }

}

/*
Dry Run

Insert(10) → head = 10

Insert(20) → 10 → 20

Insert(30) → 10 → 20 → 30

Traverse → prints nodes sequentially

Delete(20) → 10 → 30

 */