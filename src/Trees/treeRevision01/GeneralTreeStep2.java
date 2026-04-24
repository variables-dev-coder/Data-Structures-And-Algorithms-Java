package Trees.treeRevision01;

import java.util.*;

public class GeneralTreeStep2 {

    // Node definition
    static class Node {
        int val;
        List<Node> children;

        Node(int val) {
            this.val = val;
            this.children = new ArrayList<>();
        }
    }

    // DFS Traversal
    public static void dfs(Node root) {
        if (root == null) return;

        // Visit node
        System.out.print(root.val + " ");

        // Visit all children
        for (Node child : root.children) {
            dfs(child);
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

        System.out.print("DFS Traversal: ");
        dfs(root);
    }
}
