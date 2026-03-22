package Trees.treeRevision;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class BottomViewTree {

    static class Node {
        int val;
        Node left, right;

        Node(int v) {
            val = v;
        }
    }

    static class Pair {
        Node node;
        int hd;

        Pair(Node n, int h) {
            node = n;
            hd = h;
        }
    }

    static void bottomView(Node root) {

        if (root == null) return;

        Queue<Pair> q = new LinkedList<>();
        Map<Integer, Integer> map = new TreeMap<>();

        q.add(new Pair(root, 0));

        while (!q.isEmpty()) {

            Pair curr = q.poll();

            // overwrite (important)
            map.put(curr.hd, curr.node.val);

            if (curr.node.left != null) {
                q.add(new Pair(curr.node.left, curr.hd - 1));
            }

            if (curr.node.right != null) {
                q.add(new Pair(curr.node.right, curr.hd + 1));
            }
        }

        // print result
        for (int val : map.values()) {
            System.out.print(val + " ");
        }
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.left.right.right = new Node(6);

        System.out.print("Bottom View: ");
        bottomView(root); // 4 2 5 6
    }
}
