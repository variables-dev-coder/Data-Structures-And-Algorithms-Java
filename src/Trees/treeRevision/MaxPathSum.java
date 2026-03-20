package Trees.treeRevision;

public class MaxPathSum {

    static class Node {
        int val;
        Node left, right;

        Node(int v) {
            val = v;
        }
    }

    static int maxSum = Integer.MIN_VALUE;

    static int solve(Node root) {

        if (root == null) return 0;

        int left = Math.max(0, solve(root.left));
        int right = Math.max(0, solve(root.right));

        // case where path passes through root
        int currentPath = left + root.val + right;

        maxSum = Math.max(maxSum, currentPath);

        // return best single path
        return root.val + Math.max(left, right);
    }

    public static int maxPathSum(Node root) {
        solve(root);
        return maxSum;
    }

    public static void main(String[] args) {

        Node root = new Node(-10);
        root.left = new Node(9);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(7);

        System.out.println(maxPathSum(root)); // Output: 42
    }
}
