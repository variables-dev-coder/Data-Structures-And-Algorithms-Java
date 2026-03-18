package Trees.treeRevision;

import java.util.*;

class Node2 {
    int val;
    List<Node2> children;

    Node2(int val) {
        this.val = val;
        children = new ArrayList<>();
    }
}

public class GeneralTreeExample {

    // DFS (Preorder)
    static void dfs(Node2 root) {

        if (root == null) return;

        System.out.print(root.val + " ");

        for (Node2 child : root.children) {
            dfs(child);
        }
    }

    // BFS (Level Order)
    static void bfs(Node2 root) {

        Queue<Node2> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {

            Node2 curr = q.poll();
            System.out.print(curr.val + " ");

            for (Node2 child : curr.children) {
                q.add(child);
            }
        }
    }

    public static void main(String[] args) {

        Node2 root = new Node2(1);

        Node2 n2 = new Node2(2);
        Node2 n3 = new Node2(3);
        Node2 n4 = new Node2(4);
        Node2 n5 = new Node2(5);
        Node2 n6 = new Node2(6);

        // Build tree
        root.children.add(n2);
        root.children.add(n3);
        root.children.add(n4);

        n3.children.add(n5);
        n3.children.add(n6);

        System.out.print("DFS: ");
        dfs(root);

        System.out.println();

        System.out.print("BFS: ");
        bfs(root);
    }
}
