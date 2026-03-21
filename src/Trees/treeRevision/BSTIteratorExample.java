package Trees.treeRevision;

import java.util.Stack;

public class BSTIteratorExample {

    static class Node {
        int val;
        Node left, right;

        Node(int v) {
            val = v;
        }
    }

    static class BSTIterator {

        Stack<Node> stack = new Stack<>();

        // Constructor
        public BSTIterator(Node root) {
            pushLeft(root);
        }

        // Push all left nodes
        private void pushLeft(Node node) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }

        // Return next smallest
        public int next() {

            Node curr = stack.pop();

            // If right exists, process its left subtree
            if (curr.right != null) {
                pushLeft(curr.right);
            }

            return curr.val;
        }

        // Check if more elements exist
        public boolean hasNext() {
            return !stack.isEmpty();
        }
    }

    // Insert helper
    static Node insert(Node root, int val) {
        if (root == null) return new Node(val);

        if (val < root.val)
            root.left = insert(root.left, val);
        else
            root.right = insert(root.right, val);

        return root;
    }

    public static void main(String[] args) {

        Node root = null;

        int[] values = {5, 3, 7, 2, 4};

        for (int v : values) {
            root = insert(root, v);
        }

        BSTIterator it = new BSTIterator(root);

        System.out.print("BST Iterator Output: ");

        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
    }
}
