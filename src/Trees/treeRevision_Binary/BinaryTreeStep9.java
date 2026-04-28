package Trees.treeRevision_Binary;

import java.util.*;

public class BinaryTreeStep9 {

    static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
        }
    }

    static int maxSum = Integer.MIN_VALUE;

    public static int maxGain(Node root) {
        if (root == null) return 0;

        // ignore negative paths
        int left = Math.max(0, maxGain(root.left));
        int right = Math.max(0, maxGain(root.right));

        // path through current node
        int currentPath = left + right + root.val;

        // update global max
        maxSum = Math.max(maxSum, currentPath);

        // return one side path
        return root.val + Math.max(left, right);
    }

    public static int maxPathSum(Node root) {
        maxSum = Integer.MIN_VALUE;
        maxGain(root);
        return maxSum;
    }

    public static void main(String[] args) {

        /*
                -10
                /  \
               9   20
                   / \
                  15  7
        */

        Node root = new Node(-10);

        root.left = new Node(9);
        root.right = new Node(20);

        root.right.left = new Node(15);
        root.right.right = new Node(7);

        int result = maxPathSum(root);

        System.out.println("Maximum Path Sum: " + result);
    }
}
