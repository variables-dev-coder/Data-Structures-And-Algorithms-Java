package LinkedLists.DSA_Linked_Lists_in_Memory;

public class LinkedListExample4 {
    static class Node4 {
        int data;
        Node4 next;

        Node4(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        //Creating Nodes
        Node4 firstNode = new Node4(10);
        Node4 secondNode = new Node4(33);
        Node4 thirdNode = new Node4(9);
        Node4 fourthNode = new Node4(5);
        Node4 fifthNode = new Node4(40);

        //Linking Nodes
        firstNode.next = secondNode;
        secondNode.next = thirdNode;
        thirdNode.next = fourthNode;
        fourthNode.next = fifthNode;

        //Printing nodes
        Node4 currentNode = firstNode;
        while (currentNode != null) {
            System.out.print(currentNode.data + " -> ");
            currentNode = currentNode.next;
        }
        System.out.println("null");
    }
}
