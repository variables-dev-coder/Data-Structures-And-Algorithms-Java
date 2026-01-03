package Trees.Binary_Search_Tree_BST.day14_BST_Problem;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class ValidateBST {

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
        TreeNode root = new TreeNode(50);
        root.left = new TreeNode(30);
        root.right = new TreeNode(70);

        System.out.println(isValidBST(root)); // true
    }
}

