package Trees.Binary_Search_Tree_BST.day6_Validate_BST;

/*
Node Deep in Right Subtree Violates Global Range

This problem proves that every node in the right subtree must be > root, no matter how deep it is.

 Given Tree (NOT a BST)
             100
            /    \
         50        150
        / \       /   \
      20  80   120   200
               /
             90   ← WRONG (should be > 100)

 Why INVALID?

Node 90 is located here:

in the right subtree of 100

ALL nodes there must be > 100

But:

 90 < 100 →  violates global BST rule

Even though 90 < 120 (locally correct), it fails the top-level constraint.

 */


public class ValidateBSTProblem9 {

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
                     100
                   /     \
                 50       150
                / \      /   \
              20  80   120   200
                      /
                     90  <-- WRONG (should be > 100)
        */

        TreeNode root = new TreeNode(100);

        root.left = new TreeNode(50);
        root.right = new TreeNode(150);

        root.left.left = new TreeNode(20);
        root.left.right = new TreeNode(80);

        root.right.left = new TreeNode(120);
        root.right.right = new TreeNode(200);

        root.right.left.left = new TreeNode(90); // violation (less than 100)

        System.out.println("Is this tree a valid BST? " + isValidBST(root));
    }
}

//Is this tree a valid BST? false

/*

Dry Run (Mastery Level Understanding)
Step 1 — Start at root

Node = 100
Range = (-∞, +∞) →  valid

Step 2 — Traverse Right Subtree

Node = 150
Range = (100, +∞) →  valid

Step 3 — Left child of 150

Node = 120
Range = (100, 150) →  valid

Step 4 — Left child of 120

Node = 90
Range = (100, 120)

Check:

90 > 100

90 < 120

But failing even once means invalid.

 90 is in the right subtree of 100 → MUST be > 100
But 90 < 100 →  BST breaks here

→ Return false
→ Entire tree is invalid

 */