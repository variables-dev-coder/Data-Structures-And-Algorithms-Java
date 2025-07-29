package LinkedLists.DSA_Singly_Linked_Lists;

public class SLL_FindLowest {
    public static void main(String[] args) {

        Node2 node1 = new Node2(7);
        Node2 node2 = new Node2(11);
        Node2 node3 = new Node2(3);
        Node2 node4 = new Node2(2);
        Node2 node5 = new Node2(9);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        System.out.println("The lowest value in the linked list is: " + findLowestValue(node1));
    }

    public static int findLowestValue(Node2 head) {
        int minValue = head.data;
        Node2 currentNode = head.next;
        while (currentNode != null) {
            if (currentNode.data < minValue) {
                minValue = currentNode.data;
            }
            currentNode = currentNode.next;
        }
        return minValue;
    }
}

class Node2 {
    int data;
    Node2 next;

    public Node2(int data) {
        this.data = data;
        this.next = null;
    }
}
