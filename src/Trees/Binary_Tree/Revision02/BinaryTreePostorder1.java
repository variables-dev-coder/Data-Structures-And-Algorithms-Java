package Trees.Binary_Tree.Revision02;

public class BinaryTreePostorder1 {

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

    // Postorder Traversal (Left → Right → Root)
    void postorder(Node node) {
        if (node == null) {
            return;
        }
        postorder(node.left);   // Step 1: Left
        postorder(node.right);  // Step 2: Right
        System.out.println(node.data + " ");  // Step 3: Root
    }

    public static void main(String[] args) {
        BinaryTreePostorder1 tree = new BinaryTreePostorder1();

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

        System.out.println("Postorder Traverse: ");
        tree.postorder(tree.root);  // 4, 5, 2, 3, 1
    }
}
