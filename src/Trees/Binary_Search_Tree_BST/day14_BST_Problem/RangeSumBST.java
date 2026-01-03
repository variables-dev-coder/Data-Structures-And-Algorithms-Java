package Trees.Binary_Search_Tree_BST.day14_BST_Problem;

class TreeNode3 {
    int val;
    TreeNode3 left, right;

    TreeNode3(int val) {
        this.val = val;
    }
}

public class RangeSumBST {

    public static int rangeSum(TreeNode3 root, int L, int R) {
        if (root == null) return 0;

        if (root.val < L)
            return rangeSum(root.right, L, R);

        if (root.val > R)
            return rangeSum(root.left, L, R);

        return root.val +
                rangeSum(root.left, L, R) +
                rangeSum(root.right, L, R);
    }

    public static void main(String[] args) {
        TreeNode3 root = new TreeNode3(50);
        root.left = new TreeNode3(30);
        root.right = new TreeNode3(70);
        root.right.left = new TreeNode3(60);

        System.out.println(rangeSum(root, 30, 70)); // 210
    }
}

