package Trees.Binary_Tree_Views_Properties.day08_TopBottomVerticalViews;

import java.util.*;

public class VerticalOrderTraversal {

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

    public static List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Map<Integer, List<Integer>> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));

        while (!q.isEmpty()) {
            Pair p = q.poll();

            map.putIfAbsent(p.hd, new ArrayList<>());
            map.get(p.hd).add(p.node.val);

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

        System.out.println("Vertical Order: " + verticalOrder(root));
    }
}

// Vertical Order: [[4], [2], [1, 5], [3, 7], [6]]