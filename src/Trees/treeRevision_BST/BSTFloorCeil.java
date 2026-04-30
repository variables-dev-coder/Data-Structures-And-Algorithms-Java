package Trees.treeRevision_BST;

import java.util.*;

public class BSTFloorCeil {

    static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
        }
    }

    public static int floor(Node root, int x) {
        int floor = -1;

        while (root != null) {
            if (root.val == x) {
                return root.val;
            }

            if (x < root.val) {
                root = root.left;
            } else {
                floor = root.val;
                root = root.right;
            }
        }

        return floor;
    }

    public static int ceil(Node root, int x) {
        int ceil = -1;

        while (root != null) {
            if (root.val == x) {
                return root.val;
            }

            if (x > root.val) {
                root = root.right;
            } else {
                ceil = root.val;
                root = root.left;
            }
        }

        return ceil;
    }

    // insert helper
    public static Node insert(Node root, int val) {
        if (root == null) return new Node(val);

        if (val < root.val) root.left = insert(root.left, val);
        else root.right = insert(root.right, val);

        return root;
    }

    public static void main(String[] args) {

        Node root = null;
        int[] arr = {8, 4, 12, 2, 6, 14};

        for (int x : arr) {
            root = insert(root, x);
        }

        int x = 5;

        System.out.println("Floor of " + x + ": " + floor(root, x));
        System.out.println("Ceil of " + x + ": " + ceil(root, x));
    }
}
