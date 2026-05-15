package revision6;

class Node3 {

    int data;

    Node3 next;

    Node3(int data) {

        this.data = data;
    }
}

public class MiddleLinkedList {

    public static void main(String[] args) {

        // Create linked list
        Node3 head = new Node3(1);

        head.next = new Node3(2);

        head.next.next = new Node3(3);

        head.next.next.next = new Node3(4);

        head.next.next.next.next =
                new Node3(5);

        // Slow and Fast pointers
        Node3 slow = head;

        Node3 fast = head;

        while (fast != null
                && fast.next != null) {

            slow = slow.next;

            fast = fast.next.next;
        }

        System.out.println(
                "Middle Node3: "
                        + slow.data);
    }
}
