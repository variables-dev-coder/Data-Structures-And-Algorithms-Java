package Trees.Binary_Tree.Definition;



// BinaryTree.java
class Node {
    int val;
    Node left, right;

    Node(int v) {
        val = v;
        left = right = null;
    }
}

public class BinaryTree {
    // recursive preorder: root, left, right
    static void preorder(Node root) {
        if (root == null) return;

        System.out.print(root.val + " ");
        preorder(root.left);
        preorder(root.right);
    }

    // recursive inorder left -> root -> right
    static void inorder(Node root) {
        if (root == null) return;

        inorder(root.left);
        System.out.print(root.val + " ");
        preorder(root.right);
    }

    // recursive postorder left -> right -> root
    static void postorder(Node root) {
        if (root == null) return;

        postorder(root.left);
        inorder(root.right);
        System.out.print(root.val + " ");
    }

    public static void main(String[] args) {

        // build a small tree:
        //      1
        //     / \
        //    2   3
        //   /
        //  4

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);

        System.out.print("Preorder: ");
        preorder(root);              // expected output: 1 2 4 3
        System.out.println();

        System.out.print("Inorder: ");
        inorder(root);               // Inorder: 4 2 1 3
        System.out.println();

        System.out.print("Postorder: ");
        postorder(root);            // Postorder: 4 2 3 1
        System.out.println();
    }
}
