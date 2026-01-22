package Trees.Binary_Search_Tree_BST.revision2;

// BSTProblems.java
public class BSTProblems {

    // 1. Range Sum of BST
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) return 0;

        if (root.val < low) {
            return rangeSumBST(root.right, low, high);
        } else if (root.val > high) {
            return rangeSumBST(root.left, low, high);
        } else {
            return root.val +
                    rangeSumBST(root.left, low, high) +
                    rangeSumBST(root.right, low, high);
        }
    }

    // 2. Convert Sorted Array to BST
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBSTRec(nums, 0, nums.length - 1);
    }

    private TreeNode sortedArrayToBSTRec(int[] nums, int left, int right) {
        if (left > right) return null;

        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);

        root.left = sortedArrayToBSTRec(nums, left, mid - 1);
        root.right = sortedArrayToBSTRec(nums, mid + 1, right);

        return root;
    }

    // 3. Find Mode (Most frequent element) in BST
    public int[] findMode(TreeNode root) {
        if (root == null) return new int[0];

        java.util.List<Integer> modes = new java.util.ArrayList<>();
        int[] current = new int[2]; // [currentValue, currentCount]
        int[] max = new int[1]; // maxCount
        int[] prev = new int[1]; // previous value
        prev[0] = Integer.MIN_VALUE;

        inorderMode(root, modes, current, max, prev);

        // Convert list to array
        int[] result = new int[modes.size()];
        for (int i = 0; i < modes.size(); i++) {
            result[i] = modes.get(i);
        }
        return result;
    }

    private void inorderMode(TreeNode root, java.util.List<Integer> modes,
                             int[] current, int[] max, int[] prev) {
        if (root == null) return;

        inorderMode(root.left, modes, current, max, prev);

        if (root.val == prev[0]) {
            current[1]++;
        } else {
            current[0] = root.val;
            current[1] = 1;
        }

        if (current[1] > max[0]) {
            max[0] = current[1];
            modes.clear();
            modes.add(root.val);
        } else if (current[1] == max[0]) {
            modes.add(root.val);
        }

        prev[0] = root.val;

        inorderMode(root.right, modes, current, max, prev);
    }

    // 4. BST to Greater Sum Tree
    public TreeNode convertBST(TreeNode root) {
        int[] sum = new int[1];
        convertBSTRec(root, sum);
        return root;
    }

    private void convertBSTRec(TreeNode root, int[] sum) {
        if (root == null) return;

        // Traverse right subtree first (reverse inorder)
        convertBSTRec(root.right, sum);

        // Update current node
        sum[0] += root.val;
        root.val = sum[0];

        // Traverse left subtree
        convertBSTRec(root.left, sum);
    }

    // 5. Validate BST
    public boolean isValidBST(TreeNode root) {
        return isValidBSTRec(root, null, null);
    }

    private boolean isValidBSTRec(TreeNode root, Integer min, Integer max) {
        if (root == null) return true;

        if ((min != null && root.val <= min) || (max != null && root.val >= max)) {
            return false;
        }

        return isValidBSTRec(root.left, min, root.val) &&
                isValidBSTRec(root.right, root.val, max);
    }

    // 6. Recover BST (Two nodes swapped)
    public void recoverTree(TreeNode root) {
        TreeNode[] first = new TreeNode[1];
        TreeNode[] second = new TreeNode[1];
        TreeNode[] prev = new TreeNode[1];

        inorderRecover(root, first, second, prev);

        // Swap the values of the two nodes
        int temp = first[0].val;
        first[0].val = second[0].val;
        second[0].val = temp;
    }

    private void inorderRecover(TreeNode root, TreeNode[] first,
                                TreeNode[] second, TreeNode[] prev) {
        if (root == null) return;

        inorderRecover(root.left, first, second, prev);

        if (prev[0] != null && prev[0].val > root.val) {
            if (first[0] == null) {
                first[0] = prev[0];
            }
            second[0] = root;
        }
        prev[0] = root;

        inorderRecover(root.right, first, second, prev);
    }

    // Main method to test all problems
    public static void main(String[] args) {
        BSTProblems problems = new BSTProblems();

        System.out.println("=== COMMON BST PROBLEMS ===\n");

        // Problem 1: Range Sum
        TreeNode root1 = new TreeNode(10);
        root1.left = new TreeNode(5);
        root1.right = new TreeNode(15);
        root1.left.left = new TreeNode(3);
        root1.left.right = new TreeNode(7);
        root1.right.right = new TreeNode(18);

        int sum = problems.rangeSumBST(root1, 7, 15);
        System.out.println("1. Range Sum [7, 15]: " + sum + " (Expected: 32)");

        // Problem 2: Sorted Array to BST
        int[] sortedArray = {-10, -3, 0, 5, 9};
        TreeNode root2 = problems.sortedArrayToBST(sortedArray);
        System.out.println("\n2. Sorted Array to BST created");
        System.out.print("   Inorder traversal: ");
        inorderPrint(root2);

        // Problem 3: Find Mode
        TreeNode root3 = new TreeNode(1);
        root3.right = new TreeNode(2);
        root3.right.left = new TreeNode(2);
        int[] modes = problems.findMode(root3);
        System.out.println("\n3. Mode(s) in BST: " + java.util.Arrays.toString(modes));

        // Problem 4: Convert to Greater Sum Tree
        TreeNode root4 = new TreeNode(4);
        root4.left = new TreeNode(1);
        root4.right = new TreeNode(6);
        root4.left.left = new TreeNode(0);
        root4.left.right = new TreeNode(2);
        root4.left.right.right = new TreeNode(3);
        root4.right.left = new TreeNode(5);
        root4.right.right = new TreeNode(7);
        root4.right.right.right = new TreeNode(8);

        System.out.println("\n4. Convert BST to Greater Sum Tree:");
        System.out.print("   Original inorder: ");
        inorderPrint(root4);
        TreeNode result = problems.convertBST(root4);
        System.out.print("   After conversion: ");
        inorderPrint(result);

        // Problem 5: Validate BST
        TreeNode validBST = new TreeNode(2);
        validBST.left = new TreeNode(1);
        validBST.right = new TreeNode(3);

        TreeNode invalidBST = new TreeNode(5);
        invalidBST.left = new TreeNode(1);
        invalidBST.right = new TreeNode(4);
        invalidBST.right.left = new TreeNode(3);
        invalidBST.right.right = new TreeNode(6);

        System.out.println("\n5. Validate BST:");
        System.out.println("   Valid BST: " + problems.isValidBST(validBST));
        System.out.println("   Invalid BST: " + problems.isValidBST(invalidBST));
    }

    private static void inorderPrint(TreeNode root) {
        if (root == null) return;
        inorderPrint(root.left);
        System.out.print(root.val + " ");
        inorderPrint(root.right);
        System.out.println();
    }
}
