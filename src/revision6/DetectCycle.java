package revision6;

class Node4 {

    int data;

    Node4 next;

    Node4(int data) {

        this.data = data;
    }
}

public class DetectCycle {

    public static void main(String[] args) {

        // Create linked list
        Node4 head = new Node4(1);

        head.next = new Node4(2);

        head.next.next = new Node4(3);

        head.next.next.next = new Node4(4);

        // Create cycle
        head.next.next.next.next =
                head.next;

        Node4 slow = head;

        Node4 fast = head;

        boolean hasCycle = false;

        while (fast != null
                && fast.next != null) {

            slow = slow.next;

            fast = fast.next.next;

            // Cycle detected
            if (slow == fast) {

                hasCycle = true;

                break;
            }
        }

        System.out.println(
                "Cycle Exists: "
                        + hasCycle);
    }
}
