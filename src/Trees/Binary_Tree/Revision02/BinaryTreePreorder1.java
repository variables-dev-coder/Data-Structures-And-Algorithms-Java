package Trees.Binary_Tree.Revision02;

public class BinaryTreePreorder1 {

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

    // Preorder Traversal
    void preorder(Node node) {
        if (node == null ) {
            return;
        }
        System.out.println(node.data + " ");  // Step 1: Visit root
        preorder(node.left);                   // Step 2: Visit left subtree
        preorder(node.right);                   // Step 3: Visit right subtree
    }

    public static void main(String[] args) {
        BinaryTreePreorder1 tree = new BinaryTreePreorder1();

        /*
                 1
               /   \
              2     3
             / \
            4   5
        */

        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.println("Preorder Traverse: ");
        tree.preorder(tree.root);  // // Expected Output: 1 2 4 5 3
    }
}
