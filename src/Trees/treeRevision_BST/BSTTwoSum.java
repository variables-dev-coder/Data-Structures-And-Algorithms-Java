package Trees.treeRevision_BST;

import java.util.*;

public class BSTTwoSum {

    static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
        }
    }

    // Inorder traversal → sorted list
    public static void inorder(Node root, List<Integer> list) {
        if (root == null) return;

        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }

    public static boolean findTarget(Node root, int target) {

        List<Integer> list = new ArrayList<>();
        inorder(root, list);

        int left = 0;
        int right = list.size() - 1;

        while (left < right) {
            int sum = list.get(left) + list.get(right);

            if (sum == target) return true;

            if (sum < target) left++;
            else right--;
        }

        return false;
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
        int[] arr = {5, 3, 7, 2, 4, 8};

        for (int x : arr) {
            root = insert(root, x);
        }

        int target = 9;

        System.out.println("Two Sum Exists: " + findTarget(root, target));
    }
}
