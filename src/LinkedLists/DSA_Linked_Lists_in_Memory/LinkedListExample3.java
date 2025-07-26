package LinkedLists.DSA_Linked_Lists_in_Memory;

public class LinkedListExample3 {

    static class Node3 {
        int data;
        Node3 next;

        Node3(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        // Creating Node

        Node3 firstNode = new Node3(1);
        Node3 secondNode = new Node3(9);
        Node3 thirdNode = new Node3(12);
        Node3 fourthNode = new Node3(3);
        Node3 fifthNode = new Node3(2);

        // Linking each node

        firstNode.next = secondNode;
        secondNode.next = thirdNode;
        thirdNode.next = fourthNode;
        fourthNode.next = fifthNode;

        //Print Nodes
        Node3 temp = firstNode;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}
