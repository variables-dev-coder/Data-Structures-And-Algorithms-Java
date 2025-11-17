package Practices.Week_2;


class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class DetectCycle {

    // Function to detect cycle
    public static boolean hasCycle(Node head) {
        if (head == null || head.next == null) return false;

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;          // 1 step
            fast = fast.next.next;     // 2 steps

            if (slow == fast) {        // collision = cycle
                return true;
            }
        }
        return false; // fast reached null → no cycle
    }

    public static void main(String[] args) {

        // Creating nodes
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);

        // Creating a normal LinkedList: 1 -> 2 -> 3 -> 4 -> null
        a.next = b;
        b.next = c;
        c.next = d;

        System.out.println("Cycle Present? " + hasCycle(a)); // false

        // Creating a cycle: 4 -> 2
        d.next = b;

        System.out.println("Cycle Present? " + hasCycle(a)); // true
    }

}

/*
Cycle Present? false
Cycle Present? true
 */