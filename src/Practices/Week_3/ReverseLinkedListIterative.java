package Practices.Week_3;

// File: ReverseLinkedListIterative.java
class Node1 {
    int val;
    Node1 next;

    Node1(int v) {
        val = v;
    }
}

public class ReverseLinkedListIterative {
    public static Node1 reverse(Node1 head) {
        Node1 prev = null, curr = head;
        while (curr != null) {
            Node1 next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void printList(Node1 h) {
        while (h != null) {
            System.out.print(h.val + " ");
            h = h.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node1 head = new Node1(1);
        head.next = new Node1(2);
        head.next.next = new Node1(3);
        System.out.print("Original: "); printList(head);
        Node1 r = reverse(head);
        System.out.print("Reversed: "); printList(r);
    }
}

//Original: 1 2 3
//Reversed: 3 2 1