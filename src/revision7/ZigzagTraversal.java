package revision7;

import java.util.*;

class Node11 {

    int data;
    Node11 left;
    Node11 right;

    Node11(int data) {
        this.data = data;
    }
}

public class ZigzagTraversal {

    static void zigzag(Node11 root) {

        Queue<Node11> queue =
                new LinkedList<>();

        queue.offer(root);

        boolean leftToRight = true;

        while (!queue.isEmpty()) {

            int size = queue.size();

            ArrayList<Integer> level =
                    new ArrayList<>();

            for (int i = 0; i < size; i++) {

                Node11 curr = queue.poll();

                level.add(curr.data);

                if (curr.left != null)
                    queue.offer(curr.left);

                if (curr.right != null)
                    queue.offer(curr.right);
            }

            if (!leftToRight) {
                Collections.reverse(level);
            }

            System.out.println(level);

            leftToRight = !leftToRight;
        }
    }

    public static void main(String[] args) {

        Node11 root = new Node11(1);

        root.left = new Node11(2);
        root.right = new Node11(3);

        root.left.left = new Node11(4);
        root.left.right = new Node11(5);

        zigzag(root);
    }
}
