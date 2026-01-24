package Trees.General_Trees.revision1;

import java.util.*;

public class GeneralTreeMaxValue {

    static class TreeNode {
        int data;
        List<TreeNode> children = new ArrayList<>();
        TreeNode(int data) { this.data = data; }
    }

    public static void main(String[] args) {
        TreeNode root = buildTree();
        System.out.println("Max Value = " + findMax(root));
    }

    static int findMax(TreeNode node) {
        if (node == null) return Integer.MIN_VALUE;

        int max = node.data;
        for (TreeNode child : node.children) {
            max = Math.max(max, findMax(child));
        }
        return max;
    }

    static TreeNode buildTree() {
        TreeNode root = new TreeNode(10);
        root.children.add(new TreeNode(20));
        root.children.add(new TreeNode(3));
        root.children.add(new TreeNode(40));
        root.children.get(1).children.add(new TreeNode(50));
        root.children.get(1).children.add(new TreeNode(6));
        return root;
    }
}

