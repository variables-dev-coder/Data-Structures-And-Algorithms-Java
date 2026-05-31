package revision7;

import java.util.*;

class Node10 {

    int data;
    Node10 left;
    Node10 right;

    Node10(int data) {
        this.data = data;
    }
}

public class RootToLeafPaths {

    static void printPaths(Node10 root,
                           ArrayList<Integer> path) {

        if (root == null) {
            return;
        }

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

        Node10 root = new Node10(1);

        root.left = new Node10(2);
        root.right = new Node10(3);

        root.left.left = new Node10(4);
        root.left.right = new Node10(5);

        printPaths(root,
                new ArrayList<>());
    }
}
