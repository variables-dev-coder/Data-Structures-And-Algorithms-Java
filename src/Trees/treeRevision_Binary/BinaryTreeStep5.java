package Trees.treeRevision_Binary;

import java.util.*;

public class BinaryTreeStep5 {

    static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
        }
    }

    static int diameter = 0;

    // Function to calculate height and update diameter
    public static int height(Node root) {
        if (root == null) return 0;

        int left = height(root.left);
        int right = height(root.right);

        // update diameter
        diameter = Math.max(diameter, left + right + 1);

        return Math.max(left, right) + 1;
    }

    public static int findDiameter(Node root) {
        diameter = 0;
        height(root);
        return diameter;
    }

    public static void main(String[] args) {

        /*
                1
               / \
              2   3
             / \
            4   5
        */

        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        int d = findDiameter(root);

        System.out.println("Diameter of Tree: " + d);
    }
}
