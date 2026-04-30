package Trees.treeRevision_BST;

import java.util.*;

public class BSTStep6 {

    static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
        }
    }

    public static Node lca(Node root, int p, int q) {
        if (root == null) return null;

        if (p < root.val && q < root.val) {
            return lca(root.left, p, q);
        }

        if (p > root.val && q > root.val) {
            return lca(root.right, p, q);
        }

        // split point
        return root;
    }

    // insert
    public static Node insert(Node root, int val) {
        if (root == null) return new Node(val);

        if (val < root.val) root.left = insert(root.left, val);
        else root.right = insert(root.right, val);

        return root;
    }

    public static void main(String[] args) {

        Node root = null;
        int[] arr = {6, 2, 8, 0, 4, 7, 9, 3, 5};

        for (int x : arr) {
            root = insert(root, x);
        }

        Node ans = lca(root, 2, 8);

        System.out.println("LCA of 2 & 8: " + ans.val);
    }
}
