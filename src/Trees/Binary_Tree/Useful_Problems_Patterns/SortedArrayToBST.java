package Trees.Binary_Tree.Useful_Problems_Patterns;

/*
You’re given a sorted array (ascending order).
Convert it into a height-balanced Binary Search Tree (BST).

Height-balanced means:
the left and right subtrees of every node differ in height by at most 1.

Example
Input: nums = [-10, -3, 0, 5, 9]

Output (Balanced BST):

        0
       / \
    -10   5
      \     \
      -3     9
Inorder Traversal: [-10, -3, 0, 5, 9]
Tree is balanced.

Approach — Divide & Conquer (Recursive)
Idea:
    The middle element of the array becomes the root.
    Elements before mid → left subtree.
    Elements after mid → right subtree.

This ensures:
    Left subtree has smaller values.
    Right subtree has larger values.
    Balanced height due to middle pivot.

 */

class TreeNode8 {
    int val;
    TreeNode8 left, right;

    TreeNode8(int val) {
        this.val = val;
    }
}

public class SortedArrayToBST {

    public TreeNode8 sortedArrayToBST(int[] nums) {
        return buildBST(nums, 0, nums.length - 1);
    }

    private TreeNode8 buildBST(int[] nums, int left, int right) {
        if (left > right) return null;

        int mid = left + (right - left) / 2;
        TreeNode8 root = new TreeNode8(nums[mid]);

        root.left = buildBST(nums, left, mid - 1);
        root.right = buildBST(nums, mid + 1, right);

        return root;
    }

    // Helper to print inorder traversal (to verify sorted order)
    public void inorder(TreeNode8 root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        int[] nums = {-10, -3, 0, 5, 9};
        SortedArrayToBST converter = new SortedArrayToBST();

        TreeNode8 root = converter.sortedArrayToBST(nums);

        System.out.print("Inorder Traversal of BST: ");
        converter.inorder(root); // should print sorted array
    }
}

// Output
// Inorder Traversal of BST: -10 -3 0 5 9

/*
Dry Run

nums = [-10, -3, 0, 5, 9]

Step 1: mid = 2 → root = 0
        left → [-10, -3]
        right → [5, 9]

Step 2: Left side (-10, -3)
        mid = 0 → root.left = -10
        right of -10 → -3

Step 3: Right side (5, 9)
        mid = 3 → root.right = 5
        right of 5 → 9

Final Tree:
        0
       / \
    -10   5
      \     \
      -3     9

Complexity

| Operation | Time | Space                      |
| --------- | ---- | -------------------------- |
| Build BST | O(n) | O(log n) (recursion stack) |


Key Insight
    This pattern teaches:
    Divide & Conquer structure
    Recursion on subarrays
    Maintaining balance property in BSTs

You’ll reuse this pattern in:
    Balanced tree problems (AVL, Segment Trees)
    Binary Search–based recursion problems
    Median or midpoint–based divide strategies
    
 */