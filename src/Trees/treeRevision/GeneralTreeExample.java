package Trees.treeRevision;

import java.util.*;

class Node {
    int val;
    List<Node> children;

    Node(int val) {
        this.val = val;
        children = new ArrayList<>();
    }
}

public class GeneralTreeExample {

    // DFS (Preorder)
    static void dfs(Node root) {

        if (root == null) return;

        System.out.print(root.val + " ");

        for (Node child : root.children) {
            dfs(child);
        }
    }

    // BFS (Level Order)
    static void bfs(Node root) {

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {

            Node curr = q.poll();
            System.out.print(curr.val + " ");

            for (Node child : curr.children) {
                q.add(child);
            }
        }
    }

    public static void main(String[] args) {

        Node root = new Node(1);

        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);

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
