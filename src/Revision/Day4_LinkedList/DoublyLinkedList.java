package Revision.Day4_LinkedList;

class DNode {
    int data;
    DNode next, prev;

    DNode(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

public class DoublyLinkedList {
    DNode head;

    // Insert at end
    public void insertAtEnd(int data) {
        DNode newNode = new DNode(data);
        if (head == null) {
            head = newNode;
            return;
        }
        DNode temp = head;
        while (temp.next != null) temp = temp.next;
        temp.next = newNode;
        newNode.prev = temp;
    }

    // Print forward
    public void displayForward() {
        DNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ⇄ ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);
        list.displayForward(); // 10 ⇄ 20 ⇄ 30 ⇄ null
    }
}

