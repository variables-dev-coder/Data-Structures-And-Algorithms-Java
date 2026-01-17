package LinkedLists.revision;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedListDemo {

    Node head;

    // 1 Insert at End
    void insertAtEnd(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = newNode;
    }

    // 2 Insert at Beginning
    void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // 3 Traverse / Print
    void printList() {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    // 4 Search an Element
    boolean search(int key) {
        Node curr = head;
        while (curr != null) {
            if (curr.data == key) return true;
            curr = curr.next;
        }
        return false;
    }

    // 5 Delete a Node by Value
    void delete(int key) {
        if (head == null) return;

        if (head.data == key) {
            head = head.next;
            return;
        }

        Node curr = head;
        while (curr.next != null && curr.next.data != key) {
            curr = curr.next;
        }

        if (curr.next != null) {
            curr.next = curr.next.next;
        }
    }

    // 6 Reverse the Linked List
    void reverse() {
        Node prev = null;
        Node curr = head;

        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    // 🔹 MAIN METHOD
    public static void main(String[] args) {

        LinkedListDemo list = new LinkedListDemo();

        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);

        list.insertAtBeginning(5);

        System.out.print("Linked List: ");
        list.printList();

        System.out.println("Search 20: " + list.search(20));
        System.out.println("Search 50: " + list.search(50));

        list.delete(20);
        System.out.print("After deleting 20: ");
        list.printList();

        list.reverse();
        System.out.print("After reversing: ");
        list.printList();
    }
}

/*
Linked List: 5 -> 10 -> 20 -> 30 -> null
Search 20: true
Search 50: false
After deleting 20: 5 -> 10 -> 30 -> null
After reversing: 30 -> 10 -> 5 -> null

 */