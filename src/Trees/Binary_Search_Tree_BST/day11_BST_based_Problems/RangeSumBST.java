package Trees.Binary_Search_Tree_BST.day11_BST_based_Problems;

class Node1 {
    int val;
    Node1 left, right;

    Node1(int val) {
        this.val = val;
    }
}

public class RangeSumBST {

    static int rangeSum(Node1 root, int L, int R) {
        if (root == null) return 0;

        if (root.val < L)
            return rangeSum(root.right, L, R);

        if (root.val > R)
            return rangeSum(root.left, L, R);

        return root.val
                + rangeSum(root.left, L, R)
                + rangeSum(root.right, L, R);
    }

    public static void main(String[] args) {
        
        Node1 root = new Node1(50);
        root.left = new Node1(30);
        root.right = new Node1(70);
        root.left.left = new Node1(20);
        root.left.right = new Node1(40);
        root.right.left = new Node1(60);
        root.right.right = new Node1(80);

        System.out.println(rangeSum(root, 30, 70)); // Output: 250
    }
}
