package Trees.treeRevision_BST;

import java.util.*;

public class BSTStep2 {

    static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
        }
    }

    // Insert (reuse from step 1)
    public static Node insert(Node root, int val) {
        if (root == null) return new Node(val);

        if (val < root.val) root.left = insert(root.left, val);
        else root.right = insert(root.right, val);

        return root;
    }

    // 🔹 Search in BST
    public static boolean search(Node root, int target) {
        if (root == null) return false;

        if (root.val == target) return true;

        if (target < root.val) {
            return search(root.left, target);
        } else {
            return search(root.right, target);
        }
    }

    public static void main(String[] args) {

        Node root = null;

        int[] values = {5, 3, 7, 2, 4, 8};

        for (int val : values) {
            root = insert(root, val);
        }

        System.out.println("Search 4: " + search(root, 4)); // true
        System.out.println("Search 10: " + search(root, 10)); // false
    }
}
