package Trees.Tree_Construction.day03_Sorted_Data_Balanced_BST;

public class SortedArrayToBalancedBST {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }

    // Core logic
    public static TreeNode sortedArrayToBST(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    private static TreeNode build(int[] arr, int start, int end) {
        if (start > end) return null;

        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(arr[mid]);

        root.left = build(arr, start, mid - 1);
        root.right = build(arr, mid + 1, end);

        return root;
    }

    // Verification
    public static void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        int[] nums = {-10, -3, 0, 5, 9};

        TreeNode root = sortedArrayToBST(nums);

        System.out.print("Inorder Traversal: ");
        inorder(root);
    }
}

