package Trees.revisionTreeConstruction;

import java.util.*;

public class BSTFromPreorder {

    static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
        }
    }

    static int index = 0;

    public static Node build(int[] preorder, int min, int max) {
        if (index >= preorder.length) return null;

        int val = preorder[index];

        if (val < min || val > max) return null;

        Node root = new Node(val);
        index++;

        root.left = build(preorder, min, val);
        root.right = build(preorder, val, max);

        return root;
    }

    public static Node bstFromPreorder(int[] preorder) {
        index = 0;
        return build(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {

        int[] preorder = {8, 5, 1, 7, 10, 12};

        Node root = bstFromPreorder(preorder);

        System.out.print("BST (Inorder): ");
        inorder(root);
    }
}
