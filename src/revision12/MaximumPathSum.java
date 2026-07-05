package revision12;

class TreeNode20 {

    int data;
    TreeNode20 left, right;

    TreeNode20(int data) {
        this.data = data;
    }
}

public class MaximumPathSum {

    static int max = Integer.MIN_VALUE;

    static int dfs(TreeNode20 root) {

        if (root == null)
            return 0;

        int left = Math.max(0, dfs(root.left));
        int right = Math.max(0, dfs(root.right));

        max = Math.max(max,
                left + right + root.data);

        return Math.max(left, right)
                + root.data;
    }

    public static void main(String[] args) {

        TreeNode20 root = new TreeNode20(-10);

        root.left = new TreeNode20(9);

        root.right = new TreeNode20(20);

        root.right.left = new TreeNode20(15);
        root.right.right = new TreeNode20(7);

        dfs(root);

        System.out.println(max);
    }
}
