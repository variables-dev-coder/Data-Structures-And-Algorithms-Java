package Trees.Tree_Construction.day07_Maximum_Path_Problems;

public class MaximumPathSum {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int v) { val = v; }
    }

    static int maxSum = Integer.MIN_VALUE;

    public static int maxGain(TreeNode root) {
        if (root == null) return 0;

        int left = Math.max(0, maxGain(root.left));
        int right = Math.max(0, maxGain(root.right));

        // global update
        maxSum = Math.max(maxSum, left + right + root.val);

        // local return
        return root.val + Math.max(left, right);
    }

    public static int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        maxGain(root);
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

