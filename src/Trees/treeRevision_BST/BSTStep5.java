package Trees.treeRevision_BST;

import java.util.*;

public class BSTStep5 {

    static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
        }
    }

    static int count = 0;
    static int answer = -1;

    public static void inorder(Node root, int k) {
        if (root == null) return;

        inorder(root.left, k);

        count++;
        if (count == k) {
            answer = root.val;
            return;
        }

        inorder(root.right, k);
    }

    public static int kthSmallest(Node root, int k) {
        count = 0;
        answer = -1;
        inorder(root, k);
        return answer;
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
        int[] arr = {5, 3, 7, 2, 4, 8};

        for (int x : arr) {
            root = insert(root, x);
        }

        int k = 3;
        System.out.println("Kth Smallest: " + kthSmallest(root, k));
    }
}
