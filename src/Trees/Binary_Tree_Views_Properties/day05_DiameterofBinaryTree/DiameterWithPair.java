package Trees.Binary_Tree_Views_Properties.day05_DiameterofBinaryTree;

public class DiameterWithPair {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    static class Pair {
        int height;
        int diameter;
    }

    public static Pair solve(TreeNode root) {
        if (root == null) {
            Pair base = new Pair();
            base.height = 0;
            base.diameter = 0;
            return base;
        }

        Pair left = solve(root.left);
        Pair right = solve(root.right);

        Pair curr = new Pair();
        curr.height = 1 + Math.max(left.height, right.height);

        int throughRoot = left.height + right.height;
        curr.diameter = Math.max(
                throughRoot,
                Math.max(left.diameter, right.diameter)
        );

        return curr;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(4);

        Pair result = solve(root);
        System.out.println("Diameter: " + result.diameter);
    }
}

// Diameter: 3