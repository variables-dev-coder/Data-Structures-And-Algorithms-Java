package Trees.Binary_Tree.Useful_Problems_Patterns;

/*
Diameter of a Binary Tree
Definition:
The diameter of a binary tree is the length of the longest path between any two nodes in the tree.
This path may or may not pass through the root.

Example
        1
       / \
      2   3
     / \
    4   5

Longest Path: 4 → 2 → 1 → 3
Diameter Length: 3 edges (or 4 nodes)

Approach 1 (Naive O(N²))
1. For each node:
    Find the height of left subtree.
    Find the height of right subtree.
    Update diameter = max(diameter, leftHeight + rightHeight)
2. Recursively find for each node.

 */

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class DiameterOfBinaryTree {
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        int leftDiameter = diameterOfBinaryTree(root.left);
        int rightDiameter = diameterOfBinaryTree(root.right);

        return Math.max(leftHeight + rightHeight, Math.max(leftDiameter, rightDiameter));
    }

    private int height(TreeNode node) {
        if (node == null) return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        DiameterOfBinaryTree d = new DiameterOfBinaryTree();
        System.out.println("Diameter: " + d.diameterOfBinaryTree(root));
    }
}

/*
Output:

Diameter: 3

Key Takeaways

Diameter = leftHeight + rightHeight (for any node)

Compute height and update diameter simultaneously → O(N)

Helps in network path analysis, tree depth problems, and graph traversal logic building.
 */