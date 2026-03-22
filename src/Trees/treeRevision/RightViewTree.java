package Trees.treeRevision;

import java.util.LinkedList;
import java.util.Queue;

public class RightViewTree {

    static class Node {
        int val;
        Node left, right;
        Node(int v) { val = v; }
    }

    static void rightView(Node root) {

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {

            int size = q.size();

            for (int i = 0; i < size; i++) {

                Node curr = q.poll();

                if (i == size - 1) {
                    System.out.print(curr.val + " ");
                }

                if (curr.left != null) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);
            }
        }
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        root.right.right = new Node(4);

        rightView(root); // 1 3 4
    }
}
