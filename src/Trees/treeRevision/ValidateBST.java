package Trees.treeRevision;

public class ValidateBST {

    static class Node {
        int val;
        Node left, right;

        Node(int v) {
            val = v;
        }
    }

    static boolean isValidBST(Node root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    static boolean validate(Node root, long min, long max) {

        if (root == null) return true;

        if (root.val <= min || root.val >= max) {
            return false;
        }

        return validate(root.left, min, root.val) &&
                validate(root.right, root.val, max);
    }

    public static void main(String[] args) {

        Node root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(7);

        root.left.left = new Node(2);
        root.left.right = new Node(4);

        System.out.println("Is Valid BST: " + isValidBST(root)); // true

        // Make it invalid
        root.left.left.val = 6;

        System.out.println("Is Valid BST: " + isValidBST(root)); // false
    }
}
