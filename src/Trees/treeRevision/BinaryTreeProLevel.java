package Trees.treeRevision;

import java.util.*;

class BinaryTreeProLevel {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    // LCA
    static Node lca(Node root, int p, int q) {
        if (root == null) return null;

        if (root.data == p || root.data == q) return root;

        Node left = lca(root.left, p, q);
        Node right = lca(root.right, p, q);

        if (left != null && right != null) return root;

        return (left != null) ? left : right;
    }

    // Balanced Tree
    static boolean isBalanced(Node root) {
        return checkHeight(root) != -1;
    }

    static int checkHeight(Node root) {
        if (root == null) return 0;

        int left = checkHeight(root.left);
        if (left == -1) return -1;

        int right = checkHeight(root.right);
        if (right == -1) return -1;

        if (Math.abs(left - right) > 1) return -1;

        return 1 + Math.max(left, right);
    }

    // Top View
    static void topView(Node root) {

        class Pair {
            Node node;
            int hd;

            Pair(Node n, int h) {
                node = n;
                hd = h;
            }
        }

        Queue<Pair> q = new LinkedList<>();
        Map<Integer, Integer> map = new TreeMap<>();

        q.add(new Pair(root, 0));

        while (!q.isEmpty()) {

            Pair curr = q.poll();

            if (!map.containsKey(curr.hd)) {
                map.put(curr.hd, curr.node.data);
            }

            if (curr.node.left != null) {
                q.add(new Pair(curr.node.left, curr.hd - 1));
            }

            if (curr.node.right != null) {
                q.add(new Pair(curr.node.right, curr.hd + 1));
            }
        }

        for (int val : map.values()) {
            System.out.print(val + " ");
        }
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        // LCA
        Node lcaNode = lca(root, 4, 5);
        System.out.println("LCA of 4 and 5: " + lcaNode.data);

        // Balanced
        System.out.println("Is Balanced: " + isBalanced(root));

        // Top View
        System.out.print("Top View: ");
        topView(root);
    }
}
