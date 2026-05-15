package revision6;

class Node2 {

    int data;

    Node2 next;

    Node2(int data) {

        this.data = data;
    }
}

public class ReverseLinkedList {

    public static void main(String[] args) {

        // Create linked list
        Node2 head = new Node2(1);

        head.next = new Node2(2);

        head.next.next = new Node2(3);

        head.next.next.next = new Node2(4);

        // Reverse linked list
        Node2 prev = null;

        Node2 current = head;

        while (current != null) {

            // Store next node
            Node2 next = current.next;

            // Reverse link
            current.next = prev;

            // Move pointers
            prev = current;

            current = next;
        }

        // New head
        head = prev;

        // Print reversed list
        Node2 temp = head;

        while (temp != null) {

            System.out.print(temp.data + " → ");

            temp = temp.next;
        }

        System.out.println("null");
    }
}
