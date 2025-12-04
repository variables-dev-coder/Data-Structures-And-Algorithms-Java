package Trees.Binary_Search_Tree_BST.day6_Validate_BST;


/*
Validate BST with Duplicate Values
 Rule in BST:

No duplicates allowed

If duplicates exist, depending on convention:
 Either disallowed (strict BST)
 Or duplicates must go on a specific side (left or right)

We follow the STRICT BST rule:
 NO duplicates allowed.

 Given Tree (NOT a BST)**

Duplicate 20 violates strict BST rule.

        20
       /  \
     10    30
           /
          20   ← duplicate (not allowed)
 */


public class ValidateBSTProblem4 {
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

        // Duplicates NOT allowed (strict BST)
        if (node.val <= min || node.val >= max)
            return false;

        return validate(node.left, min, node.val) &&
                validate(node.right, node.val, max);
    }

    public static void main(String[] args) {

        /*
                 20
               /    \
             10      30
                    /
                   20   <-- Duplicate (NOT ALLOWED)
        */

        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(10);
        root.right = new TreeNode(30);

        root.right.left = new TreeNode(20); // duplicate

        System.out.println("Is this tree a valid BST? " + isValidBST(root));
    }
}

//Is this tree a valid BST? false

/*
Dry Run (Step-by-Step)
1 Node = 20

Range = (-∞, +∞) → OK

2 Right subtree of 20 → Node = 30

Range = (20, +∞) → OK

3 Left subtree of 30 → Node = 20

Range = (20, 30)

Check strict rules:

20 > 20  (fails, because duplicates not allowed)

So validation fails → return false.
 */