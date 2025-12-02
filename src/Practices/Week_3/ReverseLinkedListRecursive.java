package Practices.Week_3;


//ReverseLinkedList Recursive

class NodeR {
    int val;
    NodeR next;

    NodeR(int v) {
        val = v;
    }
}

public class ReverseLinkedListRecursive {
    public static NodeR reverse(NodeR head) {
        if (head == null || head.next == null) return head;
        NodeR newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public static void printList(NodeR h) {
        while (h != null) {
            System.out.print(h.val + " ");
            h = h.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        NodeR head = new NodeR(1);
        head.next = new NodeR(2);
        head.next.next = new NodeR(3);
        System.out.print("Original: "); printList(head);
        NodeR r = reverse(head);
        System.out.print("Reversed: "); printList(r);
    }

}

// Original: 1 2 3
// Reversed: 3 2 1