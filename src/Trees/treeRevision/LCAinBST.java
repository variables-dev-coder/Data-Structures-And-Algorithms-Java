package Trees.treeRevision;

public class LCAinBST {

    static class Node {
        int val;
        Node left, right;

        Node(int v) {
            val = v;
        }
    }

    static Node lca(Node root, int p, int q) {

        while (root != null) {

            if (p < root.val && q < root.val) {
                root = root.left;
            }
            else if (p > root.val && q > root.val) {
                root = root.right;
            }
            else {
                return root; // LCA found
            }
        }

        return null;
    }

    // Insert helper
    static Node insert(Node root, int val) {
        if (root == null) return new Node(val);

        if (val < root.val)
            root.left = insert(root.left, val);
        else
            root.right = insert(root.right, val);

        return root;
    }

    public static void main(String[] args) {

        Node root = null;

        int[] values = {6, 2, 8, 0, 4, 3, 5};

        for (int v : values) {
            root = insert(root, v);
        }

        Node ans = lca(root, 3, 5);

        System.out.println("LCA: " + ans.val); // Output: 4
    }
}
