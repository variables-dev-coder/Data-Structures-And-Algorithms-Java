package Trees.General_Trees.revision1;

import java.util.*;

public class GeneralTreeSerialize {

    static class TreeNode {
        int data;
        List<TreeNode> children = new ArrayList<>();
        TreeNode(int data) { this.data = data; }
    }

    public static void main(String[] args) {

        TreeNode root = buildTree();
        List<Integer> serialized = new ArrayList<>();

        serialize(root, serialized);
        System.out.println(serialized);
    }

    static void serialize(TreeNode node, List<Integer> list) {
        if (node == null) return;

        list.add(node.data);

        for (TreeNode child : node.children) {
            serialize(child, list);
        }

        list.add(-1); // marks end of children
    }

    static TreeNode buildTree() {
        TreeNode root = new TreeNode(1);
        root.children.add(new TreeNode(2));
        root.children.add(new TreeNode(3));
        root.children.get(1).children.add(new TreeNode(5));
        return root;
    }
}

