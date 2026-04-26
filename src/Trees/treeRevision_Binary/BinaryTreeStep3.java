package Trees.treeRevision_Binary;

import java.util.*;

public class BinaryTreeStep3 {

    static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
        }
    }

    // Level Order Traversal (BFS)
    public static void levelOrder(Node root) {
        if (root == null) return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            Node curr = queue.poll();
            System.out.print(curr.val + " ");

            if (curr.left != null) queue.add(curr.left);
            if (curr.right != null) queue.add(curr.right);
        }
    }

    public static void main(String[] args) {

        /*
                1
               / \
              2   3
             / \
            4   5
        */

        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        System.out.print("Level Order: ");
        levelOrder(root);
    }
}
