package LinkedLists.DSA_Linked_Lists_in_Memory;

public class LinkedListExample2 {

    static class Node2 {
        int data;
        Node2 next;

        Node2(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {

        // creating Node

        Node2 firstNode = new Node2(10);
        Node2 secondNode = new Node2(20);
        Node2 thirdNode = new Node2(30);
        Node2 fourthNode = new Node2(40);
        Node2 fifthNode = new Node2(50);

        // Linking to each node

        firstNode.next = secondNode;
        secondNode.next = thirdNode;
        thirdNode.next = fourthNode;
        fourthNode.next = fifthNode;

        // Printing linked node
        Node2 currentNode = firstNode;
        while (currentNode != null) {
            System.out.print(currentNode.data + " -> ");
            currentNode = currentNode.next;
        }
        System.out.println("null");
    }
}
