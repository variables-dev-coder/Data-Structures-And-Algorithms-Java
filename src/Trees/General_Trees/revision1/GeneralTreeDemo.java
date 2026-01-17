package Trees.General_Trees.revision1;

import java.util.*;

class TreeNode {
    int data;
    List<TreeNode> children;

    TreeNode(int data) {
        this.data = data;
        this.children = new ArrayList<>();
    }
}

public class GeneralTreeDemo {

    // 1 Preorder Traversal (DFS)
    static void preorder(TreeNode root) {
        if (root == null) return;

        System.out.print(root.data + " ");
        for (TreeNode child : root.children) {
            preorder(child);
        }
    }

    // 2 Count Total Nodes
    static int countNodes(TreeNode root) {
        if (root == null) return 0;

        int count = 1; // count self
        for (TreeNode child : root.children) {
            count += countNodes(child);
        }
        return count;
    }

    // 3 Height of General Tree
    static int height(TreeNode root) {
        if (root == null) return 0;

        int maxHeight = 0;
        for (TreeNode child : root.children) {
            maxHeight = Math.max(maxHeight, height(child));
        }
        return maxHeight + 1;
    }

    // 4 Search Element
    static boolean search(TreeNode root, int target) {
        if (root == null) return false;
        if (root.data == target) return true;

        for (TreeNode child : root.children) {
            if (search(child, target)) return true;
        }
        return false;
    }

    // 5 Level Order Traversal (BFS)
    static void levelOrder(TreeNode root) {
        if (root == null) return;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            System.out.print(curr.data + " ");

            for (TreeNode child : curr.children) {
                q.offer(child);
            }
        }
    }

    // 🔹 MAIN METHOD
    public static void main(String[] args) {

        // Constructing General Tree
        TreeNode root = new TreeNode(1);

        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);

        root.children.add(node2);
        root.children.add(node3);
        root.children.add(node4);

        node3.children.add(node5);
        node3.children.add(node6);

        // ---- Operations ----
        System.out.print("Preorder DFS: ");
        preorder(root);

        System.out.println("\nTotal Nodes: " + countNodes(root));

        System.out.println("Height: " + height(root));

        System.out.println("Search 5: " + search(root, 5));
        System.out.println("Search 10: " + search(root, 10));

        System.out.print("Level Order BFS: ");
        levelOrder(root);
    }
}

/*

Preorder DFS: 1 2 3 5 6 4
Total Nodes: 6
Height: 3
Search 5: true
Search 10: false
Level Order BFS: 1 2 3 4 5 6

 */
