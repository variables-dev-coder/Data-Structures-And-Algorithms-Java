package revision7;

import java.util.*;

class Node8 {
    int data;
    Node8 left, right;

    Node8(int d) {
        data = d;
    }
}

public class RootToLeaf {

    static void printPaths(Node8 root,
                           List<Integer> path) {

        if (root == null)
            return;

        path.add(root.data);

        if (root.left == null &&
                root.right == null) {

            System.out.println(path);
        }

        printPaths(root.left, path);
        printPaths(root.right, path);

        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {

        Node8 root = new Node8(1);

        root.left = new Node8(2);
        root.right = new Node8(3);

        root.left.left = new Node8(4);
        root.left.right = new Node8(5);

        printPaths(root,
                new ArrayList<>());
    }
}
