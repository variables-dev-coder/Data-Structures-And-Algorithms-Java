package Trees.Binary_Tree.Binary_Tree_Traversals;

// Level-order Traversal (BFS) – Queue-based

import java.util.LinkedList;
import java.util.Queue;

class Node4 {
    int val;
    Node4 left, right;

    Node4(int v) {
        val = v; left = right = null;
    }
}

public class LevelOrderTraversal {
    static void levelOrder(Node4 root) {
        if (root == null) return;
        Queue<Node4> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node4 node = q.poll();
            System.out.print(node.val + " ");
            if (node.left != null) q.add(node.left);
            if (node.right != null) q.add(node.right);
        }
    }

    public static void main(String[] args) {
        Node4 root = new Node4(1);
        root.left = new Node4(2);
        root.right = new Node4(3);
        root.left.left = new Node4(4);
        root.left.right = new Node4(5);

        System.out.print("Level-order: ");
        levelOrder(root); // Output: 1 2 3 4 5
    }
}

// Level-order: 1 2 3 4 5
// Useful for printing tree level by level, BFS  problems.