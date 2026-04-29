package Trees.treeRevision_BST;

import java.util.*;

public class BSTStep3 {

    static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
        }
    }

    // Insert
    public static Node insert(Node root, int val) {
        if (root == null) return new Node(val);

        if (val < root.val) root.left = insert(root.left, val);
        else root.right = insert(root.right, val);

        return root;
    }

    // Find minimum (inorder successor)
    public static Node findMin(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    // 🔥 Delete node
    public static Node delete(Node root, int key) {
        if (root == null) return null;

        if (key < root.val) {
            root.left = delete(root.left, key);
        }
        else if (key > root.val) {
            root.right = delete(root.right, key);
        }
        else {
            // CASE 1 & 2: one or no child
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;

            // CASE 3: two children
            Node successor = findMin(root.right);
            root.val = successor.val;
            root.right = delete(root.right, successor.val);
        }

        return root;
    }

    // Inorder (to verify)
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

        System.out.print("Before Deletion: ");
        inorder(root);

        root = delete(root, 3);

        System.out.print("\nAfter Deleting 3: ");
        inorder(root);
    }
}
