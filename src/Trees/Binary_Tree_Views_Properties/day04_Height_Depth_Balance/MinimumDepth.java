package Trees.Binary_Tree_Views_Properties.day04_Height_Depth_Balance;

class MinimumDepth {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    public static int minDepth(TreeNode root) {
        if (root == null) return 0;

        if (root.left == null) return 1 + minDepth(root.right);
        if (root.right == null) return 1 + minDepth(root.left);

        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);

        System.out.println("Min Depth: " + minDepth(root));
    }
}

// Min Depth: 3