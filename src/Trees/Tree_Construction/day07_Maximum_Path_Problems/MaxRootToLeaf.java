package Trees.Tree_Construction.day07_Maximum_Path_Problems;

public class MaxRootToLeaf {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int v) { val = v; }
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

        System.out.println("Max Root-to-Leaf Sum: " + maxRootToLeaf(root));
    }
}

