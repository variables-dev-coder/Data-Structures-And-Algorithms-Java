package revision7;

class Node15 {

    int data;
    Node15 left, right;

    Node15(int data) {
        this.data = data;
    }
}

public class MaximumPathSum {

    static int maxSum =
            Integer.MIN_VALUE;

    static int solve(Node15 root) {

        if (root == null)
            return 0;

        int left =
                Math.max(
                        0,
                        solve(root.left));

        int right =
                Math.max(
                        0,
                        solve(root.right));

        maxSum =
                Math.max(
                        maxSum,
                        root.data +
                                left +
                                right);

        return root.data +
                Math.max(left, right);
    }

    public static void main(String[] args) {

        Node15 root = new Node15(10);

        root.left = new Node15(2);
        root.right = new Node15(10);

        root.left.left =
                new Node15(20);

        root.left.right =
                new Node15(1);

        solve(root);

        System.out.println(maxSum);
    }
}
