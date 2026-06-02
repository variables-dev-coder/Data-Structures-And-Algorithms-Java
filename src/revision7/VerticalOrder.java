package revision7;

import java.util.*;

class Node14 {
    int data;
    Node14 left, right;

    Node14(int data) {
        this.data = data;
    }
}

class Pair3 {
    Node14 node;
    int hd;

    Pair3(Node14 node, int hd) {
        this.node = node;
        this.hd = hd;
    }
}

public class VerticalOrder {

    static void verticalOrder(Node14 root) {

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

        Node14 root = new Node14(1);

        root.left = new Node14(2);
        root.right = new Node14(3);

        root.left.left = new Node14(4);
        root.left.right = new Node14(5);

        verticalOrder(root);
    }
}
