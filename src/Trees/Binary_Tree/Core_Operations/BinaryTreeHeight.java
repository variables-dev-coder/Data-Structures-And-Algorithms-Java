package Trees.Binary_Tree.Core_Operations;

/*
Height (or Depth) Calculation in Binary Tree
Definition:
Height of a tree = maximum depth = longest path from root to a leaf.
A leaf node’s height = 1.
For null, height = 0.

 */


public class BinaryTreeHeight {
    static class Node4 {
        int data;
        Node4 left, right;

        Node4(int data) {
            this.data = data;
        }
    }

    Node4 root;

    // Recursive method to calculate height
    public int height(Node4 node) {
        if (node == null) return 0;

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        BinaryTreeHeight tree = new BinaryTreeHeight();

        // Build tree manually
        tree.root = new Node4(10);
        tree.root.left = new Node4(20);
        tree.root.right = new Node4(30);
        tree.root.left.left = new Node4(40);
        tree.root.left.right = new Node4(50);
        tree.root.left.left.left = new Node4(60);

        System.out.println("Height of tree: " + tree.height(tree.root));
    }
}

// Height of tree: 4