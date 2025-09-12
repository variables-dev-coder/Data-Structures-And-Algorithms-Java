package Trees.Binary_Tree.Revision01;

import java.util.*;

class Node1 {
    String data;
    List<Node1> children;

    Node1(String data) {
        this.data = data;
        this.children = new ArrayList<>();
    }
}

public class PostorderTraversal {
    static void postorder(Node1 root) {
        if (root == null) return;
        for (Node1 child : root.children) {
            postorder(child); // Visit children first
        }
        System.out.print(root.data + " "); // Visit root
    }

    public static void main(String[] args) {
        Node1 root = new Node1("A");
        Node1 b = new Node1("B");
        Node1 c = new Node1("C");
        Node1 d = new Node1("D");
        Node1 e = new Node1("E");

        root.children.add(b);
        root.children.add(c);
        root.children.add(d);
        c.children.add(e);

        System.out.println("Postorder Traversal:");
        postorder(root); // Output: B E C D A
    }
}

