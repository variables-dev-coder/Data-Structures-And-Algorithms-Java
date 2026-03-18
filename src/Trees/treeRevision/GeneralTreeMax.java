package Trees.treeRevision;

import java.util.*;

class Node3 {
    int val;
    List<Node3> children;

    Node3(int val) {
        this.val = val;
        children = new ArrayList<>();
    }
}

public class GeneralTreeMax {

    static int findMax(Node3 root) {

        if (root == null) return Integer.MIN_VALUE;

        int max = root.val;

        for (Node3 child : root.children) {

            int childMax = findMax(child);
            max = Math.max(max, childMax);
        }

        return max;
    }

    public static void main(String[] args) {

        Node3 root = new Node3(15);

        Node3 n3 = new Node3(3);
        Node3 n20 = new Node3(20);
        Node3 n7 = new Node3(7);
        Node3 n2 = new Node3(2);
        Node3 n5 = new Node3(5);
        Node3 n25 = new Node3(25);
        Node3 n30 = new Node3(30);

        // Build tree
        root.children.add(n3);
        root.children.add(n20);
        root.children.add(n7);

        n3.children.add(n2);
        n3.children.add(n5);

        n7.children.add(n25);
        n25.children.add(n30);

        System.out.println("Maximum Value: " + findMax(root));
    }
}
