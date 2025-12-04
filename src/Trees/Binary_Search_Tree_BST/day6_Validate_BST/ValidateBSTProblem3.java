package Trees.Binary_Search_Tree_BST.day6_Validate_BST;

/*
Check BST Where Violation Happens Deep in Left Subtree
Given Tree (NOT a BST)
         20
       /    \
     10      30
    /  \
   5    25   ← 25 is wrong (should be <20 AND <10)

Why is this NOT a BST?

Node 25 is in the left subtree of 20 → must be <20  (25 < 20 )

Node 25 is also in left subtree of 10 → must be <10

So 25 breaks the BST rules.
 */

public class ValidateBSTProblem3 {
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
                 20
               /    \
             10      30
            /  \
           5    25   <-- WRONG (should be <10)
        */

        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(10);
        root.right = new TreeNode(30);

        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(25);  // WRONG position

        System.out.println("Is this tree a valid BST? " + isValidBST(root));
    }
}

//Is this tree a valid BST? false

/*
Full Dry Run
 Check node = 20

Range = (-∞, +∞) → OK

 Check left subtree of 20

Node = 10
Range = (-∞, 20) → OK

 Check left subtree of 10

Node = 5
Range = (-∞, 10) → OK

 Check right subtree of 10

Node = 25
Required range = (10, 20)

Check rule:

25 > 10

25 < 20  (fails)

→ return false

 */