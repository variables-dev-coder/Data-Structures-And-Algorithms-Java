package Trees.Binary_Tree.Day01_Full_Binary_Tree;


/*
Given the root of a binary tree, return true if it is a Full Binary Tree, else return false.

       1
      / \
     2   3
    / \
   4   5
true

       1
      / \
     2   3
    /
   4
false
Node(2) has only 1 child → violates Full Binary Tree rule.
 */


import javax.swing.tree.TreeNode;

// Full Binary Tree check example
class TreeNode1 {
    int data;
    TreeNode1 left, right;

    TreeNode1(int data) {
        this.data = data;
        left = right = null;
    }
}

public class Solution {

    static boolean isFullTree(TreeNode1 root) {
        if (root == null) return true;

        // If leaf
        if (root.left == null && root.right == null) return true;

        // If both children exist → check recursively
        if (root.left != null && root.right != null)
            return isFullTree(root.left) && isFullTree(root.right);

        // If only one child → not full
        return false;
    }

    public static void main(String[] args) {
        //Example 1: Full Binary Tree
        TreeNode1 root1 = new TreeNode1(1);
        root1.left = new TreeNode1(2);
        root1.right = new TreeNode1(3);
        root1.left.left = new TreeNode1(4);
        root1.left.right = new TreeNode1(5);
        root1.right.left = new TreeNode1(6);
        root1.right.right = new TreeNode1(7);

        System.out.println("Tree 1 is Full Binary Tree? " + isFullTree(root1));

        //Example 2: Not a Full Binary Tree
        TreeNode1 root2 = new TreeNode1(1);
        root2.left = new TreeNode1(2);
        root2.right = new TreeNode1(3);
        root2.left.left = new TreeNode1(4); // only one child → violates rule

        System.out.println("Tree 2 is Full Binary Tree? " + isFullTree(root2));
    }
}

//Tree 1 is Full Binary Tree? true
//Tree 2 is Full Binary Tree? false