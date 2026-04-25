package Trees.treeRevision01;

import java.util.*;

public class GeneralTreeStep7 {

    static class Node {
        int val;
        List<Node> children;

        Node(int val) {
            this.val = val;
            this.children = new ArrayList<>();
        }
    }

    // Level-wise printing
    public static void printLevelWise(Node root) {
        if (root == null) return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        int level = 1;

        while (!queue.isEmpty()) {

            int size = queue.size();

            System.out.print("Level " + level + ": ");

            for (int i = 0; i < size; i++) {

                Node curr = queue.poll();
                System.out.print(curr.val + " ");

                for (Node child : curr.children) {
                    queue.add(child);
                }
            }

            System.out.println();
            level++;
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

        printLevelWise(root);
    }
}
