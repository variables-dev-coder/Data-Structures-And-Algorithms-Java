package Practices.Week_2;


/*
Given a singly LinkedList, delete the first occurrence of a given value.

Example:
Input: 1 → 3 → 5 → 7 → 9, delete 5
Output: 1 → 3 → 7 → 9
 */


public class LinkedList {
    Node head;

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Insert at end
    public void insert(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // Delete by value
    public void deleteByValue(int value) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        // Case 1: head is the value
        if (head.data == value) {
            head = head.next;
            System.out.println("Deleted: " + value);
            return;
        }

        Node curr = head;
        Node prev = null;

        while (curr != null && curr.data != value) {
            prev = curr;
            curr = curr.next;
        }

        // Not found
        if (curr == null) {
            System.out.println("Value not found: " + value);
            return;
        }

        // Delete node
        prev.next = curr.next;
        System.out.println("Deleted: " + value);
    }

    // Print list
    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " → ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Main
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.insert(1);
        list.insert(3);
        list.insert(5);
        list.insert(7);
        list.insert(9);

        System.out.println("Before delete:");
        list.print();

        list.deleteByValue(5);

        System.out.println("After delete:");
        list.print();
    }
}

/*
Before delete:
1 → 3 → 5 → 7 → 9 → null
Deleted: 5
After delete:
1 → 3 → 7 → 9 → null

Explanation (Very Simple)
Step 1 – Traverse list

Move through nodes until value found.
Step 2 – Edge case

If value is in head, move head → head.next.
Step 3 – If not found

If we reach curr == null, print "not found".
Step 4 – Delete the node

Change pointer:

prev.next = curr.next

This removes that node.

 */