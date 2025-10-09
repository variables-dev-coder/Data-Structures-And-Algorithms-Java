package Trees.Binary_Tree.Useful_Problems_Patterns;

/*
Path Sum Problem

The Path Sum problem focuses on finding whether there exists a path from root to
leaf such that the sum of the node values equals a target sum.

Example

        5
       / \
      4   8
     /   / \
    11  13  4
   /  \
  7    2

Target Sum = 22

Path: 5 → 4 → 11 → 2
Sum = 22

Approach 1: Check if Path Exists (LeetCode 112)

We’ll use recursion:

Subtract current node’s value from the target sum.

If we reach a leaf node (no children) and remaining sum == 0 → path found.

 */


class TreeNode3 {
    int val;
    TreeNode3 left, right;

    TreeNode3(int val) {
        this.val = val;
    }
}

public class PathSumExist {
    public boolean hasPathSum(TreeNode3 root, int targetSum) {
        if (root == null) return false;

        // If it's a leaf node
        if (root.left == null && root.right == null)
            return targetSum == root.val;

        int remaining = targetSum - root.val;

        return hasPathSum(root.left, remaining) || hasPathSum(root.right, remaining);
    }

    public static void main(String[] args) {
        TreeNode3 root = new TreeNode3(5);
        root.left = new TreeNode3(4);
        root.right = new TreeNode3(8);
        root.left.left = new TreeNode3(11);
        root.left.left.left = new TreeNode3(7);
        root.left.left.right = new TreeNode3(2);
        root.right.left = new TreeNode3(13);
        root.right.right = new TreeNode3(4);

        PathSumExist ps = new PathSumExist();
        System.out.println(ps.hasPathSum(root, 22)); // true
    }
}

//true