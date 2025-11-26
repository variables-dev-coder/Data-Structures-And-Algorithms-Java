package Trees.Binary_Tree.Revision03;

import java.util.*;

public class PreorderTraversal {
    public static List<Integer> preorder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorderHelper(root, result);
        return result;
    }

    private static void preorderHelper(TreeNode root, List<Integer> list) {
        if (root == null) return;
        list.add(root.val);
        preorderHelper(root.left, list);
        preorderHelper(root.right, list);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        System.out.println(preorder(root));
    }
}

// [1, 2, 3]