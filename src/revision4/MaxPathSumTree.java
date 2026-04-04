package revision4;

public class MaxPathSumTree {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static int maxSum = Integer.MIN_VALUE;

    public static int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    private static int dfs(TreeNode root) {

        if (root == null) return 0;

        int left = Math.max(0, dfs(root.left));
        int right = Math.max(0, dfs(root.right));

        // update global max
        maxSum = Math.max(maxSum, left + right + root.val);

        // return one side
        return root.val + Math.max(left, right);
    }

    public static void main(String[] args) {

        // Build tree
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        int result = maxPathSum(root);

        System.out.println("Maximum Path Sum: " + result);
    }
}
