package Trees.Binary_Tree.Revision01;

import java.util.*;

class Node2 {
    String data;
    List<Node2> children;

    Node2(String data) {
        this.data = data;
        this.children = new ArrayList<>();
    }
}

public class PreorderTraversal {
    static void preorder(Node2 root) {
        if (root == null) return;
        System.out.print(root.data + " "); // Visit root
        for (Node2 child : root.children) {
            preorder(child); // Recur for children
        }
    }

    public static void main(String[] args) {
        Node2 root = new Node2("A");
        Node2 b = new Node2("B");
        Node2 c = new Node2("C");
        Node2 d = new Node2("D");
        Node2 e = new Node2("E");

        root.children.add(b);
        root.children.add(c);
        root.children.add(d);
        c.children.add(e);

        System.out.println("Preorder Traversal:");
        preorder(root); // Output: A B C E D
    }
}

