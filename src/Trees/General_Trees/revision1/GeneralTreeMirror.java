package Trees.General_Trees.revision1;

import java.util.*;

public class GeneralTreeMirror {

    static class TreeNode {
        int data;
        List<TreeNode> children = new ArrayList<>();
        TreeNode(int data) { this.data = data; }
    }

    public static void main(String[] args) {

        TreeNode root = buildTree();

        System.out.print("Before Mirror: ");
        preorder(root);

        mirror(root);

        System.out.print("\nAfter Mirror: ");
        preorder(root);
    }

    static void mirror(TreeNode node) {
        if (node == null) return;

        Collections.reverse(node.children);

        for (TreeNode child : node.children) {
            mirror(child);
        }
    }

    static void preorder(TreeNode node) {
        if (node == null) return;
        System.out.print(node.data + " ");
        for (TreeNode child : node.children) {
            preorder(child);
        }
    }

    static TreeNode buildTree() {
        TreeNode root = new TreeNode(1);
        root.children.add(new TreeNode(2));
        root.children.add(new TreeNode(3));
        root.children.add(new TreeNode(4));
        root.children.get(1).children.add(new TreeNode(5));
        root.children.get(1).children.add(new TreeNode(6));
        return root;
    }
}

