package Trees.treeRevision_Binary;

import java.util.*;

public class BinaryTreeStep8 {

    static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
        }
    }

    // Check path sum
    public static boolean hasPathSum(Node root, int target) {
        if (root == null) return false;

        // leaf node
        if (root.left == null && root.right == null) {
            return target == root.val;
        }

        int remaining = target - root.val;

        return hasPathSum(root.left, remaining) ||
                hasPathSum(root.right, remaining);
    }

    public static void main(String[] args) {

        /*
                5
               / \
              4   8
             /   / \
            11  13  4
           /  \
          7    2
        */

        Node root = new Node(5);

        root.left = new Node(4);
        root.right = new Node(8);

        root.left.left = new Node(11);
        root.left.left.left = new Node(7);
        root.left.left.right = new Node(2);

        root.right.left = new Node(13);
        root.right.right = new Node(4);

        int target = 22;

        System.out.println("Has Path Sum: " + hasPathSum(root, target));
    }
}
