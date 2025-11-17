package Practices.Week_2;

public class LinkedListReverse {
    // Node structure
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Function to reverse LinkedList
    static Node reverse(Node head) {
        Node prev = null;
        Node current = head;
        Node next = null;

        while (current != null) {
            next = current.next;   // store next node
            current.next = prev;   // reverse the link
            prev = current;        // move prev
            current = next;        // move current
        }
        return prev;  // new head
    }

    // Print LinkedList
    static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Creating LinkedList 1 -> 2 -> 3 -> 4
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);

        System.out.println("Original List:");
        printList(head);

        head = reverse(head);

        System.out.println("Reversed List:");
        printList(head);
    }
}

/*

Original List:
1 -> 2 -> 3 -> 4 -> null
Reversed List:
4 -> 3 -> 2 -> 1 -> null


Explanation in Simple Terms
Step-by-step Logic

We use three pointers:

| Pointer   | Purpose                       |
| --------- | ----------------------------- |
| `prev`    | Tracks previous node          |
| `current` | Current node we are reversing |
| `next`    | Temporarily stores next node  |


Process

Example: 1 -> 2 -> 3 -> 4 -> null

Start:
prev = null, current = 1

Step 1: Reverse 1
1 -> null

Step 2: Reverse 2
2 -> 1 -> null

Step 3: Reverse 3
3 -> 2 -> 1 -> null

Step 4: Reverse 4
4 -> 3 -> 2 -> 1 -> null

Finally, prev becomes the new head.



 */