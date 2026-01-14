package Trees.Binary_Tree_Views_Properties.day06_LowestCommonAncestor;

public class LCAinBST {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    public static TreeNode lcaBST(TreeNode root, int p, int q) {
        if (root == null) return null;

        if (p < root.val && q < root.val)
            return lcaBST(root.left, p, q);

        if (p > root.val && q > root.val)
            return lcaBST(root.right, p, q);

        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new LCAinBST.TreeNode(2);
        root.right = new LCAinBST.TreeNode(8);
        root.left.left = new LCAinBST.TreeNode(1);
        root.left.right = new LCAinBST.TreeNode(4);

        LCAinBST.TreeNode ans = lcaBST(root, 4, 5);
        System.out.println("LCA: " + ans.val);
    }
}

