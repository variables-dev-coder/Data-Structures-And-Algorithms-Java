package Trees.Binary_Tree.revision6;

import java.util.*;

class TreeNode {
    int data;
    TreeNode left, right;

    TreeNode(int data) {
        this.data = data;
        left = right = null;
    }
}

public class BinaryTreeDemo {

    // 1 Preorder Traversal (Root → Left → Right)
    static void preorder(TreeNode root) {
        if (root == null) return;
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    // 2 Inorder Traversal (Left → Root → Right)
    static void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    // 3 Postorder Traversal (Left → Right → Root)
    static void postorder(TreeNode root) {
        if (root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }

    // 4 Level Order Traversal (BFS)
    static void levelOrder(TreeNode root) {
        if (root == null) return;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            System.out.print(curr.data + " ");

            if (curr.left != null) q.offer(curr.left);
            if (curr.right != null) q.offer(curr.right);
        }
    }

    // 5 Count Total Nodes
    static int countNodes(TreeNode root) {
        if (root == null) return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    // 6 Height of Binary Tree
    static int height(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    // 7 Search a Value
    static boolean search(TreeNode root, int target) {
        if (root == null) return false;
        if (root.data == target) return true;

        return search(root.left, target) || search(root.right, target);
    }

    // 8 Diameter of Binary Tree
    static int diameter(TreeNode root) {
        int[] max = new int[1];
        heightForDiameter(root, max);
        return max[0];
    }

    static int heightForDiameter(TreeNode root, int[] max) {
        if (root == null) return 0;

        int lh = heightForDiameter(root.left, max);
        int rh = heightForDiameter(root.right, max);

        max[0] = Math.max(max[0], lh + rh);
        return 1 + Math.max(lh, rh);
    }

    // 🔹 MAIN METHOD
    public static void main(String[] args) {

        // Constructing the Binary Tree
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.right = new TreeNode(6);

        // ---- Operations ----
        System.out.print("Preorder: ");
        preorder(root);

        System.out.print("\nInorder: ");
        inorder(root);

        System.out.print("\nPostorder: ");
        postorder(root);

        System.out.print("\nLevel Order: ");
        levelOrder(root);

        System.out.println("\nTotal Nodes: " + countNodes(root));
        System.out.println("Height: " + height(root));

        System.out.println("Search 5: " + search(root, 5));
        System.out.println("Search 10: " + search(root, 10));

        System.out.println("Diameter: " + diameter(root));
    }
}

/*

Preorder: 1 2 4 5 3 6
Inorder: 4 2 5 1 3 6
Postorder: 4 5 2 6 3 1
Level Order: 1 2 3 4 5 6
Total Nodes: 6
Height: 3
Search 5: true
Search 10: false
Diameter: 4

 */