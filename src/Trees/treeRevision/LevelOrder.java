package Trees.treeRevision;

import java.util.*;

class LevelOrder {
    static class Node {
        int val;
        Node left, right;
        Node(int v) { val = v; }
    }

    static void levelOrder(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node curr = q.poll();
            System.out.print(curr.val + " ");

            if (curr.left != null) q.add(curr.left);
            if (curr.right != null) q.add(curr.right);
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        levelOrder(root); // 1 2 3
    }
}
