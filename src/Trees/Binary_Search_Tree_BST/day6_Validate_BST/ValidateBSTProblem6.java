package Trees.Binary_Search_Tree_BST.day6_Validate_BST;

/*
Right Subtree Violates BST Rules Deep Inside

This problem tests whether you understand that every right-subtree node must be > root, not just > parent.

Given Tree (NOT a BST)
          40
        /    \
      20      60
     / \     /  \
    10 30   50  70
           /
          25   ← WRONG (should be > 40 since it's in RIGHT subtree of 40)

Why is this invalid?

Node 25 is:

in the right subtree of 40 → must be > 40

but 25 < 40 → violates global BST rule

Even though locally (25 < 50) is correct, GLOBAL rule breaks.
 */

public class ValidateBSTProblem6 {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
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
                      40
                    /    \
                  20      60
                 / \     /  \
               10  30   50  70
                      /
                     25   <-- WRONG (should be > 40)
        */

        TreeNode root = new TreeNode(40);
        root.left = new TreeNode(20);
        root.right = new TreeNode(60);

        root.left.left = new TreeNode(10);
        root.left.right = new TreeNode(30);

        root.right.left = new TreeNode(50);
        root.right.right = new TreeNode(70);

        root.right.left.left = new TreeNode(25); // INVALID

        System.out.println("Is this tree a valid BST? " + isValidBST(root));
    }
}

//Is this tree a valid BST? false

/*
Dry Run (Mastery Level)
Step 1

Node = 40, range = (-∞, +∞) →  Valid

Step 2

Right subtree → Node = 60
Range = (40, +∞) →  Valid

Step 3

Left child of 60 → Node = 50
Range = (40, 60) →  Valid

Step 4

Left child of 50 → Node = 25
Range = (40, 50)

Check:

25 > 40 ?

25 < 50 ?

But BST requires both conditions.

Since 25 < 40, it violates the global constraint.

→ return false

BST validation immediately fails.
 */