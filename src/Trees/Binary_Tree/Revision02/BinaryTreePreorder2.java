package Trees.Binary_Tree.Revision02;

public class BinaryTreePreorder2 {

    static class Node {
        int data;
        Node left, right;

        Node (int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    Node root;

    void preorder(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.data + " ");
        preorder(node.left);
        preorder(node.right);
    }

    public static void main(String[] args) {
        BinaryTreePreorder2 tree = new BinaryTreePreorder2();

        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.println("Preorder Traverse: ");
        tree.preorder(tree.root);
    }
}
