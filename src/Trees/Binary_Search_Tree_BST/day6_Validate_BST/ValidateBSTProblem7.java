package Trees.Binary_Search_Tree_BST.day6_Validate_BST;

/*
Left Subtree Has a Value Greater Than Root (Deep Violation)

This is a classic case where the tree locally looks fine, but globally it breaks the BST rule.

Given Tree (NOT a BST)
          50
        /    \
      30      80
     / \     /  \
    20 40  70   90
          \
           60  ← WRONG (60 > 50 but inside LEFT subtree of 50)

Why is this NOT a BST?

Node 60 is:

In the left subtree of 50 → must be < 50

But 60 > 50 →  violation

Even though locally 60 > 40 is correct, global rule is broken.
 */

public class ValidateBSTProblem7 {

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
                  30      80
                 / \     /  \
               20  40   70  90
                      \
                       60  <-- INVALID (should be < 50)
        */

        TreeNode root = new TreeNode(50);
        root.left = new TreeNode(30);
        root.right = new TreeNode(80);

        root.left.left = new TreeNode(20);
        root.left.right = new TreeNode(40);

        root.right.left = new TreeNode(70);
        root.right.right = new TreeNode(90);

        root.left.right.right = new TreeNode(60); // WRONG

        System.out.println("Is this tree a valid BST? " + isValidBST(root));
    }
}

//Is this tree a valid BST? false

/*

Master-Level Dry Run
Step 1

Node = 50
Range = (-∞, +∞) →  Valid

Step 2

Check left subtree → Node = 30
Range = (-∞, 50) →  Valid

Step 3

Right child of 30 → Node = 40
Range = (-∞, 30)?  No

Correct range = (30, 50)

40 > 30
40 < 50
→ Valid

Step 4

Right child of 40 → Node = 60
Required range = (40, 50)

Check:

60 > 40

60 < 50

This violates the global rule:

 Node is in the left subtree of 50, so MUST be < 50
But 60 > 50 →  invalid BST

→ Return false immediately.
 */