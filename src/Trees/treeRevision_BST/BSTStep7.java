package Trees.treeRevision_BST;

import java.util.*;

public class BSTStep7 {

    static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
        }
    }

    static class BSTIterator {

        Stack<Node> stack = new Stack<>();

        public BSTIterator(Node root) {
            pushLeft(root);
        }

        private void pushLeft(Node node) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }

        public int next() {
            Node curr = stack.pop();

            // process right subtree
            if (curr.right != null) {
                pushLeft(curr.right);
            }

            return curr.val;
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }
    }

    // insert helper
    public static Node insert(Node root, int val) {
        if (root == null) return new Node(val);

        if (val < root.val) root.left = insert(root.left, val);
        else root.right = insert(root.right, val);

        return root;
    }

    public static void main(String[] args) {

        Node root = null;
        int[] arr = {7, 3, 15, 9, 20};

        for (int x : arr) {
            root = insert(root, x);
        }

        BSTIterator it = new BSTIterator(root);

        System.out.print("BST Iterator Output: ");
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
    }
}
