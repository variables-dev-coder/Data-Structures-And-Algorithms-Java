package Trees.Tree_Construction.day03_Sorted_Data_Balanced_BST;

public class SortedArrayToBST {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int v) { val = v; }
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    private static TreeNode build(int[] a, int l, int r) {
        if (l > r) return null;
        int mid = l + (r - l) / 2; // avoid overflow
        TreeNode root = new TreeNode(a[mid]);
        root.left = build(a, l, mid - 1);
        root.right = build(a, mid + 1, r);
        return root;
    }

    // verify with inorder (should be sorted)
    static void inorder(TreeNode n) {
        if (n == null) return;
        inorder(n.left);
        System.out.print(n.val + " ");
        inorder(n.right);
    }

    public static void main(String[] args) {
        int[] nums = {-10, -3, 0, 5, 9};
        TreeNode root = sortedArrayToBST(nums);
        inorder(root); // -10 -3 0 5 9
    }
}

