package Trees.Binary_Tree.Useful_Problems_Patterns;

/*
Boundary Traversal of Binary Tree

Definition:
Print all boundary nodes in anti-clockwise order starting from the root:
    1.Left boundary (excluding leaves)
    2.All leaf nodes (left to right)
    3.Right boundary (excluding leaves, bottom to top)

Example Tree
        1
       / \
      2   3
     / \   \
    4   5   6
       / \
      7   8
Output:
[1, 2, 4, 7, 8, 6, 3]

 */

import java.util.*;

class TreeNode6 {
    int val;
    TreeNode6 left, right;

    TreeNode6(int val) {
        this.val = val;
    }
}

public class BoundaryTraversal {
    public List<Integer> boundaryOfBinaryTree(TreeNode6 root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        result.add(root.val);

        // Add left boundary
        addLeftBoundary(root.left, result);

        // Add leaves
        addLeaves(root.left, result);
        addLeaves(root.right, result);

        // Add right boundary (bottom-up)
        addRightBoundary(root.right, result);

        return result;
    }

    private void addLeftBoundary(TreeNode6 node, List<Integer> res) {
        while (node != null) {
            if (!isLeaf(node)) res.add(node.val);
            node = (node.left != null) ? node.left : node.right;
        }
    }

    private void addRightBoundary(TreeNode6 node, List<Integer> res) {
        Stack<Integer> stack = new Stack<>();
        while (node != null) {
            if (!isLeaf(node)) stack.push(node.val);
            node = (node.right != null) ? node.right : node.left;
        }
        while (!stack.isEmpty())
            res.add(stack.pop());
    }

    private void addLeaves(TreeNode6 node, List<Integer> res) {
        if (node == null) return;
        if (isLeaf(node)) {
            res.add(node.val);
            return;
        }
        addLeaves(node.left, res);
        addLeaves(node.right, res);
    }

    private boolean isLeaf(TreeNode6 node) {
        return node.left == null && node.right == null;
    }

    public static void main(String[] args) {
        TreeNode6 root = new TreeNode6(1);
        root.left = new TreeNode6(2);
        root.right = new TreeNode6(3);
        root.left.left = new TreeNode6(4);
        root.left.right = new TreeNode6(5);
        root.left.right.left = new TreeNode6(7);
        root.left.right.right = new TreeNode6(8);
        root.right.right = new TreeNode6(6);

        BoundaryTraversal bt = new BoundaryTraversal();
        System.out.println(bt.boundaryOfBinaryTree(root));
    }
}

/*
output : [1, 2, 4, 7, 8, 6, 3]

Key Takeaways

Zigzag → BFS + direction flag
Boundary → combination of left boundary, leaves, right boundary
Mastering these helps in advanced view problems like:
    Top View
    Bottom View
    Vertical & Diagonal Traversals


 */