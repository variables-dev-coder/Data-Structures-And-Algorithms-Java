package Revision.Day4_LinkedList;



class Node2 {
    int data;
    Node2 next;
    Node2(int d) { data = d; next = null; }
}

public class ReverseLinkedList {
    static Node2 head;

    // Iterative
    public static Node2 reverse(Node2 head) {
        Node2 prev = null, curr = head, next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        head = new Node2(1);
        head.next = new Node2(2);
        head.next.next = new Node2(3);

        head = reverse(head);

        Node2 temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

}

//3 2 1