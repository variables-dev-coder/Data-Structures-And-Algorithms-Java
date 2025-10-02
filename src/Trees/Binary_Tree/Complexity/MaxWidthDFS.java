package Trees.Binary_Tree.Complexity;

import java.util.*;

class TreeNode3 {
    int val;
    TreeNode3 left, right;

    TreeNode3(int val) {
        this.val = val;
    }
}

public class MaxWidthDFS {
    private Map<Integer, Integer> leftMostIndex = new HashMap<>();
    private int maxWidth = 0;

    public int widthOfBinaryTree(TreeNode3 root) {
        dfs(root, 0, 0);
        return maxWidth;
    }

    private void dfs(TreeNode3 node, int depth, int index) {
        if (node == null) return;

        // Record the leftmost index at this depth
        leftMostIndex.putIfAbsent(depth, index);

        // Calculate width at this depth
        int curWidth = index - leftMostIndex.get(depth) + 1;
        maxWidth = Math.max(maxWidth, curWidth);

        // Recurse left and right
        dfs(node.left, depth + 1, index * 2 + 1);
        dfs(node.right, depth + 1, index * 2 + 2);
    }

    public static void main(String[] args) {
        // Build tree:
        //       1
        //     /   \
        //    2     3
        //   / \     \
        //  4   5     7

        TreeNode3 root = new TreeNode3(1);
        root.left = new TreeNode3(2);
        root.right = new TreeNode3(3);
        root.left.left = new TreeNode3(4);
        root.left.right = new TreeNode3(5);
        root.right.right = new TreeNode3(7);

        MaxWidthDFS sol = new MaxWidthDFS();
        System.out.println("Maximum Width (DFS): " + sol.widthOfBinaryTree(root));
        // Output: 4
    }
}

// Maximum Width (DFS): 4

/*
Dry Run (DFS)
Depth 0 → first index = 0, width = 1
Depth 1 → indices [1,2], width = 2
Depth 2 → indices [3,4,null,6], width = 4
Answer = 4

Complexity
Time: O(n) (visit each node once)
Space: O(h) due to recursion stack (better than BFS O(n))



 */