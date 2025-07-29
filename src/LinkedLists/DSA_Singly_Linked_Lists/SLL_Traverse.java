package LinkedLists.DSA_Singly_Linked_Lists;

public class SLL_Traverse {

    static class Node1 {
        int data;
        Node1 next;

        Node1(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void traverseAndPrint(Node1 head) {
        Node1 currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.data + " -> ");
            currentNode = currentNode.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Node1 node1 = new Node1(7);
        Node1 node2 = new Node1(11);
        Node1 node3 = new Node1(3);
        Node1 node4 = new Node1(2);
        Node1 node5 = new Node1(9);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        traverseAndPrint(node1);
    }
}

