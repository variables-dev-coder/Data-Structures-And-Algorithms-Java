package Trees.Binary_Search_Tree_BST.day11_BST_based_Problems;


class Node5 {
    int val;
    Node5 left, right;

    Node5(int val) {
        this.val = val;
    }
}

public class KthSmallestBST {

    static int count = 0;
    static int result = -1;

    static void kthSmallest(Node5 root, int k) {
        if (root == null) return;

        kthSmallest(root.left, k);
        count++;

        if (count == k) {
            result = root.val;
            return;
        }

        kthSmallest(root.right, k);
    }

    public static void main(String[] args) {
        Node5 root = new Node5(40);
        root.left = new Node5(20);
        root.right = new Node5(60);
        root.left.left = new Node5(10);
        root.left.right = new Node5(30);

        kthSmallest(root, 3);
        System.out.println(result); // Output: 30
    }
}
