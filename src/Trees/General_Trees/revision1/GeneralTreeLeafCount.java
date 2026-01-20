package Trees.General_Trees.revision1;

import java.util.*;

public class GeneralTreeLeafCount {

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

        int leafCount = countLeaves(root);
        System.out.println("Leaf Nodes = " + leafCount);
    }

    // ONE concept: leaf count
    static int countLeaves(TreeNode node) {
        if (node == null) return 0;

        // leaf condition
        if (node.children.isEmpty()) return 1;

        int count = 0;
        for (TreeNode child : node.children) {
            count += countLeaves(child);
        }
        return count;
    }
}

