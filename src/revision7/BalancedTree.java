package revision7;

class Node7 {
    int data;
    Node7 left, right;

    Node7(int data) {
        this.data = data;
    }
}

public class BalancedTree {

    static boolean isBalanced(Node7 root) {

        return height(root) != -1;
    }

    static int height(Node7 root) {

        if (root == null)
            return 0;

        int left = height(root.left);

        if (left == -1)
            return -1;

        int right = height(root.right);

        if (right == -1)
            return -1;

        if (Math.abs(left - right) > 1)
            return -1;

        return 1 + Math.max(left, right);
    }

    public static void main(String[] args) {

        Node7 root = new Node7(1);

        root.left = new Node7(2);
        root.right = new Node7(3);

        root.left.left = new Node7(4);

        System.out.println(
                isBalanced(root)
        );
    }
}
