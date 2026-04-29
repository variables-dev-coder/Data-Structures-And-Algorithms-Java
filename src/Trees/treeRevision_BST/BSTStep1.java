package Trees.treeRevision_BST;

import java.util.*;

public class BSTStep1 {

    static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
        }
    }

    // Insert into BST
    public static Node insert(Node root, int val) {
        if (root == null) {
            return new Node(val);
        }

        if (val < root.val) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }

        return root;
    }

    // Inorder traversal (sorted output)
    public static void inorder(Node root) {
        if (root == null) return;

        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {

        Node root = null;

        int[] values = {5, 3, 7, 2, 4, 8};

        for (int val : values) {
            root = insert(root, val);
        }

        System.out.print("Inorder (Sorted): ");
        inorder(root);
    }
}
