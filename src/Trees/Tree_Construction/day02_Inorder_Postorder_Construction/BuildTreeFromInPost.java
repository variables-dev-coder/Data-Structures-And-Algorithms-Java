package Trees.Tree_Construction.day02_Inorder_Postorder_Construction;

import java.util.*;

public class BuildTreeFromInPost {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    static Map<Integer, Integer> inorderIndexMap;
    static int postIndex;

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        postIndex = postorder.length - 1;
        return build(inorder, postorder, 0, inorder.length - 1);
    }

    private static TreeNode build(int[] inorder, int[] postorder,
                                  int inStart, int inEnd) {

        if (inStart > inEnd) return null;

        int rootVal = postorder[postIndex--];
        TreeNode root = new TreeNode(rootVal);

        int rootIndex = inorderIndexMap.get(rootVal);

        // RIGHT subtree first
        root.right = build(inorder, postorder, rootIndex + 1, inEnd);
        root.left  = build(inorder, postorder, inStart, rootIndex - 1);

        return root;
    }

    // Verification
    public static void inorderPrint(TreeNode root) {
        if (root == null) return;
        inorderPrint(root.left);
        System.out.print(root.val + " ");
        inorderPrint(root.right);
    }

    public static void main(String[] args) {
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};

        TreeNode root = buildTree(inorder, postorder);

        System.out.print("Inorder of constructed tree: ");
        inorderPrint(root);
    }
}

// Inorder of constructed tree: 9 3 15 20 7 