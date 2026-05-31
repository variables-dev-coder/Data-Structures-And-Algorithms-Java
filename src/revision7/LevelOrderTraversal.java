package revision7;

import java.util.*;

class Node9 {
    int data;
    Node10 left, right;

    Node9(int data) {
        this.data = data;
    }
}

public class LevelOrderTraversal {

    static void levelOrder(Node10 root) {

        if (root == null) return;

        Queue<Node10> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {

            Node10 curr = q.poll();

            System.out.print(curr.data + " ");

            if (curr.left != null)
                q.offer(curr.left);

            if (curr.right != null)
                q.offer(curr.right);
        }
    }

    public static void main(String[] args) {

        Node10 root = new Node10(1);

        root.left = new Node10(2);
        root.right = new Node10(3);

        root.left.left = new Node10(4);
        root.left.right = new Node10(5);

        levelOrder(root);
    }
}
