package Trees.Tree_Construction.day06_LCA;

public class LCAinBST {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int v) {
            val = v;
        }
    }

    public static TreeNode lcaBST(TreeNode root, int p, int q) {
        if (root == null) return null;

        if (p < root.val && q < root.val)
            return lcaBST(root.left, p, q);

        if (p > root.val && q > root.val)
            return lcaBST(root.right, p, q);

        return root; // split point
    }

    public static void main(String[] args) {

        /*
                6
              /   \
             2     9
            / \     \
           1   4     10
         */

        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(9);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(10);

        TreeNode ans = lcaBST(root, 1, 4);
        System.out.println("LCA BST: " + ans.val); // 2
    }
}
