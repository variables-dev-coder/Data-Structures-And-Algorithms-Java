package Trees.Binary_Tree.Revision_5_Types;



class Node4 {
    int data;
    Node4 left, right;
    Node4(int data) {
        this.data = data;
    }
}

public class BalancedBinaryTree {
    static int checkHeight(Node4 root) {
        if (root == null) return 0;
        int lh = checkHeight(root.left);
        if (lh == -1) return -1;
        int rh = checkHeight(root.right);
        if (rh == -1) return -1;

        if (Math.abs(lh - rh) > 1) return -1;
        return Math.max(lh, rh) + 1;
    }

    static boolean isBalanced(Node4 root) {
        return checkHeight(root) != -1;
    }

    public static void main(String[] args) {
        Node4 root = new Node4(1);
        root.left = new Node4(2);
        root.right = new Node4(3);
        root.left.left = new Node4(4);
        root.left.right = new Node4(5);

        System.out.println("Is Balanced Binary Tree? " + isBalanced(root));
    }
}


//Is Balanced Binary Tree? true