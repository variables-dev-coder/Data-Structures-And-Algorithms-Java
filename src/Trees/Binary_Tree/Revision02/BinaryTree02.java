package Trees.Binary_Tree.Revision02;

public class BinaryTree02 {

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

    void inorder(Node node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        System.out.println(node.data + " ");
        inorder(node.right);
    }

    public static void main(String[] args) {
        BinaryTree02 tree = new BinaryTree02();

        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);


        System.out.println("Inorder traversal: ");
        tree.inorder(tree.root);
    }
}
