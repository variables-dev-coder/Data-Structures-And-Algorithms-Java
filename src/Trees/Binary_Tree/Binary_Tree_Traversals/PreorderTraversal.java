package Trees.Binary_Tree.Binary_Tree_Traversals;

// Preorder Traversal (DFS) – Root → Left → Right

class Node1 {
    int val;
    Node1 left, right;

    Node1(int v) {
        val = v;
        left = right = null;
    }
}

public class PreorderTraversal {
    static void preorder(Node1 root) {
        if (root == null) return;

        System.out.print(root.val + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args) {
        Node1 root = new Node1(1);
        root.left = new Node1(2);
        root.right = new Node1(3);
        root.left.left = new Node1(4);
        root.left.right = new Node1(5);

        System.out.print("Preorder: ");
        preorder(root); // Output: 1 2 4 5 3
    }
}

// Preorder: 1 2 4 5 3