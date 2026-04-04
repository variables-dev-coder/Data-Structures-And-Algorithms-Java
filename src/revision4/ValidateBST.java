package revision4;

public class ValidateBST {

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

    private static boolean validate(TreeNode root, long min, long max) {

        if (root == null) return true;

        // violation
        if (root.val <= min || root.val >= max) return false;

        // check left & right with updated range
        return validate(root.left, min, root.val) &&
                validate(root.right, root.val, max);
    }

    public static void main(String[] args) {

        // Build tree
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);

        boolean result = isValidBST(root);

        System.out.println("Is Valid BST: " + result);
    }
}
