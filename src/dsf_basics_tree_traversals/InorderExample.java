package dsf_basics_tree_traversals;

class Node2 {

    int data;
    Node2 left, right;

    Node2(int data) {
        this.data = data;
    }
}

public class InorderExample {

    static void inorder(Node2 root) {

        if (root == null) {
            return;
        }

        // Go left first
        inorder(root.left);

        // Print root
        System.out.print(root.data + " ");

        // Go right
        inorder(root.right);
    }

    public static void main(String[] args) {

        Node2 root = new Node2(1);

        root.left = new Node2(2);
        root.right = new Node2(3);

        root.left.left = new Node2(4);
        root.left.right = new Node2(5);

        System.out.println("Inorder Traversal:");

        inorder(root);
    }
}
