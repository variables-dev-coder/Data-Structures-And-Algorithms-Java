package Trees.Binary_Search_Tree_BST.day6_Validate_BST;

/*

Check if This Tree is a Valid BST (FAIL Case)
Given Tree (This is NOT a BST)

      10
     /  \
    5    15
        /  \
       6    20   ← 6 is wrong (should be >10)

Why it fails

The value 6 is in the RIGHT subtree of 10
→ but 6 < 10 → violates BST rule
 */


public class ValidateBSTFailCase {

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
              10
             /  \
            5    15
                /  \
               6    20   <-- Wrong
        */

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);

        root.right = new TreeNode(15);
        root.right.left = new TreeNode(6);   // WRONG PLACE
        root.right.right = new TreeNode(20);

        System.out.println("Is this tree a valid BST? " + isValidBST(root));
    }
}

//Is this tree a valid BST? false

/*

Dry Run (Important)
Check root = 10
Range = (-∞, +∞) → OK
Check left child = 5
Range = (-∞, 10) → OK
Check right child = 15
Range = (10, +∞) → OK
Check right-left child = 6
Range = (10, 15)
Check rule → 6 <= 10  violates BST rule
→ return false

 */