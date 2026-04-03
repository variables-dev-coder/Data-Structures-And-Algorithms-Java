package revision4;

public class DiameterTree {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static int maxDiameter = 0;

    public static int diameter(TreeNode root) {
        height(root);
        return maxDiameter;
    }

    private static int height(TreeNode root) {

        if (root == null) return 0;

        int left = height(root.left);
        int right = height(root.right);

        // update diameter
        maxDiameter = Math.max(maxDiameter, left + right);

        return 1 + Math.max(left, right);
    }

    public static void main(String[] args) {

        // Build tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        int result = diameter(root);

        System.out.println("Diameter: " + result);
    }
}
