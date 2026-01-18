package Trees.Tree_Construction.day01_TreeConstructionBasics;

import java.util.*;

public class BuildTreeFromPreIn {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    static Map<Integer, Integer> inorderIndexMap;
    static int preIndex = 0;

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }
        preIndex = 0;
        return build(preorder, inorder, 0, inorder.length - 1);
    }

    private static TreeNode build(int[] preorder, int[] inorder,
                                  int inStart, int inEnd) {

        if (inStart > inEnd) return null;

        int rootVal = preorder[preIndex++];
        TreeNode root = new TreeNode(rootVal);

        int rootIndex = inorderIndexMap.get(rootVal);

        root.left = build(preorder, inorder, inStart, rootIndex - 1);
        root.right = build(preorder, inorder, rootIndex + 1, inEnd);

        return root;
    }

    // For verification
    public static void inorderPrint(TreeNode root) {
        if (root == null) return;
        inorderPrint(root.left);
        System.out.print(root.val + " ");
        inorderPrint(root.right);
    }

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        TreeNode root = buildTree(preorder, inorder);

        System.out.print("Inorder of constructed tree: ");
        inorderPrint(root);
    }
}

// Inorder of constructed tree: 9 3 15 20 7