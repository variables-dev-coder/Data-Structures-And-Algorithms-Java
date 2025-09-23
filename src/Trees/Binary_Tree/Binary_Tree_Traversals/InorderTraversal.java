package Trees.Binary_Tree.Binary_Tree_Traversals;


class Node2 {
    int val;
    Node2 left, right;

    Node2(int v) {
        val = v;
        left = right = null;
    }
}

public class InorderTraversal {
    static void inorder(Node2 root) {
        if (root == null) return;

        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        Node2 root = new Node2(1);
        root.left = new Node2(2);
        root.right = new Node2(3);
        root.left.left = new Node2(4);
        root.left.right = new Node2(5);

        System.out.print("Inorder: ");
        inorder(root); // Output: 4 2 5 1 3
    }
}

// Inorder: 4 2 5 1 3