package Trees.Binary_Tree.Revision02;

public class BinaryTree01 {

    // Node class
    static class Node03 {
        int data;
        Node03 left, right;

        Node03 (int data) {
            this.data = data;
            left = right = null;
        }
    }

    Node03 root;  // root of the tree

    // Inorder Traversal : left -> root -> right

    void inorder(Node03 node) {
        if (node == null) {
            return;
        }
        inorder(node.left);                       // Step 1: Visit left subtree
        System.out.println(node.data + " ");      // Step 2: Visit root
        inorder(node.right);                      // Step 3: Visit right subtree
    }

    public static void main(String[] args) {
        BinaryTree01 tree = new BinaryTree01();

        // Create sample tree
        /*
                 1
               /   \
              2     3
             / \
            4   5
        */

        tree.root = new Node03(1);
        tree.root.left = new Node03(2);
        tree.root.right = new Node03(3);
        tree.root.left.left = new Node03(4);
        tree.root.left.right = new Node03(5);

        // Perform inorder traversal
        System.out.println("Inorder Traversal:");
        tree.inorder(tree.root); // Expected Output: 4 2 5 1 3
    }
}
