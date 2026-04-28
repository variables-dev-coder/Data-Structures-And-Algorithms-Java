package Trees.treeRevision_Binary;

import java.util.*;

public class BinaryTreeStep7 {

    static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
        }
    }

    public static Node lca(Node root, int p, int q) {
        if (root == null) return null;

        // if match found
        if (root.val == p || root.val == q) {
            return root;
        }

        Node left = lca(root.left, p, q);
        Node right = lca(root.right, p, q);

        // if both sides return non-null → this is LCA
        if (left != null && right != null) {
            return root;
        }

        // otherwise return non-null side
        return (left != null) ? left : right;
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

        Node ans1 = lca(root, 4, 5);
        Node ans2 = lca(root, 4, 3);

        System.out.println("LCA of 4 & 5: " + ans1.val);
        System.out.println("LCA of 4 & 3: " + ans2.val);
    }
}
