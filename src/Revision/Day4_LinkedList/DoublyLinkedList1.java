package Revision.Day4_LinkedList;

public class DoublyLinkedList1 {
    class Node {
        int data;
        Node prev, next;
        Node(int data) {
            this.data = data;
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
        while (temp.next != null) temp = temp.next;
        temp.next = newNode;
        newNode.prev = temp;
    }

    // Delete by value
    public void delete(int key) {
        Node temp = head;
        while (temp != null && temp.data != key) {
            temp = temp.next;
        }
        if (temp == null) return;

        if (temp.prev != null) temp.prev.next = temp.next;
        else head = temp.next;  // deleting head

        if (temp.next != null) temp.next.prev = temp.prev;
    }

    // Traverse forward
    public void traverseForward() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Traverse backward
    public void traverseBackward() {
        if (head == null) return;
        Node temp = head;
        while (temp.next != null) temp = temp.next; // go to last node
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.prev;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        DoublyLinkedList1 list = new DoublyLinkedList1();
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.traverseForward();   // 10 <-> 20 <-> 30 <-> null
        list.traverseBackward();  // 30 <-> 20 <-> 10 <-> null
        list.delete(20);
        list.traverseForward();   // 10 <-> 30 <-> null
    }
}

/*
Dry Run

Insert(10,20,30) → 10 ⇆ 20 ⇆ 30

TraverseForward → 10 20 30

TraverseBackward → 30 20 10

Delete(20) → 10 ⇆ 30

 */