package Trees.General_Trees.revision1;

import java.util.*;

public class GeneralTreeRootToLeaf {

    static class TreeNode {
        int data;
        List<TreeNode> children = new ArrayList<>();
        TreeNode(int data) { this.data = data; }
    }

    public static void main(String[] args) {
        TreeNode root = buildTree();
        printPaths(root, new ArrayList<>());
    }

    static void printPaths(TreeNode node, List<Integer> path) {
        if (node == null) return;

        path.add(node.data);

        if (node.children.isEmpty()) {
            System.out.println(path);
        }

        for (TreeNode child : node.children) {
            printPaths(child, path);
        }

        path.remove(path.size() - 1); // backtrack
    }

    static TreeNode buildTree() {
        TreeNode root = new TreeNode(1);
        root.children.add(new TreeNode(2));
        root.children.add(new TreeNode(3));
        root.children.get(1).children.add(new TreeNode(5));
        root.children.get(1).children.add(new TreeNode(6));
        return root;
    }
}

