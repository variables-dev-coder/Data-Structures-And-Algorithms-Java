package revision7;

import java.util.*;

class Node14 {
    int data;
    Node50 left, right;

    Node14(int data) {
        this.data = data;
    }
}

class Pair3 {
    Node50 node;
    int hd;

    Pair3(Node50 node, int hd) {
        this.node = node;
        this.hd = hd;
    }
}

public class VerticalOrder {

    static void verticalOrder(Node50 root) {

        TreeMap<Integer,
                ArrayList<Integer>> map =
                new TreeMap<>();

        Queue<Pair3> queue =
                new LinkedList<>();

        queue.offer(new Pair3(root, 0));

        while (!queue.isEmpty()) {

            Pair3 p = queue.poll();

            map.putIfAbsent(
                    p.hd,
                    new ArrayList<>());

            map.get(p.hd)
                    .add(p.node.data);

            if (p.node.left != null)
                queue.offer(
                        new Pair3(
                                p.node.left,
                                p.hd - 1));

            if (p.node.right != null)
                queue.offer(
                        new Pair3(
                                p.node.right,
                                p.hd + 1));
        }

        for (ArrayList<Integer> list :
                map.values()) {

            System.out.println(list);
        }
    }

    public static void main(String[] args) {

        Node50 root = new Node50(1);

        root.left = new Node50(2);
        root.right = new Node50(3);

        root.left.left = new Node50(4);
        root.left.right = new Node50(5);

        verticalOrder(root);
    }
}
