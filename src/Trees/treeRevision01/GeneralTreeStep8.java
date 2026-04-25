package Trees.treeRevision01;

import java.util.*;

public class GeneralTreeStep8 {

    static class Node {
        int val;
        List<Node> children;

        Node(int val) {
            this.val = val;
            this.children = new ArrayList<>();
        }
    }

    static int diameter = 0;

    // Function to calculate height and update diameter
    public static int height(Node root) {
        if (root == null) return 0;

        int max1 = 0, max2 = 0;

        for (Node child : root.children) {

            int h = height(child);

            // find top two heights
            if (h > max1) {
                max2 = max1;
                max1 = h;
            } else if (h > max2) {
                max2 = h;
            }
        }

        // update diameter
        diameter = Math.max(diameter, max1 + max2 + 1);

        return max1 + 1;
    }

    public static int findDiameter(Node root) {
        diameter = 0;
        height(root);
        return diameter;
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

        int d = findDiameter(root);

        System.out.println("Diameter of Tree: " + d);
    }
}
