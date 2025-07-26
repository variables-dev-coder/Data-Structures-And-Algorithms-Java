package LinkedLists.DSA_Linked_Lists_in_Memory;


// Insert At the Beginning


class Node6 {
    int data;
    Node6 next;

    Node6 (int data) {
        this.data = data;
        this.next = null;
    }
}

public class InsertAtBeginning {
    public static Node6 insertAtBeginning(Node6 head, int value) {
        Node6 newNode = new Node6(value);
        newNode.next = head;
        return newNode;
    }

    public static void main(String[] args) {
        Node6 head = new Node6(20);
        head = insertAtBeginning(head, 10);
        head = insertAtBeginning(head, 9);
        head = insertAtBeginning(head, 8);
        head = insertAtBeginning(head, 7);

        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println("null");
    }
}
