package Trees.treeRevision;

import java.util.*;

public class ZigzagTraversal {

    static class Node {
        int val;
        Node left, right;

        Node(int v) {
            val = v;
        }
    }

    static List<List<Integer>> zigzag(Node root) {

        List<List<Integer>> result = new ArrayList<>();

        if (root == null) return result;

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        boolean leftToRight = true;

        while (!q.isEmpty()) {

            int size = q.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {

                Node curr = q.poll();

                level.add(curr.val);

                if (curr.left != null) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);
            }

            // reverse if needed
            if (!leftToRight) {
                Collections.reverse(level);
            }

            result.add(level);

            leftToRight = !leftToRight; // toggle direction
        }

        return result;
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        List<List<Integer>> ans = zigzag(root);

        System.out.println(ans);
    }
}
