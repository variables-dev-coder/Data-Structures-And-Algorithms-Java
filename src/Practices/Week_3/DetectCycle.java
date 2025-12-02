package Practices.Week_3;


// DetectCycle

class NodeC {
    int val;
    NodeC next;

    NodeC(int v) {
        val = v;
    }
}

public class DetectCycle {
    public static boolean hasCycle(NodeC head) {
        NodeC slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        NodeC a = new NodeC(1);
        a.next = new NodeC(2);
        a.next.next = new NodeC(3);
        a.next.next.next = a.next; // cycle
        System.out.println("Has cycle: " + hasCycle(a)); // true

        NodeC b = new NodeC(1);
        b.next = new NodeC(2);
        b.next.next = new NodeC(3);
        System.out.println("Has cycle: " + hasCycle(b)); // false
    }
}

//Has cycle: true
//Has cycle: false