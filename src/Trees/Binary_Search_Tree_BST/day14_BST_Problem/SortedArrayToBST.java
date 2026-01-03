package Trees.Binary_Search_Tree_BST.day14_BST_Problem;

class TreeNode4 {
    int val;
    TreeNode4 left, right;

    TreeNode4(int val) {
        this.val = val;
    }
}

public class SortedArrayToBST {

    public static TreeNode4 sortedArrayToBST(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    private static TreeNode4 build(int[] nums, int l, int r) {
        if (l > r) return null;

        int mid = (l + r) / 2;
        TreeNode4 root = new TreeNode4(nums[mid]);

        root.left = build(nums, l, mid - 1);
        root.right = build(nums, mid + 1, r);

        return root;
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};
        TreeNode4 root = sortedArrayToBST(arr);

        System.out.println(root.val); // 30
    }
}

