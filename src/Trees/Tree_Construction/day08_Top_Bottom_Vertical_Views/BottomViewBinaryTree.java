package Trees.Tree_Construction.day08_Top_Bottom_Vertical_Views;

import java.util.*;

public class BottomViewBinaryTree {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int v) { val = v; }
    }

    static class Pair {
        TreeNode node;
        int hd;
        Pair(TreeNode n, int h) { node = n; hd = h; }
    }

    public static List<Integer> bottomView(TreeNode root) {
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();

        q.offer(new Pair(root, 0));

        while (!q.isEmpty()) {
            Pair p = q.poll();

            // overwrite every time
            map.put(p.hd, p.node.val);

            if (p.node.left != null)
                q.offer(new Pair(p.node.left, p.hd - 1));
            if (p.node.right != null)
                q.offer(new Pair(p.node.right, p.hd + 1));
        }
        return new ArrayList<>(map.values());
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

