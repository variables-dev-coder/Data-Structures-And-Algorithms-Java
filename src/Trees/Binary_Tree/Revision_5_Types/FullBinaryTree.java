package Trees.Binary_Tree.Revision_5_Types;


class Node {
    int data;
    Node left, right;
    Node(int data) {
        this.data = data;
    }
}

public class FullBinaryTree {
    static boolean isFull(Node root) {
        if (root == null) return true;
        if (root.left == null && root.right == null) return true;
        if (root.left != null && root.right != null)
            return isFull(root.left) && isFull(root.right);
        return false;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(5);

        System.out.println("Is Full Binary Tree? " + isFull(root));
    }

}


//Is Full Binary Tree? true