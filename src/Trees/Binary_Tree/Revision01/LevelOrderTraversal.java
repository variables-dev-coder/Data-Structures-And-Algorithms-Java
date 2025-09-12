package Trees.Binary_Tree.Revision01;

import java.util.*;

class Node3 {
    String data;
    List<Node3> children;

    Node3(String data) {
        this.data = data;
        this.children = new ArrayList<>();
    }
}

public class LevelOrderTraversal {
    static void levelOrder(Node3 root) {
        if (root == null) return;
        Queue<Node3> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node3 current = queue.poll();
            System.out.print(current.data + " "); // Visit node
            queue.addAll(current.children); // Add children
        }
    }

    public static void main(String[] args) {
        Node3 root = new Node3("A");
        Node3 b = new Node3("B");
        Node3 c = new Node3("C");
        Node3 d = new Node3("D");
        Node3 e = new Node3("E");

        root.children.add(b);
        root.children.add(c);
        root.children.add(d);
        c.children.add(e);

        System.out.println("Level Order Traversal:");
        levelOrder(root); // Output: A B C D E
    }
}

