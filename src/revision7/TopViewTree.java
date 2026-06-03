package revision7;

import java.util.*;

class Node50 {
    int data;
    Node50 left, right;

    Node50(int data) {
        this.data = data;
    }
}

class Pair {
    Node50 node;
    int hd;

    Pair(Node50 node, int hd) {
        this.node = node;
        this.hd = hd;
    }
}

public class TopViewTree {

    static void topView(Node50 root) {

        TreeMap<Integer, Integer> map =
                new TreeMap<>();

        Queue<Pair> queue =
                new LinkedList<>();

        queue.offer(new Pair(root, 0));

        while (!queue.isEmpty()) {

            Pair p = queue.poll();

            map.putIfAbsent(
                    p.hd,
                    p.node.data);

            if (p.node.left != null)
                queue.offer(
                        new Pair(
                                p.node.left,
                                p.hd - 1));

            if (p.node.right != null)
                queue.offer(
                        new Pair(
                                p.node.right,
                                p.hd + 1));
        }

        System.out.println(map.values());
    }

    public static void main(String[] args) {

        Node50 root = new Node50(1);

        root.left = new Node50(2);
        root.right = new Node50(3);

        root.left.left = new Node50(4);
        root.left.right = new Node50(5);

        topView(root);
    }
}
