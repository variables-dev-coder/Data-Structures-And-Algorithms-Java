package revision4;

public class LowestCommonAncestor {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {

        // Base case
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lca(root.left, p, q);
        TreeNode right = lca(root.right, p, q);

        // If both sides return non-null → LCA found
        if (left != null && right != null) {
            return root;
        }

        // Return whichever side is not null
        return (left != null) ? left : right;
    }

    public static void main(String[] args) {

        // Build tree
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);

        TreeNode p = root.left.left;   // 6
        TreeNode q = root.left.right;  // 2

        TreeNode result = lca(root, p, q);

        System.out.println("LCA: " + result.val);
    }
}
