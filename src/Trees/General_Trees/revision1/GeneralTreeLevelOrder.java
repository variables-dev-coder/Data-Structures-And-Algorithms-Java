package Trees.General_Trees.revision1;

import java.util.*;

public class GeneralTreeLevelOrder {

    // General Tree Node
    static class TreeNode {
        int data;
        List<TreeNode> children = new ArrayList<>();

        TreeNode(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {

        // Build tree
        TreeNode root = new TreeNode(1);
        root.children.add(new TreeNode(2));
        root.children.add(new TreeNode(3));
        root.children.add(new TreeNode(4));

        root.children.get(1).children.add(new TreeNode(5));
        root.children.get(1).children.add(new TreeNode(6));

        levelOrder(root);
    }

    // ONE concept: BFS using Queue
    static void levelOrder(TreeNode root) {
        if (root == null) return;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            System.out.print(curr.data + " ");

            for (TreeNode child : curr.children) {
                q.add(child);
            }
        }
    }
}

