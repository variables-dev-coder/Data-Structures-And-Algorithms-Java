package Trees.Binary_Tree.Revision_5_Types;

class Node5 {
    int data;
    Node5 left, right;
    Node5(int data) {
        this.data = data;
    }
}

public class SkewedBinaryTree {
    static boolean isSkewed(Node5 root) {
        while (root != null) {
            if (root.left != null && root.right != null) return false;
            root = (root.left != null) ? root.left : root.right;
        }
        return true;
    }

    public static void main(String[] args) {
        Node5 root = new Node5(1);
        root.right = new Node5(2);
        root.right.right = new Node5(3);
        root.right.right.right = new Node5(4);

        System.out.println("Is Skewed Binary Tree? " + isSkewed(root));
    }
}

//Is Skewed Binary Tree? true