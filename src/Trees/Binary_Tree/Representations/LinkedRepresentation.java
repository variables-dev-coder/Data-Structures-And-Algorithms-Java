package Trees.Binary_Tree.Representations;

//Basic Linked Node Representation

class Node1 {
    int data;
    Node1 left, right;

    Node1(int data) {
        this.data = data;
        left = right = null;
    }
}

public class LinkedRepresentation {
    public static void main(String[] args) {
        // Build tree manually
        Node1 root = new Node1(1);
        root.left = new Node1(2);
        root.right = new Node1(3);
        root.left.left = new Node1(4);
        root.left.right = new Node1(5);

        System.out.println("Root: " + root.data);
        System.out.println("Left Child of Root: " + root.left.data);
        System.out.println("Right Child of Root: " + root.right.data);
    }

}

//Root: 1
//Left Child of Root: 2
//Right Child of Root: 3