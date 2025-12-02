package Practices.Week_3;


// File: MiddleOfLinkedList.java
class NodeM {
    int val;
    NodeM next;

    NodeM(int v) {
        val=v;
    }
}

public class MiddleOfLinkedList {
    public static NodeM middle(NodeM head) {
        NodeM slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        NodeM h = new NodeM(1);
        h.next = new NodeM(2);
        h.next.next = new NodeM(3);
        h.next.next.next = new NodeM(4);
        h.next.next.next.next = new NodeM(5);
        NodeM mid = middle(h);
        System.out.println("Middle: " + mid.val); // 3
    }
}
