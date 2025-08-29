package Trees.Binary_Tree.Day01_Full_Binary_Tree;


class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class FullBinaryTreeExample {
    // Function to check if a tree is a Full Binary Tree
    public static boolean isFullBinaryTree(Node root) {
        if (root == null) {
            return true; // empty tree is full
        }

        // If leaf node → valid
        if (root.left == null && root.right == null) {
            return true;
        }

        // If both children exist → check recursively
        if (root.left != null && root.right != null) {
            return isFullBinaryTree(root.left) && isFullBinaryTree(root.right);
        }

        // If one child missing → not full
        return false;
    }

    public static void main(String[] args) {
        // Example of Full Binary Tree
        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        root1.left.left = new Node(4);
        root1.left.right = new Node(5);
        root1.right.left = new Node(6);
        root1.right.right = new Node(7);

        System.out.println("Tree 1 is Full? " + isFullBinaryTree(root1)); // true

        // Example of NOT a Full Binary Tree
        Node root2 = new Node(1);
        root2.left = new Node(2); // only left child
        root2.right = new Node(3);

        System.out.println("Tree 2 is Full? " + isFullBinaryTree(root2)); // false
    }

}

//Tree 1 is Full? true
//Tree 2 is Full? false