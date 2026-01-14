package Trees.Binary_Tree_Views_Properties.day06_LowestCommonAncestor;

public class DistanceBetweenNodes {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    static TreeNode lca(TreeNode root, int p, int q) {
        if (root == null) return null;
        if (root.val == p || root.val == q) return root;

        TreeNode left = lca(root.left, p, q);
        TreeNode right = lca(root.right, p, q);

        if (left != null && right != null) return root;
        return (left != null) ? left : right;
    }

    static int findDistance(TreeNode root, int target, int dist) {
        if (root == null) return -1;
        if (root.val == target) return dist;

        int left = findDistance(root.left, target, dist + 1);
        if (left != -1) return left;

        return findDistance(root.right, target, dist + 1);
    }

    public static int distance(TreeNode root, int p, int q) {
        TreeNode lcaNode = lca(root, p, q);

        int d1 = findDistance(lcaNode, p, 0);
        int d2 = findDistance(lcaNode, q, 0);

        return d1 + d2;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println("Distance: " + distance(root, 4, 5));
    }
}

// Distance: 2