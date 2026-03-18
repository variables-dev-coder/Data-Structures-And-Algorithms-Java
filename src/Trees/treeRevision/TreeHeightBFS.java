package Trees.treeRevision;

import java.util.*;

class Node4 {
    int val;
    List<Node4> children;

    Node4(int val) {
        this.val = val;
        children = new ArrayList<>();
    }
}

public class TreeHeightBFS {

    static int height(Node4 root) {

        if (root == null) return 0;

        Queue<Node4> q = new LinkedList<>();
        q.add(root);

        int height = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            for (int i = 0; i < size; i++) {

                Node4 curr = q.poll();

                for (Node4 child : curr.children) {
                    q.add(child);
                }
            }

            height++;
        }

        return height;
    }

    public static void main(String[] args) {

        Node4 root = new Node4(1);

        Node4 n2 = new Node4(2);
        Node4 n3 = new Node4(3);
        Node4 n4 = new Node4(4);
        Node4 n5 = new Node4(5);
        Node4 n6 = new Node4(6);
        Node4 n7 = new Node4(7);
        Node4 n8 = new Node4(8);

        // Build tree
        root.children.add(n2);
        root.children.add(n3);
        root.children.add(n4);

        n2.children.add(n5);
        n2.children.add(n6);

        n6.children.add(n8);

        n4.children.add(n7);

        System.out.println("Height: " + height(root));
    }
}
