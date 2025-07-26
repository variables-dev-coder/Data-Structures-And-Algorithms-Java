package LinkedLists.DSA_Linked_Lists_in_Memory;


// Insert at End

class Node7 {
    int data;
    Node7 next;

    Node7 (int data) {
        this.data = data;
        this. next = null;
    }
}

public class InsertAtEnd {

    public static Node7 insertAtEnd(Node7 head, int value) {
        Node7 newNode = new Node7(value);
        if (head == null)
            return newNode;

        Node7 temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        return head;
    }

    public static void main(String[] args) {
        Node7 head = new Node7(20);
        head = insertAtEnd(head, 30);
        head = insertAtEnd(head, 30);

        while (head != null) {

            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }
}
