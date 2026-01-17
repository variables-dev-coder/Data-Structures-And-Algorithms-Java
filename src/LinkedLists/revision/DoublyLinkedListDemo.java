package LinkedLists.revision;

class DNode {
    int data;
    DNode prev, next;

    DNode(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

public class DoublyLinkedListDemo {

    DNode head;

    // 1 Insert at Beginning
    void insertAtBeginning(int data) {
        DNode newNode = new DNode(data);

        if (head != null) {
            newNode.next = head;
            head.prev = newNode;
        }
        head = newNode;
    }

    // 2 Insert at End
    void insertAtEnd(int data) {
        DNode newNode = new DNode(data);

        if (head == null) {
            head = newNode;
            return;
        }

        DNode curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }

        curr.next = newNode;
        newNode.prev = curr;
    }

    // 3 Forward Traversal
    void printForward() {
        DNode curr = head;
        System.out.print("Forward: ");
        while (curr != null) {
            System.out.print(curr.data + " ⇄ ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    // 4 Backward Traversal
    void printBackward() {
        if (head == null) return;

        DNode curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }

        System.out.print("Backward: ");
        while (curr != null) {
            System.out.print(curr.data + " ⇄ ");
            curr = curr.prev;
        }
        System.out.println("null");
    }

    // 5 Delete a Node by Value
    void delete(int key) {
        if (head == null) return;

        DNode curr = head;

        // if head needs to be deleted
        if (curr.data == key) {
            head = curr.next;
            if (head != null) head.prev = null;
            return;
        }

        while (curr != null && curr.data != key) {
            curr = curr.next;
        }

        if (curr == null) return;

        if (curr.next != null) {
            curr.next.prev = curr.prev;
        }

        if (curr.prev != null) {
            curr.prev.next = curr.next;
        }
    }

    // 6 Reverse the Doubly Linked List
    void reverse() {
        DNode curr = head;
        DNode temp = null;

        while (curr != null) {
            temp = curr.prev;
            curr.prev = curr.next;
            curr.next = temp;
            curr = curr.prev;
        }

        if (temp != null) {
            head = temp.prev;
        }
    }

    // 🔹 MAIN METHOD
    public static void main(String[] args) {

        DoublyLinkedListDemo list = new DoublyLinkedListDemo();

        list.insertAtEnd(20);
        list.insertAtEnd(30);
        list.insertAtEnd(40);

        list.insertAtBeginning(10);

        list.printForward();
        list.printBackward();

        list.delete(30);
        System.out.println("After deleting 30:");
        list.printForward();

        list.reverse();
        System.out.println("After reversing:");
        list.printForward();
    }
}

/*
Forward: 10 ⇄ 20 ⇄ 30 ⇄ 40 ⇄ null
Backward: 40 ⇄ 30 ⇄ 20 ⇄ 10 ⇄ null
After deleting 30:
Forward: 10 ⇄ 20 ⇄ 40 ⇄ null
After reversing:
Forward: 40 ⇄ 20 ⇄ 10 ⇄ null

 */