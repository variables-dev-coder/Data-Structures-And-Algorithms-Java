package dsf_basics_tree_traversals;

class Node1 {

    int data;
    Node1 left, right;

    Node1(int data) {
        this.data = data;
    }
}

public class PreorderExample {

    static void preorder(Node1 root) {

        // Base condition
        if (root == null) {
            return;
        }

        // Print root first
        System.out.print(root.data + " ");

        // Go left
        preorder(root.left);

        // Go right
        preorder(root.right);
    }

    public static void main(String[] args) {

        Node1 root = new Node1(1);

        root.left = new Node1(2);
        root.right = new Node1(3);

        root.left.left = new Node1(4);
        root.left.right = new Node1(5);

        System.out.println("Preorder Traversal:");

        preorder(root);
    }
}
