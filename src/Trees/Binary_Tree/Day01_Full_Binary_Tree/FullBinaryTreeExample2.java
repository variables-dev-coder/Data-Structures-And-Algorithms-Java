package Trees.Binary_Tree.Day01_Full_Binary_Tree;


class Node3 {
    int data;
    Node3 left, right;

    public Node3(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class FullBinaryTreeExample2 {
    // Function to check if a binary tree is full
    static boolean isFullBinaryTree(Node3 root) {
        // Empty tree is considered full
        if (root == null)
            return true;

        // If leaf node → valid
        if (root.left == null && root.right == null)
            return true;

        // If both left & right children are present → check recursively
        if (root.left != null && root.right != null)
            return (isFullBinaryTree(root.left) && isFullBinaryTree(root.right));

        // If only one child → not full
        return false;
    }

    public static void main(String[] args) {
        // Example of Full Binary Tree
        Node3 root = new Node3(1);
        root.left = new Node3(2);
        root.right = new Node3(3);
        root.left.left = new Node3(4);
        root.left.right = new Node3(5);
        root.right.left = new Node3(6);
        root.right.right = new Node3(7);

        if (isFullBinaryTree(root))
            System.out.println("The given tree is a Full Binary Tree");
        else
            System.out.println("The given tree is NOT a Full Binary Tree");
    }

}

//The given tree is a Full Binary Tree

/*
         1
       /   \
      2     3
     / \   / \
    4   5 6   7

Node(1) → has 2 children → check left & right
Node(2) → has 2 children → check left & right
Node(3) → has 2 children → check left & right
Nodes(4,5,6,7) → all leaves (0 children)
So, this is a Full Binary Tree.

 */