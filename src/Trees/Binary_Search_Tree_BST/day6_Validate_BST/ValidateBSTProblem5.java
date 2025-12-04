package Trees.Binary_Search_Tree_BST.day6_Validate_BST;

/*

Subtree Looks Correct, But Violates Global BST Rule
Given Binary Tree (NOT a BST)
         50
       /    \
     30      70
    / \     /  \
  20  60   55   80
        ↑
        WRONG: 60 > 50 but placed in left subtree of 50

Why is this NOT a BST?

Node 60 is in the left subtree of 50 → MUST be < 50

But 60 > 50 → immediate violation

This problem tests global range checking, not local.
 */



public class ValidateBSTProblem5 {
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) { this.val = val; }
    }

    public static boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean validate(TreeNode node, long min, long max) {
        if (node == null) return true;

        if (node.val <= min || node.val >= max)
            return false;

        return validate(node.left, min, node.val) &&
                validate(node.right, node.val, max);
    }

    public static void main(String[] args) {

        /*
                     50
                   /    \
                 30      70
                / \     /  \
              20  60   55   80
        */

        TreeNode root = new TreeNode(50);
        root.left = new TreeNode(30);
        root.right = new TreeNode(70);

        root.left.left = new TreeNode(20);
        root.left.right = new TreeNode(60);   // WRONG → should be in right subtree

        root.right.left = new TreeNode(55);
        root.right.right = new TreeNode(80);

        System.out.println("Is this tree a valid BST? " + isValidBST(root));
    }
}

//Is this tree a valid BST? false

/*
Dry Run (Master Level)
Step 1

Node = 50
Range = (-∞, +∞) → OK

Step 2

Left subtree → Node = 30
Range = (-∞, 50) → OK

Step 3

Right child of 30 → Node = 60
Range = (-∞, 30)

Check rule:

60 > 30

Also 60 > 50

Both ways invalid.

→ return false immediately.
 */