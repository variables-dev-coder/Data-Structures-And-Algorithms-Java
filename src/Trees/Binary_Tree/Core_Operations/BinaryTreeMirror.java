package Trees.Binary_Tree.Core_Operations;

/*
Mirror / Invert Binary Tree
Definition:
Mirror (or invert) a binary tree = swap left and right child pointers of every node.
 */

public class BinaryTreeMirror {
    static class Node6 {
        int data;
        Node6 left, right;

        Node6(int data) {
            this.data = data;
        }
    }

    Node6 root;

    // Mirror function (recursive)
    public Node6 mirror(Node6 node) {
        if (node == null) return null;

        // Swap left and right
        Node6 temp = node.left;
        node.left = node.right;
        node.right = temp;

        // Recurse on children
        mirror(node.left);
        mirror(node.right);

        return node;
    }

    // Inorder traversal
    public void inorder(Node6 node) {
        if (node == null) return;
        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }

    public static void main(String[] args) {
        BinaryTreeMirror tree = new BinaryTreeMirror();

        // Build tree manually
        tree.root = new Node6(10);
        tree.root.left = new Node6(20);
        tree.root.right = new Node6(30);
        tree.root.left.left = new Node6(40);
        tree.root.left.right = new Node6(50);

        System.out.println("Inorder before mirror:");
        tree.inorder(tree.root); // 40 20 50 10 30

        tree.mirror(tree.root);

        System.out.println("\nInorder after mirror:");
        tree.inorder(tree.root); // 30 10 50 20 40
    }
}

/*
Inorder before mirror:
40 20 50 10 30
Inorder after mirror:
30 10 50 20 40
 */