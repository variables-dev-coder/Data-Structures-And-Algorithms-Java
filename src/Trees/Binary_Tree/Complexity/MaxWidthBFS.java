package Trees.Binary_Tree.Complexity;

/*
Problem Statement
Given a binary tree, return the maximum width of the tree.
The width of a level = number of nodes between the leftmost and rightmost non-null nodes
(including nulls in between).

Example:
       1
     /   \
    2     3
   / \     \
  4   5     7

Level 1 → width = 1
Level 2 → width = 2
Level 3 → width = 4 (4,5,null,7)
Answer = 4

 */

import java.util.*;

class TreeNode2 {
    int val;
    TreeNode2 left, right;

    TreeNode2(int val) {
        this.val = val;
    }
}

public class MaxWidthBFS {
    static class NodeIndex {
        TreeNode2 node;
        int index;

        NodeIndex(TreeNode2 node, int index) {
            this.node = node;
            this.index = index;
        }
    }

    public int widthOfBinaryTree(TreeNode2 root) {
        if (root == null) return 0;

        Queue<NodeIndex> queue = new LinkedList<>();
        queue.offer(new NodeIndex(root, 0));
        int maxWidth = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            int minIndex = queue.peek().index; // normalize indexes
            int first = 0, last = 0;

            for (int i = 0; i < size; i++) {
                NodeIndex current = queue.poll();
                int curIndex = current.index - minIndex; // avoid overflow

                if (i == 0) first = curIndex;
                if (i == size - 1) last = curIndex;

                if (current.node.left != null)
                    queue.offer(new NodeIndex(current.node.left, curIndex * 2 + 1));
                if (current.node.right != null)
                    queue.offer(new NodeIndex(current.node.right, curIndex * 2 + 2));
            }

            maxWidth = Math.max(maxWidth, last - first + 1);
        }

        return maxWidth;
    }

    public static void main(String[] args) {
        // Build sample tree
        TreeNode2 root = new TreeNode2(1);
        root.left = new TreeNode2(2);
        root.right = new TreeNode2(3);
        root.left.left = new TreeNode2(4);
        root.left.right = new TreeNode2(5);
        root.right.right = new TreeNode2(7);

        MaxWidthBFS sol = new MaxWidthBFS();
        System.out.println("Maximum Width: " + sol.widthOfBinaryTree(root));
        // Output: 4
    }
}

// Maximum Width: 4

/*

Dry Run
Tree:

Level 1: [1] → width = 1
Level 2: [2,3] → width = 2
Level 3: [4,5,null,7] → width = 4

Result → 4

Complexity

Time: O(n) (each node visited once)
Space: O(n) (queue holds all nodes at widest level)


Why this problem is interview favorite?
It forces you to use BFS (queue). DFS alone can’t easily capture level-wise widths.
Shows clear O(n) space tradeoff for BFS.
Many candidates forget to normalize indices (to prevent overflow).


 */