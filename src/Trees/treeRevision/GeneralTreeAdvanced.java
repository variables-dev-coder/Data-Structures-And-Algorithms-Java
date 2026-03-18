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

public class GeneralTreeAdvanced {

    // DFS
    static void dfs(Node root) {

        if (root == null) return;

        System.out.print(root.val + " ");

        for (Node child : root.children) {
            dfs(child);
        }
    }

    // BFS
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

    // Count Nodes
    static int countNodes(Node root) {

        if (root == null) return 0;

        int count = 1;

        for (Node child : root.children) {
            count += countNodes(child);
        }

        return count;
    }

    // Height of Tree
    static int height(Node root) {

        if (root == null) return 0;

        int maxHeight = 0;

        for (Node child : root.children) {
            maxHeight = Math.max(maxHeight, height(child));
        }

        return maxHeight + 1;
    }

    public static void main(String[] args) {

        Node root = new Node(10);

        Node n20 = new Node(20);
        Node n30 = new Node(30);
        Node n40 = new Node(40);
        Node n50 = new Node(50);
        Node n60 = new Node(60);
        Node n70 = new Node(70);
        Node n80 = new Node(80);
        Node n90 = new Node(90);

        // Build tree
        root.children.add(n20);
        root.children.add(n30);
        root.children.add(n40);

        n20.children.add(n50);

        n30.children.add(n60);
        n30.children.add(n70);

        n60.children.add(n90);

        n40.children.add(n80);

        System.out.print("DFS: ");
        dfs(root);

        System.out.println();

        System.out.print("BFS: ");
        bfs(root);

        System.out.println();

        System.out.println("Total Nodes: " + countNodes(root));

        System.out.println("Height: " + height(root));
    }
}
