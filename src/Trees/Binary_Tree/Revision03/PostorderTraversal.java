package Trees.Binary_Tree.Revision03;

import java.util.*;

public class PostorderTraversal {
    public static List<Integer> postorder(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postorderHelper(root, list);
        return list;
    }

    private static void postorderHelper(TreeNode root, List<Integer> list) {
        if (root == null) return;
        postorderHelper(root.left, list);
        postorderHelper(root.right, list);
        list.add(root.val);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        System.out.println(postorder(root));
    }
}

// [2, 3, 1]