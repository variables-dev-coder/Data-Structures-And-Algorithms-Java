package Trees.General_Trees.revision1;

import java.util.*;

public class GeneralTreeDiameter {

    static class TreeNode {
        int data;
        List<TreeNode> children = new ArrayList<>();
        TreeNode(int data) { this.data = data; }
    }

    static int diameter = 0;

    public static void main(String[] args) {

        TreeNode root = buildTree();
        height(root);

        System.out.println("Diameter = " + diameter);
    }

    // returns height and updates diameter
    static int height(TreeNode node) {
        if (node == null) return 0;

        int max1 = 0, max2 = 0;

        for (TreeNode child : node.children) {
            int h = height(child);

            if (h > max1) {
                max2 = max1;
                max1 = h;
            } else if (h > max2) {
                max2 = h;
            }
        }

        diameter = Math.max(diameter, max1 + max2);

        return max1 + 1;
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

