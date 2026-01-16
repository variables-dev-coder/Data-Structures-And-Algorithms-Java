package Trees.Binary_Tree_Views_Properties.day07_MaximumPathProblems;

public class MaximumPathSum {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    static int maxSum = Integer.MIN_VALUE;

    public static int maxPath(TreeNode root) {
        if (root == null) return 0;

        int left = Math.max(0, maxPath(root.left));
        int right = Math.max(0, maxPath(root.right));

        // Global update (can take both sides)
        maxSum = Math.max(maxSum, left + right + root.val);

        // Local return (only one side)
        return root.val + Math.max(left, right);
    }

    public static int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        maxPath(root);
        return maxSum;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println("Max Path Sum: " + maxPathSum(root));
    }
}

// Max Path Sum: 42