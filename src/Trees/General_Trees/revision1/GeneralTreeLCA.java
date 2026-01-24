package Trees.General_Trees.revision1;

import java.util.*;

public class GeneralTreeLCA {

    static class TreeNode {
        int data;
        List<TreeNode> children = new ArrayList<>();
        TreeNode(int data) { this.data = data; }
    }

    public static void main(String[] args) {

        TreeNode root = buildTree();

        TreeNode lca = lca(root, 5, 6);
        System.out.println("LCA = " + (lca != null ? lca.data : "null"));
    }

    static TreeNode lca(TreeNode node, int a, int b) {
        if (node == null) return null;

        if (node.data == a || node.data == b)
            return node;

        int count = 0;
        TreeNode temp = null;

        for (TreeNode child : node.children) {
            TreeNode res = lca(child, a, b);
            if (res != null) {
                count++;
                temp = res;
            }
        }

        if (count >= 2) return node;

        return temp;
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

