package Trees.Binary_Search_Tree_BST.day11_BST_based_Problems;


class Node3 {
    int val;
    Node3 left, right;

    Node3(int val) {
        this.val = val;
    }
}

public class BSTToGST {

    static int sum = 0;

    static void convert(Node3 root) {
        if (root == null) return;

        convert(root.right);
        sum += root.val;
        root.val = sum;
        convert(root.left);
    }

    static void inorder(Node3 root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        Node3 root = new Node3(10);
        root.left = new Node3(5);
        root.right = new Node3(15);

        convert(root);
        inorder(root); // Output: 30 25 15
    }
}
