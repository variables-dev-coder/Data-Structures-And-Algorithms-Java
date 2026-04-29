package Trees.treeRevision_BST;

import java.util.*;

public class BSTStep4 {

    static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
        }
    }

    // Validate BST using range
    public static boolean isValidBST(Node root, long min, long max) {
        if (root == null) return true;

        if (root.val <= min || root.val >= max) return false;

        return isValidBST(root.left, min, root.val) &&
                isValidBST(root.right, root.val, max);
    }

    public static void main(String[] args) {

        /*
                5
               / \
              3   7
                 /
                4   (invalid)
        */

        Node root = new Node(5);

        root.left = new Node(3);
        root.right = new Node(7);
        root.right.left = new Node(4);

        boolean result = isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);

        System.out.println("Is Valid BST: " + result);
    }
}
