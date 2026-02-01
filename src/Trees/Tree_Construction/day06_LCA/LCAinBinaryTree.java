package Trees.Tree_Construction.day06_LCA;

public class LCAinBinaryTree {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int v) { val = v; }
    }

    public static TreeNode lca(TreeNode root, int p, int q) {
        if (root == null) return null;

        if (root.val == p || root.val == q)
            return root;

        TreeNode left = lca(root.left, p, q);
        TreeNode right = lca(root.right, p, q);

        if (left != null && right != null)
            return root;

        return (left != null) ? left : right;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println("LCA: " + lca(root, 4, 5).val);  // LCA: 2
    }
}

