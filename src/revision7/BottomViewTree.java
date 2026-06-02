package revision7;

import java.util.*;

class Node13 {
    int data;
    Node13 left, right;

    Node13(int data) {
        this.data = data;
    }
}

class Pair2 {
    Node13 node;
    int hd;

    Pair2(Node13 node, int hd) {
        this.node = node;
        this.hd = hd;
    }
}

public class BottomViewTree {

    static void bottomView(Node13 root) {

        TreeMap<Integer, Integer> map =
                new TreeMap<>();

        Queue<Pair2> queue =
                new LinkedList<>();

        queue.offer(new Pair2(root, 0));

        while (!queue.isEmpty()) {

            Pair2 p = queue.poll();

            map.put(
                    p.hd,
                    p.node.data);

            if (p.node.left != null)
                queue.offer(
                        new Pair2(
                                p.node.left,
                                p.hd - 1));

            if (p.node.right != null)
                queue.offer(
                        new Pair2(
                                p.node.right,
                                p.hd + 1));
        }

        System.out.println(map.values());
    }

    public static void main(String[] args) {

        Node13 root = new Node13(1);

        root.left = new Node13(2);
        root.right = new Node13(3);

        root.left.left = new Node13(4);
        root.left.right = new Node13(5);

        bottomView(root);
    }
}
