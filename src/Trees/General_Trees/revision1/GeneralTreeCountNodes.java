package Trees.General_Trees.revision1;

import java.util.*;

public class GeneralTreeCountNodes {

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

        int total = countNodes(root);
        System.out.println("Total Nodes = " + total);
    }

    // ONE concept: recursive counting
    static int countNodes(TreeNode node) {
        if (node == null) return 0;

        int count = 1; // count current node

        for (TreeNode child : node.children) {
            count += countNodes(child);
        }
        return count;
    }
}

