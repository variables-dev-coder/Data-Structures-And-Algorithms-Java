package Trees.Binary_Tree_Views_Properties.day08_TopBottomVerticalViews;

import java.util.*;

public class BottomViewBinaryTree {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    static class Pair {
        TreeNode node;
        int hd;
        Pair(TreeNode n, int h) { node = n; hd = h; }
    }

    public static List<Integer> bottomView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));

        while (!q.isEmpty()) {
            Pair p = q.poll();

            // overwrite for bottom-most node
            map.put(p.hd, p.node.val);

            if (p.node.left != null)
                q.offer(new Pair(p.node.left, p.hd - 1));
            if (p.node.right != null)
                q.offer(new Pair(p.node.right, p.hd + 1));
        }

        result.addAll(map.values());
        return result;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.left.right.right = new TreeNode(7);

        System.out.println("Bottom View: " + bottomView(root));
    }
}

// Bottom View: [4, 2, 5, 7, 6]