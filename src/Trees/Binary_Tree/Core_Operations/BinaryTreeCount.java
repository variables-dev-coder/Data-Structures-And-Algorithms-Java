package Trees.Binary_Tree.Core_Operations;

/*
Count Nodes and Leaf Nodes in Binary Tree
Definitions:
Total nodes → count of all nodes.
Leaf nodes → nodes with no children.

 */

public class BinaryTreeCount {
    static class Node5 {
        int data;
        Node5 left, right;

        Node5(int data) {
            this.data = data;
        }
    }

    Node5 root;

    // Count total nodes
    public int countNodes(Node5 node) {
        if (node == null) return 0;
        return 1 + countNodes(node.left) + countNodes(node.right);
    }

    // Count leaf nodes
    public int countLeaves(Node5 node) {
        if (node == null) return 0;
        if (node.left == null && node.right == null) return 1;
        return countLeaves(node.left) + countLeaves(node.right);
    }

    public static void main(String[] args) {
        BinaryTreeCount tree = new BinaryTreeCount();

        // Build tree manually
        tree.root = new Node5(10);
        tree.root.left = new Node5(20);
        tree.root.right = new Node5(30);
        tree.root.left.left = new Node5(40);
        tree.root.left.right = new Node5(50);

        System.out.println("Total nodes: " + tree.countNodes(tree.root)); // 5
        System.out.println("Leaf nodes: " + tree.countLeaves(tree.root)); // 3
    }
}

//Total nodes: 5
//Leaf nodes: 3