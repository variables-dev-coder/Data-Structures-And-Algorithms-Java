package LinkedLists.DSA_Singly_Linked_Lists;

public class SLL_DeleteNode {

    static class Node3 {
        int data;
        Node3 next;

        Node3(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void traverseAndPrint(Node3 head) {
        Node3 currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.data + " -> ");
            currentNode = currentNode.next;
        }
        System.out.println("null");
    }

    public static Node3 deleteSpecificNode(Node3 head, Node3 nodeToDelete) {
        if (head == nodeToDelete) {
            return head.next;
        }

        Node3 currentNode = head;
        while (currentNode.next != null && currentNode.next != nodeToDelete) {
            currentNode = currentNode.next;
        }

        if (currentNode.next == null) {
            return head;
        }

        currentNode.next = currentNode.next.next;

        return head;
    }

    public static void main(String[] args) {

        Node3 node1 = new Node3(7);
        Node3 node2 = new Node3(11);
        Node3 node3 = new Node3(3);
        Node3 node4 = new Node3(2);
        Node3 node5 = new Node3(9);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        System.out.println("Before deletion:");
        traverseAndPrint(node1);

        node1 = deleteSpecificNode(node1, node4);

        System.out.println("\nAfter deletion:");
        traverseAndPrint(node1);
    }
}
