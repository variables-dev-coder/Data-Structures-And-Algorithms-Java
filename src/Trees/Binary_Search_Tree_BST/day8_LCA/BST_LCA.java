package Trees.Binary_Search_Tree_BST.day8_LCA;


class Node {
    int val;
    Node left, right;
    Node(int v) {
        val = v;
    }
}

public class BST_LCA {

    // Insert helper
    Node insert(Node root, int val) {
        if (root == null) return new Node(val);

        if (val < root.val) root.left = insert(root.left, val);
        else root.right = insert(root.right, val);

        return root;
    }

    // LCA function (BST property)
    Node lowestCommonAncestor(Node root, int p, int q) {
        while (root != null) {
            if (p < root.val && q < root.val) {
                root = root.left; // go left
            } else if (p > root.val && q > root.val) {
                root = root.right; // go right
            } else {
                return root; // split → LCA found
            }
        }
        return null;
    }

    public static void main(String[] args) {
        BST_LCA bst = new BST_LCA();
        Node root = null;

        int[] arr = {20, 10, 5, 15, 30, 25, 35};
        for (int x : arr) root = bst.insert(root, x);

        Node ans = bst.lowestCommonAncestor(root, 5, 15);
        System.out.println("LCA = " + ans.val);
    }
}
