package Trees.Binary_Search_Tree_BST.day14_BST_Problem;

class TreeNode5 {
    int val;
    TreeNode5 left, right;

    TreeNode5(int val) {
        this.val = val;
    }
}

public class KthSmallestBST {

    static int count = 0;
    static int result = -1;

    public static int kthSmallest(TreeNode5 root, int k) {
        inorder(root, k);
        return result;
    }

    private static void inorder(TreeNode5 node, int k) {
        if (node == null) return;

        inorder(node.left, k);

        count++;
        if (count == k) {
            result = node.val;
            return;
        }

        inorder(node.right, k);
    }

    public static void main(String[] args) {
        TreeNode5 root = new TreeNode5(50);
        root.left = new TreeNode5(30);
        root.right = new TreeNode5(70);
        root.left.left = new TreeNode5(20);
        root.left.right = new TreeNode5(40);

        System.out.println(kthSmallest(root, 3)); // 40
    }
}

