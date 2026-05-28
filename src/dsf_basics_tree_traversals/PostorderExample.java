package dsf_basics_tree_traversals;

class Node3 {

    int data;
    Node3 left, right;

    Node3(int data) {
        this.data = data;
    }
}

public class PostorderExample {

    static void postorder(Node3 root) {

        if (root == null) {
            return;
        }

        // Go left
        postorder(root.left);

        // Go right
        postorder(root.right);

        // Print root last
        System.out.print(root.data + " ");
    }

    public static void main(String[] args) {

        Node3 root = new Node3(1);

        root.left = new Node3(2);
        root.right = new Node3(3);

        root.left.left = new Node3(4);
        root.left.right = new Node3(5);

        System.out.println("Postorder Traversal:");

        postorder(root);
    }
}
