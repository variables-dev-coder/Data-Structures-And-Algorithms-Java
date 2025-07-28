package LinkedLists.DSA_Linked_Lists_in_Memory;


// Linked list data insert at end point

class Node2 {
    int data;
    Node2 next;

    Node2 (int data) {
        this.data = data;
        this.next = null;
    }
}

public class LLInsertAtEnd {
    Node2 head;

    public void insertAtEnd(int value) {
        Node2 newNode = new Node2(value);

        // case 1: if list is empty, make newNode the head
        if (head == null) {
            head = newNode;
            return;
        }

        // case 2: Traverse to the end
        Node2 temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        // link last node to newNode
        temp.next = newNode;
    }

    // Display the list

    public void display() {
        Node2 temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        LLInsertAtEnd list = new LLInsertAtEnd();

        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);
        list.insertAtEnd(40);
        list.insertAtEnd(50);

        list.display();    // 10 -> 20 -> 30 -> 40 -> 50 -> null
    }
}
