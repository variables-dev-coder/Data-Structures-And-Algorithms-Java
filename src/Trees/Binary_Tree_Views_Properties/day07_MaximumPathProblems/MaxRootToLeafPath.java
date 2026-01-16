package Trees.Binary_Tree_Views_Properties.day07_MaximumPathProblems;

public class MaxRootToLeafPath {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    public static int maxRootToLeaf(TreeNode root) {
        if (root == null) return Integer.MIN_VALUE;
        if (root.left == null && root.right == null)
            return root.val;

        return root.val + Math.max(
                maxRootToLeaf(root.left),
                maxRootToLeaf(root.right)
        );
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);

        System.out.println("Max Root to Leaf Path: " +
                maxRootToLeaf(root));
    }
}

// Max Root to Leaf Path: 26