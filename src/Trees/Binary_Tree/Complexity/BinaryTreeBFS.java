package Trees.Binary_Tree.Complexity;

// BFS Iterative (Level Order)

import java.util.*;

class BinaryTreeBFS {
    public void levelOrder(TreeNode root) {
        if (root == null) return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.val + " ");

            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
    }

    public static void main(String[] args) {
        // Build sample tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        BinaryTreeBFS bt = new BinaryTreeBFS();
        bt.levelOrder(root);  // Output: 1 2 3 4 5
    }
}

/*
Complexity Analysis
Time: Each node enters and leaves queue once → O(n)
Space: Queue holds nodes of the largest level → O(n) in worst case


Dry Run (DFS vs BFS)
Tree:
       1
     /   \
    2     3
   / \
  4   5


DFS (Inorder): Visit Left → Root → Right
Path → 4 → 2 → 5 → 1 → 3

BFS (Level order): Visit level by level
Path → 1 → 2 → 3 → 4 → 5

DFS (recursive/iterative) → O(n) time, O(h) space.
BFS (queue) → O(n) time, O(n) space.



 */