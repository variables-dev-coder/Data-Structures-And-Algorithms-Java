package Trees.Binary_Tree.Representations;

// Traversal in Linked Representation

public class Traversal {
    static class Node {
        int data;
        Node left, right;
        Node(int data) {
            this.data = data;
        }
    }

    static void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);

        System.out.print("Inorder Traversal: ");
        inorder(root);
    }
}

//Inorder Traversal: 4 2 1 3