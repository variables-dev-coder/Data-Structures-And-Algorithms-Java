package Trees.Binary_Search_Tree_BST.day11_BST_based_Problems;


class Node2 {
    int val;
    Node2 left, right;

    Node2(int val) {
        this.val = val;
    }
}

public class TrimBST {

    static Node2 trimBST(Node2 root, int L, int R) {
        if (root == null) return null;

        if (root.val < L)
            return trimBST(root.right, L, R);

        if (root.val > R)
            return trimBST(root.left, L, R);

        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
        return root;
    }

    static void inorder(Node2 root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        Node2 root = new Node2(50);
        root.left = new Node2(30);
        root.right = new Node2(70);
        root.left.left = new Node2(20);
        root.left.right = new Node2(40);

        root = trimBST(root, 30, 60);
        inorder(root); // Output: 30 40 50
    }
}
