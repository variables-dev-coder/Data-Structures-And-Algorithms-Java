package Trees.Binary_Tree.Revision02;

// Binary Tree Example

class Node01 {
    int data;
    Node01 left, right;

    Node01(int data) {
        this.data = data;
        left = right = null;
    }
}
 // Build example tree

public class BinaryTreeExample01 {
    Node01 root;

    public static void main(String[] args) {
        BinaryTreeExample01 tree = new BinaryTreeExample01();

        // created root
        tree.root = new Node01(1);
        tree.root.left = new Node01(2);
        tree.root.right = new Node01(3);
        tree.root.left.left = new Node01(4);
        tree.root.left.right = new Node01(5);

        System.out.println("Binary Tree Created Successfully");
    }

}
