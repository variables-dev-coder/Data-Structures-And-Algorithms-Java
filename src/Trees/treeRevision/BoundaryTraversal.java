package Trees.treeRevision;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BoundaryTraversal {

    static class Node {
        int val;
        Node left, right;

        Node(int v) {
            val = v;
        }
    }

    public static List<Integer> boundary(Node root) {

        List<Integer> res = new ArrayList<>();

        if (root == null) return res;

        if (!isLeaf(root)) res.add(root.val);

        addLeftBoundary(root, res);
        addLeaves(root, res);
        addRightBoundary(root, res);

        return res;
    }

    static boolean isLeaf(Node node) {
        return node.left == null && node.right == null;
    }

    // Left boundary
    static void addLeftBoundary(Node root, List<Integer> res) {

        Node curr = root.left;

        while (curr != null) {

            if (!isLeaf(curr)) res.add(curr.val);

            if (curr.left != null) curr = curr.left;
            else curr = curr.right;
        }
    }

    // Leaf nodes
    static void addLeaves(Node root, List<Integer> res) {

        if (isLeaf(root)) {
            res.add(root.val);
            return;
        }

        if (root.left != null) addLeaves(root.left, res);
        if (root.right != null) addLeaves(root.right, res);
    }

    // Right boundary (reverse)
    static void addRightBoundary(Node root, List<Integer> res) {

        Node curr = root.right;
        Stack<Integer> stack = new Stack<>();

        while (curr != null) {

            if (!isLeaf(curr)) stack.push(curr.val);

            if (curr.right != null) curr = curr.right;
            else curr = curr.left;
        }

        while (!stack.isEmpty()) {
            res.add(stack.pop());
        }
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.left.right.left = new Node(7);
        root.left.right.right = new Node(8);

        root.right.right = new Node(6);

        List<Integer> result = boundary(root);

        System.out.println(result); // [1, 2, 4, 7, 8, 6, 3]
    }
}
