package Trees.treeRevision;

import java.util.*;

class BinaryTreeNextLevel {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    // Level Order
    static void levelOrder(Node root) {

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node curr = q.poll();
            System.out.print(curr.data + " ");

            if (curr.left != null) q.add(curr.left);
            if (curr.right != null) q.add(curr.right);
        }
    }

    // Height
    static int height(Node root) {

        if (root == null) return 0;

        return 1 + Math.max(height(root.left), height(root.right));
    }

    // Diameter
    static int diameter = 0;

    static int findHeight(Node root) {

        if (root == null) return 0;

        int left = findHeight(root.left);
        int right = findHeight(root.right);

        diameter = Math.max(diameter, left + right);

        return 1 + Math.max(left, right);
    }

    public static void main(String[] args) {

        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        System.out.print("Level Order: ");
        levelOrder(root);

        System.out.println();

        System.out.println("Height: " + height(root));

        findHeight(root);
        System.out.println("Diameter: " + diameter);
    }
}
