package revision7;

import java.util.*;

class Node12 {
    int data;
    Node12 left, right;

    Node12(int data) {
        this.data = data;
    }
}

class Pair {
    Node12 node;
    int hd;

    Pair(Node12 node, int hd) {
        this.node = node;
        this.hd = hd;
    }
}

public class TopViewTree {

    static void topView(Node12 root) {

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

        Node12 root = new Node12(1);

        root.left = new Node12(2);
        root.right = new Node12(3);

        root.left.left = new Node12(4);
        root.left.right = new Node12(5);

        topView(root);
    }
}
