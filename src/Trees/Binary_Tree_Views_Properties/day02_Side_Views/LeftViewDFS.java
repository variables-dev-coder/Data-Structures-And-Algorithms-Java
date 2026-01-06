package Trees.Binary_Tree_Views_Properties.day02_Side_Views;

import java.util.*;

public class LeftViewDFS {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    static List<Integer> result = new ArrayList<>();

    public static void leftView(TreeNode root, int level) {
        if (root == null) return;

        if (level == result.size()) {
            result.add(root.val); // first time visiting this level
        }
        leftView(root.left, level + 1);
        leftView(root.right, level + 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(5);

        leftView(root, 0);
        System.out.println("Left View (DFS): " + result);
    }
}

// Left View (DFS): [1, 2, 4]


//Core Idea (Must Remember)

//Left View → first node seen at each level

//Right View → last node seen at each level

//Best tool: BFS (Queue) + level size

//Alternate: DFS with level tracking