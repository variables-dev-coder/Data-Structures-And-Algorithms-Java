package Trees.treeRevision;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class TopViewTree {

    static class Node {
        int val;
        Node left, right;
        Node(int v) { val = v; }
    }

    static class Pair {
        Node node;
        int hd;
        Pair(Node n, int h) { node = n; hd = h; }
    }

    static void topView(Node root) {

        Queue<Pair> q = new LinkedList<>();
        Map<Integer, Integer> map = new TreeMap<>();

        q.add(new Pair(root, 0));

        while (!q.isEmpty()) {

            Pair curr = q.poll();

            if (!map.containsKey(curr.hd)) {
                map.put(curr.hd, curr.node.val);
            }

            if (curr.node.left != null)
                q.add(new Pair(curr.node.left, curr.hd - 1));

            if (curr.node.right != null)
                q.add(new Pair(curr.node.right, curr.hd + 1));
        }

        for (int val : map.values()) {
            System.out.print(val + " ");
        }
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.right.right = new Node(5);

        topView(root); // 4 2 1 3 5
    }
}
