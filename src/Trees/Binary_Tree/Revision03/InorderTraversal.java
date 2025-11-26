package Trees.Binary_Tree.Revision03;

import java.util.*;

public class InorderTraversal {
    public static List<Integer> inorder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderHelper(root, result);
        return result;
    }

    private static void inorderHelper(TreeNode root, List<Integer> list) {
        if (root == null) return;
        inorderHelper(root.left, list);
        list.add(root.val);
        inorderHelper(root.right, list);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(5);
        root.right = new TreeNode(3);

        System.out.println(inorder(root));
    }
}

// [5, 1, 3]