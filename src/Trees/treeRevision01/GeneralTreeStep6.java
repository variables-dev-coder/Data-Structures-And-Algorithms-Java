package Trees.treeRevision01;

import java.util.*;

public class GeneralTreeStep6 {

    static class Node {
        int val;
        List<Node> children;

        Node(int val) {
            this.val = val;
            this.children = new ArrayList<>();
        }
    }

    // Function to search element
    public static boolean find(Node root, int target) {
        if (root == null) return false;

        // check current node
        if (root.val == target) return true;

        // check children
        for (Node child : root.children) {
            if (find(child, target)) {
                return true;
            }
        }

        return false;
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

        System.out.println("Find 6: " + find(root, 6));
        System.out.println("Find 10: " + find(root, 10));
    }
}
