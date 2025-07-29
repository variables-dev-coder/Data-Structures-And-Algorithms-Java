package LinkedLists.DSA_Singly_Linked_Lists;

public class SLL_InsertNode {
    static class Node4 {
        int data;
        Node4 next;

        public Node4(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void traverseAndPrint(Node4 head) {
        Node4 currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.data + " -> ");
            currentNode = currentNode.next;
        }
        System.out.println("null");
    }

    public static Node4 insertNodeAtPosition(Node4 head, Node4 newNode, int position) {
        if (position == 1) {
            newNode.next = head;
            return newNode;
        }

        Node4 currentNode = head;
        for (int i = 1; i < position - 1 && currentNode != null; i++) {
            currentNode = currentNode.next;
        }

        if (currentNode != null) {
            newNode.next = currentNode.next;
            currentNode.next = newNode;
        }
        return head;
    }

    public static void main(String[] args) {
        Node4 node1 = new Node4(7);
        Node4 node2 = new Node4(3);
        Node4 node3 = new Node4(2);
        Node4 node4 = new Node4(9);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        System.out.println("Original list:");
        traverseAndPrint(node1);

        // Insert a new node with value 97 at position 2
        Node4 newNode = new Node4(97);
        node1 = insertNodeAtPosition(node1, newNode, 2);

        System.out.println("\nAfter insertion:");
        traverseAndPrint(node1);
    }
}
