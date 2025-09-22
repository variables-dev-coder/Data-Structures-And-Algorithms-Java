package Trees.Binary_Tree.Representations;

//Linked Node Representation
//data (value)
//left pointer/reference (to left child)
//right pointer/reference (to right child)

class Node {
    int val;
    Node left, right;

    Node(int v) {
        val = v;
        left = right = null;
    }
}

public class LinkedNodeTree {
    public static void main(String[] args) {
        // Building tree:
        //      1
        //     / \
        //    2   3
        //   /
        //  4

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);

        System.out.println("Root value: " + root.val);       // 1
        System.out.println("Left child of 1: " + root.left.val); // 2
        System.out.println("Right child of 1: " + root.right.val); // 3
    }
}

/*
Root value: 1
Left child of 1: 2
Right child of 1: 3
 */