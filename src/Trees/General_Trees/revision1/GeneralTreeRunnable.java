package Trees.General_Trees.revision1;

import java.util.*;

public class GeneralTreeRunnable {

    // ONE concept: General Tree Node
    static class TreeNode {
        int data;
        List<TreeNode> children = new ArrayList<>();

        TreeNode(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {

        // Create nodes
        TreeNode root = new TreeNode(1);
        TreeNode a = new TreeNode(2);
        TreeNode b = new TreeNode(3);
        TreeNode c = new TreeNode(4);

        // Build general tree
        root.children.add(a);
        root.children.add(b);
        root.children.add(c);

        b.children.add(new TreeNode(5));
        b.children.add(new TreeNode(6));

        // Just print root and its children
        System.out.println("Root: " + root.data);

        System.out.print("Children of root: ");
        for (TreeNode child : root.children) {
            System.out.print(child.data + " ");
        }
    }
}

//Root: 1
//Children of root: 2 3 4