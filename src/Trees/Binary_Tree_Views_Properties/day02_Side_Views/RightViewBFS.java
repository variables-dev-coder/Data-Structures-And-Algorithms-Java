package Trees.Binary_Tree_Views_Properties.day02_Side_Views;

import java.util.*;

public class RightViewBFS {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    public static List<Integer> rightView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (i == size - 1) result.add(node.val); // last node of level

                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(5);

        System.out.println("Right View: " + rightView(root));
    }
}

// Right View: [1, 3, 5]


//Core Idea (Must Remember)

//Left View → first node seen at each level

//Right View → last node seen at each level

//Best tool: BFS (Queue) + level size

//Alternate: DFS with level tracking
