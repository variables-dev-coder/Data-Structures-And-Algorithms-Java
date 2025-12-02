package Practices.Week_3;


// RemoveNthFromEnd

class NodeN {
    int val;
    NodeN next;

    NodeN(int v) {
        val=v;
    }
}

public class RemoveNthFromEnd {
    public static NodeN removeNthFromEnd(NodeN head, int n) {
        NodeN dummy = new NodeN(0);
        dummy.next = head;
        NodeN fast = dummy, slow = dummy;
        for (int i = 0; i < n + 1; i++) fast = fast.next;
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

    public static void print(NodeN h){
        while(h!=null){ System.out.print(h.val+" "); h=h.next; } System.out.println();
    }

    public static void main(String[] args){
        NodeN head = new NodeN(1);
        head.next = new NodeN(2);
        head.next.next = new NodeN(3);
        head.next.next.next = new NodeN(4);
        head.next.next.next.next = new NodeN(5);
        System.out.print("Before: "); print(head);
        head = removeNthFromEnd(head, 2); // remove 4
        System.out.print("After:  "); print(head);
    }
}

//Before: 1 2 3 4 5
//After:  1 2 3 5 