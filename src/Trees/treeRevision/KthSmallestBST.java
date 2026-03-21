package Trees.treeRevision;

class KthSmallestBST {

    static class Node {
        int val;
        Node left, right;

        Node(int v) {
            val = v;
        }
    }

    static int count = 0;
    static int result = -1;

    // Inorder traversal
    static void inorder(Node root, int k) {

        if (root == null) return;

        inorder(root.left, k);

        count++;
        if (count == k) {
            result = root.val;
            return;
        }

        inorder(root.right, k);
    }

    static int kthSmallest(Node root, int k) {
        count = 0;
        result = -1;
        inorder(root, k);
        return result;
    }

    // Helper: insert into BST
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

        int[] values = {5, 3, 7, 2, 4};

        for (int v : values) {
            root = insert(root, v);
        }

        int k = 3;

        System.out.println("Kth smallest: " + kthSmallest(root, k)); // 4
    }
}
