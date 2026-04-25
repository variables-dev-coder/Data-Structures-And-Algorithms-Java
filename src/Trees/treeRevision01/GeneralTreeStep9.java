package Trees.treeRevision01;

import java.util.*;

public class GeneralTreeStep9 {

    static class Node {
        int val;
        List<Node> children;

        Node(int val) {
            this.val = val;
            this.children = new ArrayList<>();
        }
    }

    public static Node lca(Node root, int p, int q) {
        if (root == null) return null;

        // if match found
        if (root.val == p || root.val == q) {
            return root;
        }

        int count = 0;
        Node temp = null;

        for (Node child : root.children) {
            Node res = lca(child, p, q);

            if (res != null) {
                count++;
                temp = res;
            }
        }

        // if found in 2 subtrees → current is LCA
        if (count >= 2) return root;

        // else return non-null child
        return temp;
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

        Node ans1 = lca(root, 5, 6);
        Node ans2 = lca(root, 5, 3);

        System.out.println("LCA of 5 & 6: " + (ans1 != null ? ans1.val : "null"));
        System.out.println("LCA of 5 & 3: " + (ans2 != null ? ans2.val : "null"));
    }
}
