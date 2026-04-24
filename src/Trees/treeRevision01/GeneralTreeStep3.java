package Trees.treeRevision01;

import java.util.*;

public class GeneralTreeStep3 {

    static class Node {
        int val;
        List<Node> children;

        Node(int val) {
            this.val = val;
            this.children = new ArrayList<>();
        }
    }

    // BFS Traversal
    public static void bfs(Node root) {
        if (root == null) return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            Node curr = queue.poll();
            System.out.print(curr.val + " ");

            // add all children to queue
            for (Node child : curr.children) {
                queue.add(child);
            }
        }
    }

    public static void main(String[] args) {

        /*
            Tree Structure:
                    1
                  / | \
                 2  3  4
                / \
               5   6
        */

        Node root = new Node(1);

        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);

        root.children.add(n2);
        root.children.add(n3);
        root.children.add(n4);

        n2.children.add(new Node(5));
        n2.children.add(new Node(6));

        System.out.print("BFS Traversal: ");
        bfs(root);
    }
}
