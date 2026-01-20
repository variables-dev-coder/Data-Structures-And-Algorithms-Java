package Trees.General_Trees.revision1;

import java.util.*;

public class GeneralTreeHeight {

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
        //        1
        //     /  |  \
        //    2   3   4
        //       / \
        //      5   6
        TreeNode root = new TreeNode(1);
        root.children.add(new TreeNode(2));
        root.children.add(new TreeNode(3));
        root.children.add(new TreeNode(4));

        root.children.get(1).children.add(new TreeNode(5));
        root.children.get(1).children.add(new TreeNode(6));

        int height = height(root);
        System.out.println("Height = " + height);
    }

    // ONE concept: height calculation
    static int height(TreeNode node) {
        if (node == null) return 0;

        int maxChildHeight = 0;

        for (TreeNode child : node.children) {
            maxChildHeight = Math.max(maxChildHeight, height(child));
        }

        return maxChildHeight + 1; // count current level
    }
}

