package Trees.Binary_Search_Tree_BST.day6_Validate_BST;


public class ValidateBST {

    // Tree Node Definition

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // Validate BST using range (min/max)
    public static boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static boolean validate(TreeNode node, long min, long max) {
        if (node == null) return true;

        // BST strict condition
        if (node.val <= min || node.val >= max) return false;

        return validate(node.left, min, node.val) &&
                validate(node.right, node.val, max);
    }

    public static void main(String[] args) {

        /*
              10
             /  \
            5   15
               /  \
              12  20
        */

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);

        root.right = new TreeNode(15);
        root.right.left = new TreeNode(12);
        root.right.right = new TreeNode(20);

        // Validate
        boolean result = isValidBST(root);

        System.out.println("Is this tree a valid BST? " + result);
    }
}

//Is this tree a valid BST? true

