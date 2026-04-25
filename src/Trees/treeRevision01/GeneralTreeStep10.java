package Trees.treeRevision01;

import java.util.*;

public class GeneralTreeStep10 {

    static class Node {
        int val;
        List<Node> children;

        Node(int val) {
            this.val = val;
            this.children = new ArrayList<>();
        }
    }

    // Check mirror
    public static boolean isMirror(Node n1, Node n2) {
        if (n1 == null && n2 == null) return true;
        if (n1 == null || n2 == null) return false;

        if (n1.val != n2.val) return false;

        int size1 = n1.children.size();
        int size2 = n2.children.size();

        if (size1 != size2) return false;

        for (int i = 0; i < size1; i++) {
            Node c1 = n1.children.get(i);
            Node c2 = n2.children.get(size2 - 1 - i);

            if (!isMirror(c1, c2)) {
                return false;
            }
        }

        return true;
    }

    // Check symmetric
    public static boolean isSymmetric(Node root) {
        if (root == null) return true;

        int n = root.children.size();

        for (int i = 0; i < n / 2; i++) {
            if (!isMirror(root.children.get(i), root.children.get(n - 1 - i))) {
                return false;
            }
        }

        // If odd number of children → check middle child
        if (n % 2 == 1) {
            return isSymmetric(root.children.get(n / 2));
        }

        return true;
    }

    public static void main(String[] args) {

        /*
            Symmetric Tree Example:
                    1
                 /     \
                2       2
              /   \   /   \
             3     4 4     3
        */

        Node root = new Node(1);

        Node left = new Node(2);
        Node right = new Node(2);

        root.children.add(left);
        root.children.add(right);

        left.children.add(new Node(3));
        left.children.add(new Node(4));

        right.children.add(new Node(4));
        right.children.add(new Node(3));

        System.out.println("Is Symmetric: " + isSymmetric(root));
    }
}
